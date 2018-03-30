package com.kinvn.weather.weather.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class WeatherAPI{

	@SerializedName("HeWeather6")
	private List<HeWeather> heWeather6;

	public List<HeWeather> getHeWeather6() {
		return heWeather6;
	}

	public void setHeWeather6(List<HeWeather> heWeather6) {
		this.heWeather6 = heWeather6;
	}
}