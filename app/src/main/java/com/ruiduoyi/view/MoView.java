package com.ruiduoyi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Chen on 2018-10-15.
 */

public class MoView extends View {

    private int mWidth;
    private int mHeight;
    private float rectStartX;
    private float rectStartY;
    private float bigRectHeight;
    private Paint mRectPaint;
    private float rectWidth = 30;
    private float smallRectHeight;
    private int smallRectStartY;
    private int bigRectStartY;

    Path path1;
    private int rectStartX2;
    private int rectStartX3;
    private int rectStartX4;
    private Paint mRectPaint2;
    private int size = 40;
    private String hmText_S = "123";
    private String hmText_B = "345";
    private String hwText_S = "456";
    private String hwText_B = "567";
    private String qmText_S = "43";
    private String qmText_B = "12";
    private String ywText = "油温:\t50℃";

    public void setData(String hmText_S,String hmText_B,String hwText_S,String hwText_B,String qmText_S,String qmText_B,String ywText){
        this.hmText_S = hmText_S;
        this.hmText_B = hmText_B;
        this.hwText_S = hwText_S;
        this.hwText_B = hwText_B;
        this.qmText_S = qmText_S;
        this.qmText_B = qmText_B;
        this.ywText = ywText;
        invalidate();
    }

    public MoView(Context context) {
        this(context,null);
    }

    public MoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        int tW = mWidth / 4;
        int tH = mHeight / 8;
        //第一部分
        rectStartX = 20;//第一部分x起点
        bigRectStartY = tH;//大框Y轴起点
        smallRectStartY = tH * 3;//小框Y轴起点
        bigRectHeight = tH * 6;//大框高度
        smallRectHeight  = tH * 2;//小框高度
        //第二部分
        rectStartX2 = tW * 1;

        //第二部分
        rectStartX3 = tW * 2;

