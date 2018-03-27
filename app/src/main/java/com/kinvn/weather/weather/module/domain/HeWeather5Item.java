package com.kinvn.weather.weather.module.domain;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class HeWeather5Item{

	@SerializedName("now")
	private Now now;

	@SerializedName("suggestion")
	private Suggestion suggestion;

	@SerializedName("aqi")
	private Aqi aqi;

	@SerializedName("basic")
	private Basic basic;

	@SerializedName("daily_forecast")
	private List<DailyForecastItem> dailyForecast;

	@SerializedName("hourly_forecast")
	private List<HourlyForecastItem> hourlyForecast;

	@SerializedName("status")
	private String status;
}