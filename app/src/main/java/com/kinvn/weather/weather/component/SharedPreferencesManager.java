package com.kinvn.weather.weather.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.kinvn.weather.weather.base.BaseApplication;

/**
 * Created by Kinvn on 2018/4/4.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class SharedPreferencesManager {
    private static final String SP_NAME = "values";

    public static final String CITY_NAME = "city_name";
    public static final String DEFAULT_CITY = "北京";

    private SharedPreferences mSP;

    private SharedPreferencesManager() {
        mSP = BaseApplication.getAppContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    private static class SharedPreferenceManagerHolder {
        private final static SharedPreferencesManager INSTANCE = new SharedPreferencesManager();
    }

    public static SharedPreferencesManager getInstance() {
        return SharedPreferenceManagerHolder.INSTANCE;
    }

    public void setCity(String city) {
        SharedPreferences.Editor editor = mSP.edit();
        editor.putString(CITY_NAME, city);
        editor.apply();
    }

    public String getCity() {
        return mSP.getString(CITY_NAME, DEFAULT_CITY);
    }
}
