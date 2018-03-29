package com.kinvn.weather.weather.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class HeWeather6Item{

	@SerializedName("now")
	private Now now;

	@SerializedName("update")
	private Update update;

	@SerializedName("hourly")
	private List<HourlyItem> hourly;

	@SerializedName("basic")
	private Basic basic;

	@SerializedName("daily_forecast")
	private List<DailyForecastItem> dailyForecast;

	@SerializedName("status")
	private String status;

	@SerializedName("lifestyle")
	private List<LifestyleItem> lifestyle;
}