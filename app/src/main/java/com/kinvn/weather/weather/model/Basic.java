package com.kinvn.weather.weather.model;

import com.google.gson.annotations.SerializedName;

public class Basic{

	@SerializedName("admin_area")
	private String adminArea;

	@SerializedName("tz")
	private String tz;

	@SerializedName("location")
	private String location;

	@SerializedName("lon")
	private String lon;

	@SerializedName("parent_city")
	private String parentCity;

	@SerializedName("cnty")
	private String cnty;

	@SerializedName("lat")
	private String lat;

	@SerializedName("cid")
	private String cid;

	public String getAdminArea() {
		return adminArea;
	}

	public void setAdminArea(String adminArea) {
		this.adminArea = adminArea;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getParentCity() {
		return parentCity;
	}

	public void setParentCity(String parentCity) {
		this.parentCity = parentCity;
	}

	public String getCnty() {
		return cnty;
	}

	public void setCnty(String cnty) {
		this.cnty = cnty;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}