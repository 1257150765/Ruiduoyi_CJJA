package com.ruiduoyi.model;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.ruiduoyi.utils.AppUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/03/04.
 */
public class NetHelper {
    private static Date tsTime;
    private static SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static String TAG;
    private static String ErrorMsg;
    private static boolean isDebug=false;
    private static String displayMsg = "";
    private static String cSqlCommand = " exec PAD_SrvDataUp ";
    private static String NAMESPACE = "http://zblog.vicp.net/";
    public static  String URL = "";
    private static String METHOD_NAME = "runSqlCommand";
    private static String SOAP_ACTION = "http://zblog.vicp.net/runSqlCommand";
    public static Context context;

    // 判断网络是否有连接
    public static boolean isNetworkConnected(Context context){
        TAG = "NetHelper.isWiFiConnected";
        if (context != null){
            try{
                ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = manager.getActiveNetworkInfo();
                if (networkInfo != null){
                    return networkInfo.isAvailable();
                }
            }catch (Exception e){
                Log.e(TAG, e.getMessage());
            }
        }
        return false;
    }

    // 判断WiFi是否已连接
    public static boolean isWiFiConnected(Context context){
        TAG = "NetHelper.isWiFiConnected";
        try{
            if (context != null){
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null) {
                    int type = netInfo.getType();
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        return true;
                    }
                }
            }
        }catch (Exception e){
            ErrorMsg = "Run isWiFiConnected error!" + e.getMessage();
            Log.e(TAG, ErrorMsg);
            //FileHelper.WriteLog(ErrorMsg);
        }
        return false;
    }

    // Run webservice
    // 这个方法在闲置一段时间没有上传时,再次上传第一次会报 ECONNRESET (Connection reset by peer) 错误
    // 改为用 HttpsqlExec 方法.
    public static boolean sqlExec(String sqlCommand){
        TAG = "NetHelper.sqlExec";
        try{
            SoapObject rpc = new SoapObject(NAMESPACE, METHOD_NAME);
            rpc.addProperty("SqlCommand", sqlCommand);
            rpc.addProperty("Password", "nopassword");

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;

            HttpTransportSE ht = new HttpTransportSE(URL,5000);
            ht.debug = true;
            ht.call(SOAP_ACTION, envelope);

            Object object = envelope.getResponse();

            displayMsg = "";
            String resultArray[] = object.toString().split("\n");
            displayMsg = object.toString();
            //Log.d(TAG, displayMsg);

            if(resultArray[0].equals("SUCCESS!"))
            {
                if(isDebug) {
                Log.d(TAG, "SQL语句执行成功!");
            }
            }
            else
            {
                String lcErrMsg = "SQL语句失败, 错误原因:\n" + displayMsg;
                Log.e(TAG, lcErrMsg);
                FileHelper.WriteLog(TAG + "\t" + lcErrMsg);
                return false;
            }
            return true;
        }
        catch (Exception e){
            FileHelper.WriteLog(TAG + "\tAndroid run webservice error!" + e.getMessage());
            FileHelper.WriteLog(TAG + "\tRef:" + URL + "\t" + sqlCommand);
            Log.e(TAG,"Android run webservice error!");
            Log.e(TAG, URL);
            Log.e(TAG, sqlCommand);
            e.printStackTrace();
        }
        finally {
        }
        return false;
    }





    //判断url是否合法
    public static boolean isUrl(String url_str){
        try {
            URL url=new URL(url_str);
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //判断服务器是否开启
    public static boolean isServerConnected(String cHttpAddress){
        JSONArray list=getQuerysqlResultJsonArray("select getDate()");
        if (list!=null){
            return true;
        }else {
            return false;
        }
    }

    // 测试WIFI是否开启,IP地址是否可以连通
    public static void checkNetworkStatus(String cHttpAddress){
        TAG = "NetHelper.checkNetworkStatus";
        String ErrMsg = "";
        try{
            if (true){
                ErrMsg = "WiFi test OK, status : Connected";
                FileHelper.WriteLog(TAG + "\t" + ErrMsg);
                Log.d(TAG, ErrMsg);
            }else{
                ErrMsg = "WiFi test failed, status : Disconnected";
                FileHelper.WriteLog(TAG + "\t" + ErrMsg);
                Log.e(TAG, ErrMsg);
            }
            if (isServerConnected(cHttpAddress)){
                ErrMsg = "Server " + cHttpAddress + " test OK, connection test passed!";
                FileHelper.WriteLog(TAG + "\t" + ErrMsg);
                Log.d(TAG, ErrMsg);
            }else{
                ErrMsg = "Server " + cHttpAddress + " test Error, Please check your network!";
                FileHelper.WriteLog(TAG + "\t" + ErrMsg);
                Log.e(TAG, ErrMsg);
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }


    //执行增删改sql操作
    // Run webservice by Http Get
    public static boolean HttpSqlExec(String sqlCommand){
        TAG = "NetHelper.HttpsqlExec";
        try{
            if (sqlCommand == null || sqlCommand.isEmpty()){
                return false;
            }
            String cHttpAddress = URL+"/runSqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            HttpGet request = new HttpGet(cHttpAddress);
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
            HttpClient httpClient = new DefaultHttpClient(httpParams);
            HttpResponse response = httpClient.execute(request);
            responToString(response);
            int status = response.getStatusLine().getStatusCode();
            if (status == 200){
                BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                int nTtlLine = 0;
                ArrayList resultArray = new ArrayList();
                displayMsg = "";
                for (String s = bf.readLine(); s!=null; s=bf.readLine()){
                    nTtlLine++;
                    if (nTtlLine == 1) continue;
                    if (nTtlLine == 2) s = s.replace("<string xmlns=\"http://zblog.vicp.net/\">","");
                    resultArray.add(s);
                    displayMsg += s + "\n";
                }
                if (resultArray.size() > 0){
                    resultArray.set(resultArray.size() - 1, resultArray.get(resultArray.size() - 1).toString().replace("</string>",""));
                }
                if(resultArray.get(0).toString().equals("SUCCESS!"))
                {
                    Log.e(TAG, resultArray.toString());
                    if(isDebug) {
                        Log.d(TAG, "SQL语句执行成功!");
                    }
                }
                else
                {
                    String lcErrMsg = "SQL语句失败, 错误原因:\n" + displayMsg;
                    Log.e(TAG, lcErrMsg);
                    FileHelper.WriteLog(TAG + "\t" + lcErrMsg);
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            String ErrMsg = "Request " + sqlCommand + " error: "+e.getMessage();
            Log.e(TAG, ErrMsg);
            FileHelper.WriteLog(ErrMsg);
            return false;
        }
    }

    //获取查询结果集HttpUrlConnection
    public static List<List<String>>getQuerysqlResult2(String sqlCommand){
        try {
            String cHttpAddress = URL+"/QuerySqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            URL url=new URL(cHttpAddress);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream in=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            byte[] buff=new byte[1024];
            int size;
            StringBuffer sb=new StringBuffer();
            while ((size = in.read(buff)) != -1) {
                sb.append(new String(buff));
            }
            String result=sb.toString() .trim();
            in.close();
            reader.close();
            return StringToList(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取查询结果集HttpClient
    public static List<List<String>>getQuerysqlResult(String sqlCommand){
        try{
            String cHttpAddress = URL+"/QuerySqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            HttpGet request = new HttpGet(cHttpAddress);
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
            HttpClient httpClient = new DefaultHttpClient(httpParams);
            HttpResponse response = httpClient.execute(request);
            Log.e("sql",sqlCommand);
            return responToString(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    public static boolean getRunsqlResult2(String sqlCommand){
        try{
            String cHttpAddress = URL+"/runSqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            URL url=new URL(cHttpAddress);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream in=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            byte[] buff=new byte[1024];
            int size;
            StringBuffer sb=new StringBuffer();
            while ((size = in.read(buff)) != -1) {
                sb.append(new String(buff));
            }
            String result=sb.toString() .trim();
            String[] temp=result.split("\n");
            String isSeccess=temp[1].substring(temp[1].length()-8,temp[1].length()-1);
           // Log.e("sql",result);
            if (isSeccess.equals("SUCCESS")){
                return true;
            }else {
                return false;
            }
        } catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean getRunsqlResult(String sqlCommand){
        try{
            String cHttpAddress = URL+"/runSqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            HttpGet request = new HttpGet(cHttpAddress);
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
            HttpClient httpClient = new DefaultHttpClient(httpParams);
            HttpResponse response = httpClient.execute(request);
            Log.e("sql",sqlCommand);
            HttpEntity entity = response.getEntity();
            String result=EntityUtils.toString(entity);
            String[] temp=result.split("\n");
            String isSeccess=temp[1].substring(temp[1].length()-8,temp[1].length()-1);
            // Log.e("sql",result);
            if (isSeccess.equals("SUCCESS")){
                return true;
            }else {
                return false;
            }
        } catch (SocketTimeoutException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //将服务器返回数据转换成list集合
    public static List<List<String>> responToString(HttpResponse response) throws IOException {
        List<List<String>>tab_list=new ArrayList<>();
        HttpEntity entity = response.getEntity();
        String result=EntityUtils.toString(entity);
        Log.e("result",result);
        if (AppUtils.calculate(result,"\n")>100){
            return null;
        }
        String[] str_line=result.split("\n");
        for (int i=0;i<str_line.length;i++){
            if (i>100){
                break;
            }
            //Log.e("result",str_line[i]);
            if(i>3&i<str_line.length-1){
                String temp=str_line[i]+" ";
                if (AppUtils.calculate(temp,"\t")>100){
                    return null;
                }
                String[] items=temp.split("\t");
                List<String>tab_item=new ArrayList<>();
                for(int j=0;j<items.length;j++){
                    if (j>100){
                        break;
                    }
                    tab_item.add(items[j].trim());
                    //Log.e("item",items[j]);
                    //Log.e("test","--------"+j);
                }
                tab_list.add(tab_item);
            }
        }
        return tab_list;
    }



    public static List<List<String>> StringToList(String result) {
        List<List<String>>tab_list=new ArrayList<>();
        Log.e("result",result);
        if (AppUtils.calculate(result,"\n")>100){
            Log.e("out of size",result.indexOf("\n")+"");
            return null;
        }
        String[] str_line=result.split("\n");
        for (int i=0;i<str_line.length;i++){
            if (i>100){
                break;
            }
            //Log.e("result",str_line[i]);
            if(i>3&i<str_line.length-1){
                String temp=str_line[i]+" ";
                if (AppUtils.calculate(temp,"\t")>100){
                    Log.e("out of size",result.indexOf("\t")+"");
                    return null;
                }
                String[] items=temp.split("\t");
                List<String>tab_item=new ArrayList<>();
                for(int j=0;j<items.length;j++){
                    if (j>100){
                        break;
                    }
                    tab_item.add(items[j].trim());
                    //Log.e("item",items[j]);
                    //Log.e("test","--------"+j);
                }
                tab_list.add(tab_item);
            }
        }
        return tab_list;
    }


    //返回JsonArray
    public static JSONArray getQuerysqlResultJsonArray(String sqlCommand){
        try{
            String cHttpAddress = URL+"/QuerySqlCommand?SqlCommand="+ URLEncoder.encode(sqlCommand,"utf-8")+"&Password=nopassword";
            HttpGet request = new HttpGet(cHttpAddress);
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
            HttpClient httpClient = new DefaultHttpClient(httpParams);
            HttpResponse response = httpClient.execute(request);
           /*HttpURLConnection conn = (HttpURLConnection) new URL(cHttpAddress).openConnection();
            InputStream is = conn.getInputStream();
            byte[] buff = new byte[1024];
            int len = -1;
            StringBuilder sb = new StringBuilder();
            while((len = is.read(buff)) != -1){
                sb.append(new String(buff,0,len));
            }
            is.close();
            conn.disconnect();*/
            Log.e("sql",sqlCommand);
            HttpEntity entity = response.getEntity();
            String result=EntityUtils.toString(entity);
            return responToJsonArray(result);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //将服务器返回数据转换成JsonArray
    public static JSONArray responToJsonArray(String result) throws IOException, JSONException {
        List<List<String>>tab_list=new ArrayList<>();
        JSONArray array=new JSONArray();
        List<String>zd_list=new ArrayList<>();

        Log.e("result",result);
        /*if (AppUtils.calculate(result,"\n")>200){
            return null;
        }*/
        String[] str_line=result.split("\n");
        for (int i=0;i<str_line.length;i++){
            if (i>200){
                break;
            }
            //Log.e("result",str_line[i]);
            if (i==3){
                String temp=str_line[i]+" ";
                if (AppUtils.calculate(temp,"\t")>100){
                    return null;
                }
                String[] items=temp.split("\t");
                for(int j=0;j<items.length;j++){
                    if (j>100){
                        break;
                    }
                    if (j+1==items.length){
                        break;
                    }
                    zd_list.add(items[j+1].trim());
                    //Log.e("item",items[j]);
                    //Log.e("test","--------"+j);
                }

            }


            if(i>3&i<str_line.length-1){
                String temp=str_line[i]+" ";
                if (AppUtils.calculate(temp,"\t")>100){
                    return null;
                }
                String[] items=temp.split("\t");
                List<String>tab_item=new ArrayList<>();
                for(int j=0;j<items.length;j++){
                    if (j>100){
                        break;
                    }
                    tab_item.add(items[j].trim());
                    //Log.e("item",items[j]);
                    //Log.e("test","--------"+j);
                }
                tab_list.add(tab_item);
            }
        }
        for (int i=0;i<tab_list.size();i++){
            List<String>item=tab_list.get(i);
            JSONObject jsonObject=new JSONObject();
            for (int j=0;j<item.size();j++){
                jsonObject.put(zd_list.get(j),item.get(j));
            }
            array.put(jsonObject);
        }
        return array;
    }

    //将服务器返回数据转换成JsonArray集合（支持多表算法）
    public static List<JSONArray> responToJsonArrayList(HttpResponse response) throws JSONException, IOException {
        List<JSONArray>listJsonAray=new ArrayList<>();
        int tabNum=0;
        List<String>tabNumList=new ArrayList<>();
        HttpEntity entity=response.getEntity();
        String result=EntityUtils.toString(entity);
        String formatStr="";
        String[] resultLine=new String[]{};
        if (AppUtils.calculate(result,"\n")>300){
            return null;
        }else {
            resultLine=result.split("\n");
        }
        for (int i=0;i<resultLine.length;i++){
            if (i>2&&i<resultLine.length-1){
                formatStr=formatStr+resultLine[i]+"\n";
            }
        }
        tabNum=Integer.parseInt(resultLine[2]);
        for (int i=1;i<tabNum+1;i++){
            tabNumList.add("[!(Table"+i+")!]");
        }
        for (int g=0;g<tabNumList.size();g++){
            formatStr=formatStr.replace(tabNumList.get(g),"\r");
        }
        String[] tableStr=formatStr.split("\r");
        if (tableStr.length<1){
            return null;
        }
        for (int k=1;k<tableStr.length;k++){
            String[] str_line=tableStr[k].split("\n");
            List<List<String>>listItems=new ArrayList<>();
            for (int i=0;i<str_line.length;i++){
                List<String>listItem=new ArrayList<>();
                if (AppUtils.calculate(str_line[i],"t")>100){
                    return null;
                }
                String[] items=(str_line[i]+" ").split("\t");
                for (int j=0;j<items.length;j++){
                    listItem.add(items[j].trim());
                }
                listItems.add(listItem);
            }
            List<String>zd_list=listItems.get(0);
            if (zd_list.size()>0){
                zd_list.remove(0);
            }else {
                return null;
            }
            JSONArray array=new JSONArray();
            for (int i=1;i<listItems.size();i++){
                List<String>item=listItems.get(i);
                JSONObject jsonObject=new JSONObject();
                for (int j=0;j<item.size();j++){
                    jsonObject.put(zd_list.get(j),item.get(j));
                }
                array.put(jsonObject);
            }
            listJsonAray.add(array);
        }

        return listJsonAray;

    }


    //上传网络错误log
    public static void uploadNetworkError(String errms,String jtbh,String mac){
        NetHelper.getQuerysqlResultJsonArray("Exec PAD_Add_PadLogInfo '7','"+errms+"','"+jtbh+"','"+mac+"'");
    }


    //上传异常崩溃信息
    public static boolean uploadErrorMsg(String errms,String jtbh,String mac,String code){
        String sql="Exec PAD_Add_PadLogInfo '"+code+"','"+errms+"','"+jtbh+"','"+mac+"'";
        boolean result=NetHelper.getRunsqlResult(sql);
        Log.e("","");
        return result;
    }



    //根据url地址下载文件
    public static void downLoadFileByUrl(String url_str,String filePath,String fileName) throws IOException {
        URL url= null;
        File file=new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        url = new URL(url_str);
        HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(5000);
        urlConnection.connect();
        Log.e("getLastModified()",urlConnection.getLastModified()+"");
        InputStream in=urlConnection.getInputStream();
        OutputStream out=new FileOutputStream(filePath+"/"+fileName,false);
        byte[] buff=new byte[1024];
        int size;
        while ((size = in.read(buff)) != -1) {
            out.write(buff, 0, size);
        }
    }


    public static void DownLoadFileByUrl(String url_str,String filePath,String fileName){
        URL url= null;
        try {
            File file=new File(filePath);
            if (!file.exists()){
                file.mkdir();
            }
            url = new URL(url_str);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != 200){
                return;
            }
            InputStream in=urlConnection.getInputStream();
            File f = new File(filePath +"/"+fileName);
            if (f.exists()){
                f.delete();
            }
            OutputStream out=new FileOutputStream(filePath +"/"+fileName,false);
            byte[] buff=new byte[1024];
            int size;
            while ((size = in.read(buff)) != -1) {
                out.write(buff, 0, size);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}


