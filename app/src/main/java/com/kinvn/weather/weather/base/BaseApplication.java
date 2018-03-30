package com.kinvn.weather.weather.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.kinvn.weather.weather.BuildConfig;

/**
 * Created by Kinvn on 2018/3/29.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class BaseApplication extends Application {
    private static String CACHE_DIR;
    @SuppressLint("StaticFieldLeak")
    private static Context APP_CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_CONTEXT = getApplicationContext();
        if (!BuildConfig.DEBUG) {
            // TODO: 2018/3/29
        } else {
            // TODO: 2018/3/29
        }
        // TODO: 2018/3/29

        if (APP_CONTEXT.getExternalCacheDir() != null && existSDCard()) {
            CACHE_DIR = APP_CONTEXT.getExternalCacheDir().toString();
        } else {
            CACHE_DIR = APP_CONTEXT.getCacheDir().toString();
        }
    }

    private Boolean existSDCard() {
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static Context getAppContext() {
        return APP_CONTEXT;
    }

    public static String getAppCacheDir() {
        return CACHE_DIR;
    }
}
