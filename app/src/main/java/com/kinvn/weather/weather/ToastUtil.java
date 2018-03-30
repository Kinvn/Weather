package com.kinvn.weather.weather;

import android.widget.Toast;

import com.kinvn.weather.weather.base.BaseApplication;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class ToastUtil {
    public static void showShort(String msg) {
        Toast.makeText(BaseApplication.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(BaseApplication.getAppContext(), msg, Toast.LENGTH_LONG).show();
    }
}
