package com.kinvn.weather.weather.module.domain;

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

	@SerializedName("tmp")
	private String tmp;

	@SerializedName("cond")
	private Cond cond;

	@SerializedName("wind")
	private Wind wind;
}