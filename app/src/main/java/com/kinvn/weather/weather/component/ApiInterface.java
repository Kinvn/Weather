package com.kinvn.weather.weather.component;

import com.kinvn.weather.weather.model.WeatherAPI;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kinvn on 2018/3/27.
 */

public interface ApiInterface {
    String BASE_URL = "https://free-api.heweather.com/s6/";

    @GET
    Observable<WeatherAPI> weatherAPI(@Query("city") String city, @Query("key") String key);

    // TODO: 2018/3/29 Flowable
}
