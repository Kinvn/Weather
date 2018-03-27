package com.kinvn.weather.weather.module.domain;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class HourlyForecastItem{

	@SerializedName("date")
	private String date;

	@SerializedName("pop")
	private String pop;

	@SerializedName("hum")
	private String hum;

	@SerializedName("pres")
	private String pres;

	@SerializedName("tmp")
	private String tmp;

	@SerializedName("cond")
	private Cond cond;

	@SerializedName("wind")
	private Wind wind;
}