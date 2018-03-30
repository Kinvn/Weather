package com.kinvn.weather.weather.model;

import com.google.gson.annotations.SerializedName;

public class LifestyleItem{

	@SerializedName("txt")
	private String txt;

	@SerializedName("brf")
	private String brf;

	@SerializedName("type")
	private String type;

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getBrf() {
		return brf;
	}

	public void setBrf(String brf) {
		this.brf = brf;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}