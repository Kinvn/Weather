package com.kinvn.weather.weather.model;

import com.google.gson.annotations.SerializedName;

public class Update{

	@SerializedName("loc")
	private String loc;

	@SerializedName("utc")
	private String utc;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getUtc() {
		return utc;
	}

	public void setUtc(String utc) {
		this.utc = utc;
	}
}