package com.ruiduoyi;

import android.app.Application;
import android.content.Context;

import com.ruiduoyi.utils.CrashHandler;

import java.util.Random;

/**
 * Created by DengJf on 2017/7/3.
 */

public class RdyApplication  extends Application {
    public static String delayTime = ""+(new Random().nextInt(120) + 180);

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler catchHandler = CrashHandler.getInstance();
        catchHandler.init(getApplicationContext());
    }


}
