package com.kinvn.weather.weather.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HeWeather {

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

	public Now getNow() {
		return now;
	}

	public void setNow(Now now) {
		this.now = now;
	}

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	public List<HourlyItem> getHourly() {
		return hourly;
	}

	public void setHourly(List<HourlyItem> hourly) {
		this.hourly = hourly;
	}

	public Basic getBasic() {
		return basic;
	}

	public void setBasic(Basic basic) {
		this.basic = basic;
	}

	public List<DailyForecastItem> getDailyForecast() {
		return dailyForecast;
	}

	public void setDailyForecast(List<DailyForecastItem> dailyForecast) {
		this.dailyForecast = dailyForecast;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LifestyleItem> getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(List<LifestyleItem> lifestyle) {
		this.lifestyle = lifestyle;
	}
}