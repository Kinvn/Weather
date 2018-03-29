package com.kinvn.weather.weather.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class HourlyItem{

	@SerializedName("hum")
	private String hum;

	@SerializedName("pres")
	private String pres;

	@SerializedName("wind_sc")
	private String windSc;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("wind_spd")
	private String windSpd;

	@SerializedName("cloud")
	private String cloud;

	@SerializedName("pop")
	private String pop;

	@SerializedName("wind_deg")
	private String windDeg;

	@SerializedName("tmp")
	private String tmp;

	@SerializedName("dew")
	private String dew;

	@SerializedName("cond_txt")
	private String condTxt;

	@SerializedName("time")
	private String time;

	@SerializedName("cond_code")
	private String condCode;
}