package com.kinvn.weather.weather.module.domain;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Suggestion{

	@SerializedName("uv")
	private Uv uv;

	@SerializedName("cw")
	private Cw cw;

	@SerializedName("trav")
	private Trav trav;

	@SerializedName("air")
	private Air air;

	@SerializedName("comf")
	private Comf comf;

	@SerializedName("drsg")
	private Drsg drsg;

	@SerializedName("sport")
	private Sport sport;

	@SerializedName("flu")
	private Flu flu;
}