        rectStartX4 = tW * 3;
    }

    private void init(Context context) {
        mRectPaint = new Paint();
        mRectPaint.setStrokeWidth(2);
        mRectPaint.setStyle(Paint.Style.STROKE);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画四个方框
        canvas.drawRect(rectStartX,bigRectStartY,rectStartX+rectWidth,(bigRectStartY+bigRectHeight),mRectPaint);
        canvas.drawRect(rectStartX+(rectWidth * 1),smallRectStartY,rectStartX+(rectWidth * 2),(smallRectStartY+smallRectHeight),mRectPaint);
        canvas.drawRect(rectStartX+(rectWidth * 2),bigRectStartY,rectStartX+(rectWidth * 3),(bigRectStartY+bigRectHeight),mRectPaint);
        canvas.drawRect(rectStartX+(rectWidth * 3),smallRectStartY,rectStartX+(rectWidth * 4),(smallRectStartY+smallRectHeight),mRectPaint);



        Paint mRectPaint2 = new Paint();
        mRectPaint2.setStrokeWidth(2);
        mRectPaint2.setStyle(Paint.Style.STROKE);
        Path path2 = new Path();
        path2.moveTo(rectStartX2,0);
        path2.lineTo(rectStartX2,mHeight);
        path2.lineTo(rectStartX2 + (size *2),mHeight);
        path2.lineTo(rectStartX2 + (size *2),mHeight-(size *1));
        path2.lineTo(rectStartX2 + (size *3),mHeight-(size *1));
        path2.lineTo(rectStartX2 + (size *3),(size *1));
        path2.lineTo(rectStartX2 + (size *2),(size *1));
        path2.lineTo(rectStartX2 + (size *2),0);
        path2.lineTo(rectStartX2,0);
        canvas.drawPath(path2,mRectPaint2);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(15);
        textPaint.setAntiAlias(true);
        String hmStr = "后模温Tm/F";
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
       // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        Rect textRect = new Rect();
        textPaint.getTextBounds(hmStr, 0, hmStr.length(), textRect);
        int hmTextSizeWidth = textRect.width();
        int hmTextSizeHeight = textRect.height();
        canvas.drawText(hmStr,rectStartX2+5,hmTextSizeHeight+15,textPaint);
        Rect r2 = new Rect(rectStartX2+5,mHeight/2-15,rectStartX2+35,mHeight/2+15);
        Rect r3 = new Rect(rectStartX2+35,mHeight/2-15,rectStartX2+65,mHeight/2+15);
        canvas.drawRect(r2,mRectPaint2);
        //画蓝色参数框
        Paint paintBlue = new Paint();
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setColor(Color.GREEN);
        canvas.drawRect(r3,mRectPaint2);
        canvas.drawRect(r3,paintBlue);

        canvas.drawText(hmText_S,rectStartX2+8,mHeight/2+hmTextSizeHeight/2,textPaint);
        canvas.drawText(hmText_B,rectStartX2+38,mHeight/2+hmTextSizeHeight/2,textPaint);
        //画正负10
        /*Paint textPaint2 = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(13);
        textPaint.setAntiAlias(true);*/
        String str2 = "±10℃";
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
        // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        Rect textRect2 = new Rect();
        textPaint.getTextBounds(hmStr, 0, hmStr.length(), textRect);
        int str2TextSizeWidth = textRect.width();
        int str2TextSizeHeight = textRect.height();
        canvas.drawText(str2,rectStartX2+65,mHeight/2+str2TextSizeHeight/2,textPaint);

        //第三部分
        Paint mRectPaint3 = new Paint();
        mRectPaint3.setStrokeWidth(2);
        mRectPaint3.setStyle(Paint.Style.STROKE);
        Path path3 = new Path();
        path3.moveTo(rectStartX3,0);
        path3.lineTo(rectStartX3,(size *1));
        path3.lineTo(rectStartX3 + (size *1),(size *1));
        path3.lineTo(rectStartX3 + (size *1),(size *2));
        path3.lineTo(rectStartX3 + (size *3),(size *2));
        path3.lineTo(rectStartX3 + (size *3),0);
        path3.close();
        canvas.drawPath(path3,mRectPaint3);

        /*Paint textPaint3 = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(10);
        textPaint.setAntiAlias(true);*/
        String hwStr = "行位温";
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
        // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        Rect textRect3 = new Rect();
        textPaint.getTextBounds(hwStr, 0, hwStr.length(), textRect3);
        int hwStrTextSizeWidth = textRect.width();
        int hwStrTextSizeHeight = textRect.height();
        canvas.drawText(hwStr,rectStartX3+5,hmTextSizeHeight+5,textPaint);
        //算出框的中心，再定位左上角和右下角，
        Rect r4 = new Rect(rectStartX3+45,mHeight/3-10,rectStartX3+75,mHeight/3+20);
        Rect r5 = new Rect(rectStartX3+75,mHeight/3-10,rectStartX3+105,mHeight/3+20);
        canvas.drawRect(r4,mRectPaint2);
        //画蓝色参数框
        /*Paint paintBlue = new Paint();
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setColor(Color.GREEN);*/
        canvas.drawRect(r5,mRectPaint2);
        canvas.drawRect(r5,paintBlue);
        canvas.drawText(hwText_S,rectStartX3+48,mHeight/3+hmTextSizeHeight/2+5,textPaint);
        canvas.drawText(hwText_B,rectStartX3+78,mHeight/3+hmTextSizeHeight/2+5,textPaint);
        Rect ywTextRect = new Rect();
        textPaint.getTextBounds(ywText, 0, ywText.length(), ywTextRect);
        int ywTextSizeWidth = ywTextRect.width();
        canvas.drawText(ywText,rectStartX3+rectStartX2/2-ywTextSizeWidth/2,mHeight-5,textPaint);
        //画正负10
        /*Paint textPaint2 = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(13);
        textPaint.setAntiAlias(true);
        String str3 = "±10℃";*/
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
        // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        /*Rect textRect4 = new Rect();
        textPaint3.getTextBounds(hmStr, 0, hmStr.length(), textRect);
        int str2TextSizeWidth = textRect.width();
        int str2TextSizeHeight = textRect.height();*/
        canvas.drawText(str2,rectStartX3+65,mHeight/3+30+str2TextSizeHeight/2,textPaint);

        //第四部分
        Paint mRectPaint4 = new Paint();
        mRectPaint4.setStrokeWidth(2);
        mRectPaint4.setStyle(Paint.Style.STROKE);
        Path path4 = new Path();
        path4.moveTo(rectStartX4,0);
        path4.lineTo(rectStartX4,(size *1));
        path4.lineTo(rectStartX4 + (size *1),(size *1));
        path4.lineTo(rectStartX4 + (size *1),mHeight-(size *1));
        path4.lineTo(rectStartX4 ,mHeight-(size *1));
        path4.lineTo(rectStartX4 ,mHeight);
        path4.lineTo(rectStartX4 + (size *3),mHeight);
        path4.lineTo(rectStartX4 + (size *3),0);
        path4.close();
        canvas.drawPath(path4,mRectPaint4);

        /*Paint textPaint4 = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(10);
        textPaint.setAntiAlias(true);*/
        String qmStr = "前模温Tm/f";
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
        // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        Rect textRect4 = new Rect();
        textPaint.getTextBounds(qmStr, 0, qmStr.length(), textRect4);
        int qmStrTextSizeWidth = textRect.width();
        int qmStrTextSizeHeight = textRect.height();
        canvas.drawText(qmStr,rectStartX4+5,hmTextSizeHeight+5,textPaint);
        Rect r6 = new Rect(rectStartX4+45,mHeight/3-10,rectStartX4+75,mHeight/3+20);
        Rect r7 = new Rect(rectStartX4+75,mHeight/3-10,rectStartX4+105,mHeight/3+20);
        canvas.drawRect(r6,mRectPaint2);
        //画蓝色参数框
        /*Paint paintBlue = new Paint();
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setColor(Color.GREEN);*/
        canvas.drawRect(r7,mRectPaint2);
        canvas.drawRect(r7,paintBlue);
        canvas.drawText(qmText_S,rectStartX4+48,mHeight/3+hmTextSizeHeight/2+5,textPaint);
        canvas.drawText(qmText_B,rectStartX4+78,mHeight/3+hmTextSizeHeight/2+5,textPaint);
        //画正负10
        /*Paint textPaint2 = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(13);
        textPaint.setAntiAlias(true);
        String str3 = "±10℃";*/
        //float  hmTextSizeWidth = textPaint.measureText(hmStr);
        // float hmTextSizeHeight = textPaint.getFontMetrics().bottom;
        /*Rect textRect4 = new Rect();
        textPaint3.getTextBounds(hmStr, 0, hmStr.length(), textRect);
        int str2TextSizeWidth = textRect.width();
        int str2TextSizeHeight = textRect.height();*/
        canvas.drawText(str2,rectStartX4+65,mHeight/3+30+str2TextSizeHeight/2,textPaint);
    }
}
