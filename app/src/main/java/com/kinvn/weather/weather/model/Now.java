package com.kinvn.weather.weather.model;

import com.google.gson.annotations.SerializedName;

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

	public String getHum() {
		return hum;
	}

	public void setHum(String hum) {
		this.hum = hum;
	}

	public String getVis() {
		return vis;
	}

	public void setVis(String vis) {
		this.vis = vis;
	}

	public String getPres() {
		return pres;
	}

	public void setPres(String pres) {
		this.pres = pres;
	}

	public String getPcpn() {
		return pcpn;
	}

	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getWindSc() {
		return windSc;
	}

	public void setWindSc(String windSc) {
		this.windSc = windSc;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public String getWindSpd() {
		return windSpd;
	}

	public void setWindSpd(String windSpd) {
		this.windSpd = windSpd;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public String getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(String windDeg) {
		this.windDeg = windDeg;
	}

	public String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}

	public String getCondTxt() {
		return condTxt;
	}

	public void setCondTxt(String condTxt) {
		this.condTxt = condTxt;
	}

	public String getCondCode() {
		return condCode;
	}

	public void setCondCode(String condCode) {
		this.condCode = condCode;
	}
}