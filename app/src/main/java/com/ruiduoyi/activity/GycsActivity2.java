package com.ruiduoyi.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ruiduoyi.R;
import com.ruiduoyi.adapter.EasyArrayAdapter;
import com.ruiduoyi.model.NetHelper;
import com.ruiduoyi.utils.AppUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GycsActivity2 extends BaseActivity {
    @BindView(R.id.tv_mjbh)
    TextView tvMjbh;
    @BindView(R.id.tv_xs)
    TextView tvXs;
    @BindView(R.id.tv_mjcc)
    TextView tvMjcc;
    @BindView(R.id.tv_jh)
    TextView tvJh;
    @BindView(R.id.tv_jtdw)
    TextView tvJtdw;
    @BindView(R.id.tv_wldm)
    TextView tvWldm;
    @BindView(R.id.tv_cpmc)
    TextView tvCpmc;
    @BindView(R.id.tv_slmc)
    TextView tvSlmc;
    @BindView(R.id.tv_slys)
    TextView tvSlys;
    @BindView(R.id.tv_cxdz)
    TextView tvCxdz;
    @BindView(R.id.tv_rjd_lab1)
    TextView tvRjdLab1;
    @BindView(R.id.tv_rjd_lab2)
    TextView tvRjdLab2;
    @BindView(R.id.tv_rjd_lab3)
    TextView tvRjdLab3;
    @BindView(R.id.tv_rjd_lab4)
    TextView tvRjdLab4;
    @BindView(R.id.tv_rjd_lab5)
    TextView tvRjdLab5;
    @BindView(R.id.tv_rjd_lab6)
    TextView tvRjdLab6;
    @BindView(R.id.tv_rjd_lab7)
    TextView tvRjdLab7;
    @BindView(R.id.tv_rjd_lab8)
    TextView tvRjdLab8;
    @BindView(R.id.tv_rjd_lab9)
    TextView tvRjdLab9;
    @BindView(R.id.tv_rjd_lab10)
    TextView tvRjdLab10;
    @BindView(R.id.tv_rjd_lab11)
    TextView tvRjdLab11;
    @BindView(R.id.tv_rjd_lab12)
    TextView tvRjdLab12;
    @BindView(R.id.tv_cx_lab1)
    TextView tvCxLab1;
    @BindView(R.id.tv_cx_lab2)
    TextView tvCxLab2;
    @BindView(R.id.tv_cx_lab3)
    TextView tvCxLab3;
    @BindView(R.id.tv_cx_lab4)
    TextView tvCxLab4;
    @BindView(R.id.tv_cx_lab5)
    TextView tvCxLab5;
    @BindView(R.id.tv_jx_lab1)
    TextView tvJxLab1;
    @BindView(R.id.tv_jx_lab2)
    TextView tvJxLab2;
    @BindView(R.id.tv_jx_lab3)
    TextView tvJxLab3;
    @BindView(R.id.tv_jx_lab4)
    TextView tvJxLab4;
    @BindView(R.id.tv_jx_lab5)
    TextView tvJxLab5;
    @BindView(R.id.tv_klfs)
    TextView tvKlfs;
    @BindView(R.id.tv_jx_wd)
    TextView tvJxWd;
    @BindView(R.id.tv_sj)
    TextView tvSj;
    @BindView(R.id.tv_hen)
    TextView tvHen;
    @BindView(R.id.tv_hn1)
    TextView tvHn1;
    @BindView(R.id.tv_hn2)
    TextView tvHn2;
    @BindView(R.id.tv_hn3)
    TextView tvHn3;
    @BindView(R.id.tv_hn4)
    TextView tvHn4;
    @BindView(R.id.tv_ejection_lab1)
    TextView tvEjectionLab1;
    @BindView(R.id.tv_ejection_lab2)
    TextView tvEjectionLab2;
    @BindView(R.id.tv_ejection_lab3)
    TextView tvEjectionLab3;
    @BindView(R.id.tv_ejection_lab4)
    TextView tvEjectionLab4;
    @BindView(R.id.tv_ejection_lab5)
    TextView tvEjectionLab5;
    @BindView(R.id.tv_ejection_lab6)
    TextView tvEjectionLab6;
    @BindView(R.id.tv_ejection_lab7)
    TextView tvEjectionLab7;
    @BindView(R.id.tv_ejection_lab8)
    TextView tvEjectionLab8;
    @BindView(R.id.tv_ejection_lab9)
    TextView tvEjectionLab9;
    @BindView(R.id.tv_ejection_lab10)
    TextView tvEjectionLab10;
    @BindView(R.id.tv_ejection_lab11)
    TextView tvEjectionLab11;
    @BindView(R.id.tv_ejection_lab12)
    TextView tvEjectionLab12;
    @BindView(R.id.tv_ejection_lab13)
    TextView tvEjectionLab13;
    @BindView(R.id.tv_ejection_lab14)
    TextView tvEjectionLab14;
    @BindView(R.id.tv_ejection_lab15)
    TextView tvEjectionLab15;
    @BindView(R.id.tv_ejection_lab16)
    TextView tvEjectionLab16;
    @BindView(R.id.tv_ejection_lab17)
    TextView tvEjectionLab17;
    @BindView(R.id.tv_ejection_lab18)
    TextView tvEjectionLab18;
    @BindView(R.id.tv_closing_lab1)
    TextView tvClosingLab1;
    @BindView(R.id.tv_closing_lab2)
    TextView tvClosingLab2;
    @BindView(R.id.tv_closing_lab3)
    TextView tvClosingLab3;
    @BindView(R.id.tv_closing_lab4)
    TextView tvClosingLab4;
    @BindView(R.id.tv_closing_lab5)
    TextView tvClosingLab5;
    @BindView(R.id.tv_closing_lab6)
    TextView tvClosingLab6;
    @BindView(R.id.tv_closing_lab7)
    TextView tvClosingLab7;
    @BindView(R.id.tv_closing_lab8)
    TextView tvClosingLab8;
    @BindView(R.id.tv_closing_lab9)
    TextView tvClosingLab9;
    @BindView(R.id.tv_closing_lab10)
    TextView tvClosingLab10;
    @BindView(R.id.tv_closing_lab11)
    TextView tvClosingLab11;
    @BindView(R.id.tv_closing_lab12)
    TextView tvClosingLab12;
    @BindView(R.id.tv_closing_lab13)
    TextView tvClosingLab13;
    @BindView(R.id.tv_closing_lab14)
    TextView tvClosingLab14;
    @BindView(R.id.tv_closing_lab15)
    TextView tvClosingLab15;
    @BindView(R.id.tv_opening_lab1)
    TextView tvOpeningLab1;
    @BindView(R.id.tv_opening_lab2)
    TextView tvOpeningLab2;
    @BindView(R.id.tv_opening_lab3)
    TextView tvOpeningLab3;
    @BindView(R.id.tv_opening_lab4)
    TextView tvOpeningLab4;
    @BindView(R.id.tv_opening_lab5)
    TextView tvOpeningLab5;
    @BindView(R.id.tv_opening_lab6)
    TextView tvOpeningLab6;
    @BindView(R.id.tv_opening_lab7)
    TextView tvOpeningLab7;
    @BindView(R.id.tv_opening_lab8)
    TextView tvOpeningLab8;
    @BindView(R.id.tv_opening_lab9)
    TextView tvOpeningLab9;
    @BindView(R.id.tv_opening_lab10)
    TextView tvOpeningLab10;
    @BindView(R.id.tv_opening_lab11)
    TextView tvOpeningLab11;
    @BindView(R.id.tv_opening_lab12)
    TextView tvOpeningLab12;
    @BindView(R.id.tv_opening_lab13)
    TextView tvOpeningLab13;
    @BindView(R.id.tv_opening_lab14)
    TextView tvOpeningLab14;
    @BindView(R.id.tv_opening_lab15)
    TextView tvOpeningLab15;
    @BindView(R.id.tv_holding_lab1)
    TextView tvHoldingLab1;
    @BindView(R.id.tv_holding_lab2)
    TextView tvHoldingLab2;
    @BindView(R.id.tv_holding_lab3)
    TextView tvHoldingLab3;
    @BindView(R.id.tv_holding_lab4)
    TextView tvHoldingLab4;
    @BindView(R.id.tv_holding_lab5)
    TextView tvHoldingLab5;
    @BindView(R.id.tv_holding_lab6)
    TextView tvHoldingLab6;
    @BindView(R.id.tv_holding_lab7)
    TextView tvHoldingLab7;
    @BindView(R.id.tv_holding_lab8)
    TextView tvHoldingLab8;
    @BindView(R.id.tv_holding_lab9)
    TextView tvHoldingLab9;
    @BindView(R.id.tv_holding_lab10)
    TextView tvHoldingLab10;
    @BindView(R.id.tv_holding_lab11)
    TextView tvHoldingLab11;
    @BindView(R.id.tv_holding_lab12)
    TextView tvHoldingLab12;
    @BindView(R.id.tv_filling_lab1)
    TextView tvFillingLab1;
    @BindView(R.id.tv_filling_lab2)
    TextView tvFillingLab2;
    @BindView(R.id.tv_filling_lab3)
    TextView tvFillingLab3;
    @BindView(R.id.tv_filling_lab4)
    TextView tvFillingLab4;
    @BindView(R.id.tv_filling_lab5)
    TextView tvFillingLab5;
    @BindView(R.id.tv_filling_lab6)
    TextView tvFillingLab6;
    @BindView(R.id.tv_filling_lab7)
    TextView tvFillingLab7;
    @BindView(R.id.tv_filling_lab8)
    TextView tvFillingLab8;
    @BindView(R.id.tv_filling_lab9)
    TextView tvFillingLab9;
    @BindView(R.id.tv_filling_lab10)
    TextView tvFillingLab10;
    @BindView(R.id.tv_filling_lab11)
    TextView tvFillingLab11;
    @BindView(R.id.tv_filling_lab12)
    TextView tvFillingLab12;
    @BindView(R.id.tv_filling_lab13)
    TextView tvFillingLab13;
    @BindView(R.id.tv_filling_lab14)
    TextView tvFillingLab14;
    @BindView(R.id.tv_filling_lab15)
    TextView tvFillingLab15;
    @BindView(R.id.tv_sh_lab1)
    TextView tvShLab1;
    @BindView(R.id.tv_sh_lab2)
    TextView tvShLab2;
    @BindView(R.id.tv_sh_lab3)
    TextView tvShLab3;
    @BindView(R.id.tv_sh_lab4)
    TextView tvShLab4;
    @BindView(R.id.tv_sh_lab5)
    TextView tvShLab5;
    @BindView(R.id.tv_sh_lab6)
    TextView tvShLab6;
    @BindView(R.id.tv_sh_lab7)
    TextView tvShLab7;
    @BindView(R.id.tv_sh_lab8)
    TextView tvShLab8;
    @BindView(R.id.tv_ds_lab1)
    TextView tvDsLab1;
    @BindView(R.id.tv_ds_lab2)
    TextView tvDsLab2;
    @BindView(R.id.tv_ds_lab3)
    TextView tvDsLab3;
    @BindView(R.id.tv_ds_lab4)
    TextView tvDsLab4;
    @BindView(R.id.tv_tcsj)
    TextView tvTcsj;
    @BindView(R.id.tv_zdzsyl)
    TextView tvZdzsyl;
    @BindView(R.id.tv_zxhc)
    TextView tvZxhc;
    @BindView(R.id.tv_bysj)
    TextView tvBysj;
    @BindView(R.id.tv_zdbyyl)
    TextView tvZdbyyl;
    @BindView(R.id.tv_wzqh)
    TextView tvWzqh;
    @BindView(R.id.tv_lqsj)
    TextView tvLqsj;
    @BindView(R.id.tv_smyl)
    TextView tvSmyl;
    @BindView(R.id.tv_dccs)
    TextView tvDccs;
    @BindView(R.id.tv_khmsj)
    TextView tvKhmsj;
    @BindView(R.id.tv_by)
    TextView tvBy;
    @BindView(R.id.tv_bzcpzl)
    TextView tvBzcpzl;
    @BindView(R.id.tv_zqsj)
    TextView tvZqsj;
    @BindView(R.id.tv_skzl)
    TextView tvSkzl;
    @BindView(R.id.tv_bzmz)
    TextView tvBzmz;
    @BindView(R.id.tv_zswt)
    TextView tvZswt;
    @BindView(R.id.tv_mjzysx)
    TextView tvMjzysx;
    @BindView(R.id.constraint_id_lab1)
    TextView constraintIdLab1;
    @BindView(R.id.constraint_id_lab2)
    TextView constraintIdLab2;
    @BindView(R.id.tv_zbr)
    TextView tvZbr;
    @BindView(R.id.tv_qhr)
    TextView tvQhr;
    @BindView(R.id.wjbh)
    TextView wjbh;
    @BindView(R.id.bc)
    TextView bc;
    @BindView(R.id.tips)
    TextView tips;
    private ListView listView;
    private Handler handler;
    private Button cancle_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gycs2);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        jtbh = sharedPreferences.getString("jtbh", "");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0x100:
                        try {
                            initListView((JSONArray) msg.obj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x101:
                        try {
                            JSONArray list1 = (JSONArray) msg.obj;
                            list1.getJSONObject(0);
                           /*jtbh_text.setText(list1.getJSONObject(0).getString("csm_jtbh"));
                           cpbh_text.setText(list1.getJSONObject(0).getString("csm_wldm"));
                           pmgg_text.setText(list1.getJSONObject(0).getString("csm_pmgg"));
                           mjbh_text.setText(list1.getJSONObject(0).getString("csm_mjbh"));
                           mjmc_text.setText(list1.getJSONObject(0).getString("csm_mjmc"));
                           cpqs_text.setText(list1.getJSONObject(0).getString("csm_cpxs"));
                           cxzq_text.setText(list1.getJSONObject(0).getString("csm_cxsj"));
                           lqsj_text.setText(list1.getJSONObject(0).getString("csm_lqsj"));
                           sjsj_text.setText(list1.getJSONObject(0).getString("csm_sjsj"));
                           sml_text.setText(list1.getJSONObject(0).getString("csm_sml"));
                           sdry_text.setText(list1.getJSONObject(0).getString("csm_sdry"));
                           bzms_text.setText(list1.getJSONObject(0).getString("csm_bzms"));
                           bzxx_text.setText(list1.getJSONObject(0).getString("csm_desc"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x102:
                        try {
                            JSONArray list2 = (JSONArray) msg.obj;
                            list2.getJSONObject(0);
                            /*sdz_1.setText(list2.getJSONObject(0).getString("csd_val1"));
                            sdz_2.setText(list2.getJSONObject(0).getString("csd_val2"));
                            sdz_3.setText(list2.getJSONObject(0).getString("csd_val3"));
                            sdz_4.setText(list2.getJSONObject(0).getString("csd_val4"));
                            sdz_5.setText(list2.getJSONObject(0).getString("csd_val5"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x103:
                        try {
                            JSONArray list3 = (JSONArray) msg.obj;
                            list3.getJSONObject(0);
                           /*sjz_1.setText(list3.getJSONObject(0).getString("csd_val1"));
                           sjz_2.setText(list3.getJSONObject(0).getString("csd_val2"));
                           sjz_3.setText(list3.getJSONObject(0).getString("csd_val3"));
                           sjz_4.setText(list3.getJSONObject(0).getString("csd_val4"));
                           sjz_5.setText(list3.getJSONObject(0).getString("csd_val5"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x104:
                        try {
                            JSONArray list4 = (JSONArray) msg.obj;
                            list4.getJSONObject(0);
                           /*flb_1.setText(list4.getJSONObject(0).getString("csd_val1"));
                           flb_2.setText(list4.getJSONObject(0).getString("csd_val2"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x105:
                        try {
                            JSONArray list5 = (JSONArray) msg.obj;
                            list5.getJSONObject(0);
                            /*sd_1.setText(list5.getJSONObject(0).getString("csd_val1"));
                            sd_2.setText(list5.getJSONObject(0).getString("csd_val2"));
                            sd_3.setText(list5.getJSONObject(0).getString("csd_val3"));
                            sd_4.setText(list5.getJSONObject(0).getString("csd_val4"));
                            sd_5.setText(list5.getJSONObject(0).getString("csd_val5"));
                            sd_6.setText(list5.getJSONObject(0).getString("csd_val6"));
                            sd_7.setText(list5.getJSONObject(0).getString("csd_val7"));
                            sd_8.setText(list5.getJSONObject(0).getString("csd_val8"));
                            sd_9.setText(list5.getJSONObject(0).getString("csd_val9"));
                            sd_10.setText(list5.getJSONObject(0).getString("csd_val10"));
                            sd_11.setText(list5.getJSONObject(0).getString("csd_val11"));
                            sd_12.setText(list5.getJSONObject(0).getString("csd_val12"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x106:
                        try {
                            JSONArray list6 = (JSONArray) msg.obj;
                            list6.getJSONObject(0);
                            /*yl_1.setText(list6.getJSONObject(0).getString("csd_val1"));
                            yl_2.setText(list6.getJSONObject(0).getString("csd_val2"));
                            yl_3.setText(list6.getJSONObject(0).getString("csd_val3"));
                            yl_4.setText(list6.getJSONObject(0).getString("csd_val4"));
                            yl_5.setText(list6.getJSONObject(0).getString("csd_val5"));
                            yl_6.setText(list6.getJSONObject(0).getString("csd_val6"));
                            yl_7.setText(list6.getJSONObject(0).getString("csd_val7"));
                            yl_8.setText(list6.getJSONObject(0).getString("csd_val8"));
                            yl_9.setText(list6.getJSONObject(0).getString("csd_val9"));
                            yl_10.setText(list6.getJSONObject(0).getString("csd_val10"));
                            yl_11.setText(list6.getJSONObject(0).getString("csd_val11"));
                            yl_12.setText(list6.getJSONObject(0).getString("csd_val12"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0x107:
                        try {
                            JSONArray list7 = (JSONArray) msg.obj;
                            list7.getJSONObject(0);
                            /*pz_1.setText(list7.getJSONObject(0).getString("csd_val1"));
                            pz_2.setText(list7.getJSONObject(0).getString("csd_val2"));
                            pz_3.setText(list7.getJSONObject(0).getString("csd_val3"));
                            pz_4.setText(list7.getJSONObject(0).getString("csd_val4"));
                            pz_5.setText(list7.getJSONObject(0).getString("csd_val5"));
                            pz_6.setText(list7.getJSONObject(0).getString("csd_val6"));
                            pz_7.setText(list7.getJSONObject(0).getString("csd_val7"));
                            pz_8.setText(list7.getJSONObject(0).getString("csd_val8"));
                            pz_9.setText(list7.getJSONObject(0).getString("csd_val9"));
                            pz_10.setText(list7.getJSONObject(0).getString("csd_val10"));
                            pz_11.setText(list7.getJSONObject(0).getString("csd_val11"));
                            pz_12.setText(list7.getJSONObject(0).getString("csd_val12"));
                            pz_13.setText(list7.getJSONObject(0).getString("csd_val13"));
                            pz_14.setText(list7.getJSONObject(0).getString("csd_val14"));
                            pz_15.setText(list7.getJSONObject(0).getString("csd_val15"));
                            pz_16.setText(list7.getJSONObject(0).getString("csd_val16"));
                            pz_17.setText(list7.getJSONObject(0).getString("csd_val17"));
                            pz_18.setText(list7.getJSONObject(0).getString("csd_val18"));
                            pz_19.setText(list7.getJSONObject(0).getString("csd_val19"));
                            pz_20.setText(list7.getJSONObject(0).getString("csd_val20"));
                            pz_21.setText(list7.getJSONObject(0).getString("csd_val21"));
                            pz_22.setText(list7.getJSONObject(0).getString("csd_val22"));
                            pz_23.setText(list7.getJSONObject(0).getString("csd_val23"));
                            pz_24.setText(list7.getJSONObject(0).getString("csd_val24"));
                            pz_25.setText(list7.getJSONObject(0).getString("csd_val25"));
                            pz_26.setText(list7.getJSONObject(0).getString("csd_val26"));
                            pz_27.setText(list7.getJSONObject(0).getString("csd_val27"));
                            pz_28.setText(list7.getJSONObject(0).getString("csd_val28"));
                            pz_29.setText(list7.getJSONObject(0).getString("csd_val29"));
                            pz_30.setText(list7.getJSONObject(0).getString("csd_val30"));
                            pz_31.setText(list7.getJSONObject(0).getString("csd_val31"));
                            pz_32.setText(list7.getJSONObject(0).getString("csd_val32"));
                            pz_33.setText(list7.getJSONObject(0).getString("csd_val33"));
                            pz_34.setText(list7.getJSONObject(0).getString("csd_val34"));
                            pz_35.setText(list7.getJSONObject(0).getString("csd_val35"));
                            pz_36.setText(list7.getJSONObject(0).getString("csd_val36"));*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;

                }
            }
        };
        getListData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.list_1);
        /*wjbh_text=(TextView)findViewById(R.id.wjbh);
        bb_text=(TextView)findViewById(R.id.bb);
        jtbh_text=(TextView)findViewById(R.id.jtbh);
        cpbh_text=(TextView)findViewById(R.id.cpbh);
        mjbh_text=(TextView)findViewById(R.id.mjbh);
        mjmc_text=(TextView)findViewById(R.id.mjmc);
        cpqs_text=(TextView)findViewById(R.id.cpqs);
        sml_text=(TextView)findViewById(R.id.sml);
        cxzq_text=(TextView)findViewById(R.id.cxzq);
        lqsj_text=(TextView)findViewById(R.id.lqsj);
        sjsj_text=(TextView)findViewById(R.id.sjsj);
        sdry_text=(TextView)findViewById(R.id.sdry);
        pmgg_text=(TextView)findViewById(R.id.pmgg);
        bzms_text=(TextView)findViewById(R.id.bzms);
        bzxx_text=(TextView)findViewById(R.id.bzxx);

        sdz_1=(TextView)findViewById(R.id.sdz_1);
        sdz_2=(TextView)findViewById(R.id.sdz_2);
        sdz_3=(TextView)findViewById(R.id.sdz_3);
        sdz_4=(TextView)findViewById(R.id.sdz_4);
        sdz_5=(TextView)findViewById(R.id.sdz_5);

        sjz_1=(TextView)findViewById(R.id.sjz_1);
        sjz_2=(TextView)findViewById(R.id.sjz_2);
        sjz_3=(TextView)findViewById(R.id.sjz_3);
        sjz_4=(TextView)findViewById(R.id.sjz_4);
        sjz_5=(TextView)findViewById(R.id.sjz_5);

        flb_1=(TextView)findViewById(R.id.flb_1);
        flb_2=(TextView)findViewById(R.id.flb_2);

        sd_1=(TextView)findViewById(R.id.sd_1);
        sd_2=(TextView)findViewById(R.id.sd_2);
        sd_3=(TextView)findViewById(R.id.sd_3);
        sd_4=(TextView)findViewById(R.id.sd_4);
        sd_5=(TextView)findViewById(R.id.sd_5);
        sd_6=(TextView)findViewById(R.id.sd_6);
        sd_7=(TextView)findViewById(R.id.sd_7);
        sd_8=(TextView)findViewById(R.id.sd_8);
        sd_9=(TextView)findViewById(R.id.sd_9);
        sd_10=(TextView)findViewById(R.id.sd_10);
        sd_11=(TextView)findViewById(R.id.sd_11);
        sd_12=(TextView)findViewById(R.id.sd_12);

        yl_1=(TextView)findViewById(R.id.yl_1);
        yl_2=(TextView)findViewById(R.id.yl_2);
        yl_3=(TextView)findViewById(R.id.yl_3);
        yl_4=(TextView)findViewById(R.id.yl_4);
        yl_5=(TextView)findViewById(R.id.yl_5);
        yl_6=(TextView)findViewById(R.id.yl_6);
        yl_7=(TextView)findViewById(R.id.yl_7);
        yl_8=(TextView)findViewById(R.id.yl_8);
        yl_9=(TextView)findViewById(R.id.yl_9);
        yl_10=(TextView)findViewById(R.id.yl_10);
        yl_11=(TextView)findViewById(R.id.yl_11);
        yl_12=(TextView)findViewById(R.id.yl_12);

        pz_1=(TextView)findViewById(R.id.pz_1);
        pz_2=(TextView)findViewById(R.id.pz_2);
        pz_3=(TextView)findViewById(R.id.pz_3);
        pz_4=(TextView)findViewById(R.id.pz_4);
        pz_5=(TextView)findViewById(R.id.pz_5);
        pz_6=(TextView)findViewById(R.id.pz_6);
        pz_7=(TextView)findViewById(R.id.pz_7);
        pz_8=(TextView)findViewById(R.id.pz_8);
        pz_9=(TextView)findViewById(R.id.pz_9);
        pz_10=(TextView)findViewById(R.id.pz_10);
        pz_11=(TextView)findViewById(R.id.pz_11);
        pz_12=(TextView)findViewById(R.id.pz_12);
        pz_13=(TextView)findViewById(R.id.pz_13);
        pz_14=(TextView)findViewById(R.id.pz_14);
        pz_15=(TextView)findViewById(R.id.pz_15);
        pz_16=(TextView)findViewById(R.id.pz_16);
        pz_17=(TextView)findViewById(R.id.pz_17);
        pz_18=(TextView)findViewById(R.id.pz_18);
        pz_19=(TextView)findViewById(R.id.pz_19);
        pz_20=(TextView)findViewById(R.id.pz_20);
        pz_21=(TextView)findViewById(R.id.pz_21);
        pz_22=(TextView)findViewById(R.id.pz_22);
        pz_23=(TextView)findViewById(R.id.pz_23);
        pz_24=(TextView)findViewById(R.id.pz_24);
        pz_25=(TextView)findViewById(R.id.pz_25);
        pz_26=(TextView)findViewById(R.id.pz_26);
        pz_27=(TextView)findViewById(R.id.pz_27);
        pz_28=(TextView)findViewById(R.id.pz_28);
        pz_29=(TextView)findViewById(R.id.pz_29);
        pz_30=(TextView)findViewById(R.id.pz_30);
        pz_31=(TextView)findViewById(R.id.pz_31);
        pz_32=(TextView)findViewById(R.id.pz_32);
        pz_33=(TextView)findViewById(R.id.pz_33);
        pz_34=(TextView)findViewById(R.id.pz_34);
        pz_35=(TextView)findViewById(R.id.pz_35);
        pz_36=(TextView)findViewById(R.id.pz_36);

        tip=(TextView)findViewById(R.id.tip);*/

        cancle_btn = (Button) findViewById(R.id.cancle_btn);
        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getListData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*List<List<String>>list= NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'A','"+jtbh+"',''");
                if (list!=null){
                    if (list.size()>0){
                        if (list.get(0).size()>3){
                            Message msg=handler.obtainMessage();
                            msg.what=0x100;
                            msg.obj=list;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'A'",jtbh,"");
                }*/
                JSONArray list = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'A','" + jtbh + "',''");
                if (list != null) {
                    if (list.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x100;
                        msg.obj = list;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'A'", jtbh, "");
                }
            }
        }).start();
    }

    private void initListView(JSONArray lists) throws JSONException {
        final List<Map<String, String>> data = new ArrayList<>();
        for (int i = 0; i < lists.length(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("lab_1", lists.getJSONObject(i).getString("v_djbh"));
            map.put("lab_2", lists.getJSONObject(i).getString("v_jtbh"));
            map.put("lab_3", lists.getJSONObject(i).getString("v_ver"));
            map.put("isSelect", "0");
            data.add(map);
        }
        EasyArrayAdapter adapter = new EasyArrayAdapter(this, R.layout.list_item_gycs, data) {
            @Override
            public View getEasyView(int position, View convertView, ViewGroup parent) {
                View view;
                if (convertView != null) {
                    view = convertView;
                } else {
                    view = LayoutInflater.from(GycsActivity2.this).inflate(R.layout.list_item_gycs, null);
                }
                TextView lab_1 = (TextView) view.findViewById(R.id.lab_1);
                TextView lab_2 = (TextView) view.findViewById(R.id.lab_2);
                TextView lab_3 = (TextView) view.findViewById(R.id.lab_3);
                LinearLayout bg = (LinearLayout) view.findViewById(R.id.bg);
                final Map<String, String> map = data.get(position);
                lab_1.setText(map.get("lab_1"));
                lab_2.setText(map.get("lab_2"));
                lab_3.setText(map.get("lab_3"));
                if (map.get("isSelect").equals("0")) {
                    bg.setBackgroundColor(getResources().getColor(R.color.fragment_bg));
                } else {
                    bg.setBackgroundColor(getResources().getColor(R.color.small));
                }
                bg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!map.get("lab_2").equals(jtbh)) {
                            tips.setText("提示：所选机台与本机台不一致，仅供参考");
                        } else {
                            tips.setText("");
                        }
                        wjbh.setText(map.get("lab_1"));
                        bc.setText(map.get("lab_3"));
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).put("isSelect", "0");
                        }
                        map.put("isSelect", "1");
                        notifyDataSetChanged();
                        onItemSelectEven(map.get("lab_1"));
                    }
                });
                return view;
            }
        };
        listView.setAdapter(adapter);

    }


    private void onItemSelectEven(final String wjbh) {
        AppUtils.sendCountdownReceiver(this);
        tvMjbh.setText("");
        tvXs.setText("");
        tvMjcc.setText("");
        tvJh.setText("");
        tvJtdw.setText("");
        tvWldm.setText("");
        tvCpmc.setText("");
        tvSlmc.setText("");
        tvSlys.setText("");
        tvCxdz.setText("");
        tvRjdLab1.setText("");
        tvRjdLab2.setText("");
        tvRjdLab3.setText("");
        tvRjdLab4.setText("");
        tvRjdLab5.setText("");
        tvRjdLab6.setText("");
        tvRjdLab7.setText("");
        tvRjdLab8.setText("");
        tvRjdLab9.setText("");
        tvRjdLab10.setText("");
        tvRjdLab11.setText("");
        tvRjdLab12.setText("");
        tvCxLab1.setText("");
        tvCxLab2.setText("");
        tvCxLab3.setText("");
        tvCxLab4.setText("");
        tvCxLab5.setText("");
        tvJxLab1.setText("");
        tvJxLab2.setText("");
        tvJxLab3.setText("");
        tvJxLab4.setText("");
        tvJxLab5.setText("");
        tvKlfs.setText("");
        tvJxWd.setText("");
        tvSj.setText("");
        tvHen.setText("");
        tvHn1.setText("");
        tvHn2.setText("");
        tvHn3.setText("");
        tvHn4.setText("");
        tvEjectionLab1.setText("");
        tvEjectionLab2.setText("");
        tvEjectionLab3.setText("");
        tvEjectionLab4.setText("");
        tvEjectionLab5.setText("");
        tvEjectionLab6.setText("");
        tvEjectionLab7.setText("");
        tvEjectionLab8.setText("");
        tvEjectionLab9.setText("");
        tvEjectionLab10.setText("");
        tvEjectionLab11.setText("");
        tvEjectionLab12.setText("");
        tvEjectionLab13.setText("");
        tvEjectionLab14.setText("");
        tvEjectionLab15.setText("");
        tvEjectionLab16.setText("");
        tvEjectionLab17.setText("");
        tvEjectionLab18.setText("");
        tvClosingLab1.setText("");
        tvClosingLab2.setText("");
        tvClosingLab3.setText("");
        tvClosingLab4.setText("");
        tvClosingLab5.setText("");
        tvClosingLab6.setText("");
        tvClosingLab7.setText("");
        tvClosingLab8.setText("");
        tvClosingLab9.setText("");
        tvClosingLab10.setText("");
        tvClosingLab11.setText("");
        tvClosingLab12.setText("");
        tvClosingLab13.setText("");
        tvClosingLab14.setText("");
        tvClosingLab15.setText("");
        tvOpeningLab1.setText("");
        tvOpeningLab2.setText("");
        tvOpeningLab3.setText("");
        tvOpeningLab4.setText("");
        tvOpeningLab5.setText("");
        tvOpeningLab6.setText("");
        tvOpeningLab7.setText("");
        tvOpeningLab8.setText("");
        tvOpeningLab9.setText("");
        tvOpeningLab10.setText("");
        tvOpeningLab11.setText("");
        tvOpeningLab12.setText("");
        tvOpeningLab13.setText("");
        tvOpeningLab14.setText("");
        tvOpeningLab15.setText("");
        tvHoldingLab1.setText("");
        tvHoldingLab2.setText("");
        tvHoldingLab3.setText("");
        tvHoldingLab4.setText("");
        tvHoldingLab5.setText("");
        tvHoldingLab6.setText("");
        tvHoldingLab7.setText("");
        tvHoldingLab8.setText("");
        tvHoldingLab9.setText("");
        tvHoldingLab10.setText("");
        tvHoldingLab11.setText("");
        tvHoldingLab12.setText("");
        tvFillingLab1.setText("");
        tvFillingLab2.setText("");
        tvFillingLab3.setText("");
        tvFillingLab4.setText("");
        tvFillingLab5.setText("");
        tvFillingLab6.setText("");
        tvFillingLab7.setText("");
        tvFillingLab8.setText("");
        tvFillingLab9.setText("");
        tvFillingLab10.setText("");
        tvFillingLab11.setText("");
        tvFillingLab12.setText("");
        tvFillingLab13.setText("");
        tvFillingLab14.setText("");
        tvFillingLab15.setText("");
        tvShLab1.setText("");
        tvShLab2.setText("");
        tvShLab3.setText("");
        tvShLab4.setText("");
        tvShLab5.setText("");
        tvShLab6.setText("");
        tvShLab7.setText("");
        tvShLab8.setText("");
        tvDsLab1.setText("");
        tvDsLab2.setText("");
        tvDsLab3.setText("");
        tvDsLab4.setText("");
        tvTcsj.setText("");
        tvZdzsyl.setText("");
        tvZxhc.setText("");
        tvBysj.setText("");
        tvZdbyyl.setText("");
        tvWzqh.setText("");
        tvLqsj.setText("");
        tvSmyl.setText("");
        tvDccs.setText("");
        tvKhmsj.setText("");
        tvBy.setText("");
        tvBzcpzl.setText("");
        tvZqsj.setText("");
        tvSkzl.setText("");
        tvBzmz.setText("");
        tvZswt.setText("");
        tvMjzysx.setText("");
        constraintIdLab1.setText("");
        constraintIdLab2.setText("");
        tvZbr.setText("");
        tvQhr.setText("");
        bc.setText("");
        tips.setText("");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //第一栏基础信息
                /*List<List<String>>list1=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'B','','"+wjbh+"'");
                if (list1!=null){
                    if (list1.size()>0){
                        if (list1.get(0).size()>19){
                            Message msg=handler.obtainMessage();
                            msg.what=0x101;
                            msg.obj=list1;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'B'",jtbh,"");
                }*/
                JSONArray list1 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'B','','" + wjbh + "'");
                if (list1 != null) {
                    if (list1.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x101;
                        msg.obj = list1;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'B'", jtbh, "");
                }


                //设定值
               /* List<List<String>>list2=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'RJSD','','"+wjbh+"'");
                if (list2!=null){
                    if (list2.size()>0){
                        if (list2.get(0).size()>4){
                            Message msg=handler.obtainMessage();
                            msg.what=0x102;
                            msg.obj=list2;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'RJSD'",jtbh,"");
                }*/
                JSONArray list2 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'RJSD','','" + wjbh + "'");
                if (list2 != null) {
                    if (list2.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x102;
                        msg.obj = list2;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'RJSD'", jtbh, "");
                }


                //实际值
                /*List<List<String>>list3=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'RJSJ','','"+wjbh+"'");
                if (list3!=null){
                    if (list3.size()>0){
                        if (list3.get(0).size()>4){
                            Message msg=handler.obtainMessage();
                            msg.what=0x103;
                            msg.obj=list3;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'RJSD'",jtbh,"");
                }*/
                JSONArray list3 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'RJSJ','','" + wjbh + "'");
                if (list3 != null) {
                    if (list3.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x103;
                        msg.obj = list3;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'RJSD'", jtbh, "");
                }


                //分流板
               /* List<List<String>>list4=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'FLB','','"+wjbh+"'");
                if (list4!=null){
                    if (list4.size()>0){
                        if (list4.get(0).size()>1){
                            Message msg=handler.obtainMessage();
                            msg.what=0x104;
                            msg.obj=list4;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'FLB'",jtbh,"");
                }*/
                JSONArray list4 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'FLB','','" + wjbh + "'");
                if (list4 != null) {
                    if (list4.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x104;
                        msg.obj = list4;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'FLB'", jtbh, "");
                }


                //速度
               /* List<List<String>>list5=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'SD','','"+wjbh+"'");
                if (list5!=null){
                    if (list5.size()>0){
                        if (list5.get(0).size()>11){
                            Message msg=handler.obtainMessage();
                            msg.what=0x105;
                            msg.obj=list5;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'SD'",jtbh,"");
                }*/
                JSONArray list5 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'SD','','" + wjbh + "'");
                if (list5 != null) {
                    if (list5.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x105;
                        msg.obj = list5;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'SD'", jtbh, "");
                }


                //压力
               /* List<List<String>>list6=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'YL','','"+wjbh+"'");
                if (list6!=null){
                    if (list6.size()>0){
                        if (list6.get(0).size()>11){
                            Message msg=handler.obtainMessage();
                            msg.what=0x106;
                            msg.obj=list6;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'YL'",jtbh,"");
                }*/
                JSONArray list6 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'YL','','" + wjbh + "'");
                if (list6 != null) {
                    if (list6.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x106;
                        msg.obj = list6;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'YL'", jtbh, "");
                }


                //喷嘴
                /*List<List<String>>list7=NetHelper.getQuerysqlResult("Exec PAD_Get_CsmInf 'PZ','','"+wjbh+"'");
                if (list7!=null){
                    if (list7.size()>0){
                        if (list7.get(0).size()>35){
                            Message msg=handler.obtainMessage();
                            msg.what=0x107;
                            msg.obj=list7;
                            handler.sendMessage(msg);
                        }
                    }
                }else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'PZ'",jtbh,"");
                }*/
                JSONArray list7 = NetHelper.getQuerysqlResultJsonArray("Exec PAD_Get_CsmInf 'PZ','','" + wjbh + "'");
                if (list7 != null) {
                    if (list7.length() > 0) {
                        Message msg = handler.obtainMessage();
                        msg.what = 0x107;
                        msg.obj = list7;
                        handler.sendMessage(msg);
                    }
                } else {
                    AppUtils.uploadNetworkError("Exec PAD_Get_CsmInf 'PZ'", jtbh, "");
                }

            }
        }).start();
    }

}
