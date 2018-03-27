package com.kinvn.weather.weather.base;

import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Kinvn on 2018/3/22.
 */

public class BaseActivity extends AppCompatActivity {
    static {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
