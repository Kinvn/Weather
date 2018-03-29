package com.kinvn.weather.weather.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Now{

	@SerializedName("hum")
	private String hum;

	@SerializedName("vis")
	private String vis;

	@SerializedName("pres")
	private String pres;

	@SerializedName("pcpn")
	private String pcpn;

	@SerializedName("fl")
	private String fl;

	@SerializedName("wind_sc")
	private String windSc;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("wind_spd")
	private String windSpd;

	@SerializedName("cloud")
	private String cloud;

	@SerializedName("wind_deg")
	private String windDeg;

	@SerializedName("tmp")
	private String tmp;

	@SerializedName("cond_txt")
	private String condTxt;

	@SerializedName("cond_code")
	private String condCode;
}