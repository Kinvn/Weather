package com.kinvn.weather.weather.module.domain;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DailyForecastItem{

	@SerializedName("date")
	private String date;

	@SerializedName("pop")
	private String pop;

	@SerializedName("hum")
	private String hum;

	@SerializedName("uv")
	private String uv;

	@SerializedName("vis")
	private String vis;

	@SerializedName("astro")
	private Astro astro;

	@SerializedName("pres")
	private String pres;

	@SerializedName("pcpn")
	private String pcpn;

	@SerializedName("tmp")
	private Tmp tmp;

	@SerializedName("cond")
	private Cond cond;

	@SerializedName("wind")
	private Wind wind;
}