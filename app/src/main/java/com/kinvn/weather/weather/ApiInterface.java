package com.kinvn.weather.weather;

import com.kinvn.weather.weather.module.domain.WeatherAPI;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kinvn on 2018/3/27.
 */

public interface ApiInterface {
    String BASE_URL = "https://free-api.heweather.com/v5/";

    @GET
    Observable<WeatherAPI> weatherAPI(@Query("city") String city, @Query("key") String key);
}
