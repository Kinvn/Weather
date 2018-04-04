package com.kinvn.weather.weather.common.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.module.main.MainActivity;

/**
 * Created by Kinvn on 2018/3/29.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class Util {
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null) {
                    return networkInfo.isAvailable();
                }
            }
        }
        return false;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    public static void requestPermission(final Activity activity, final String permission
            , final int explanation, final int requestCode) {
        new AlertDialog.Builder(activity, R.style.CustomDialog)
                .setMessage(explanation)
                .setOnDismissListener(dialog ->
                        ActivityCompat.requestPermissions(activity
                                , new String[]{permission}
                                , requestCode))
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    public static boolean checkPermission(final Context context, final String permission) {
        return Build.VERSION.SDK_INT < 23 ||
                ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
