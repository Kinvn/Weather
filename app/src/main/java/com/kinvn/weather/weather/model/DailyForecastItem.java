package com.kinvn.weather.weather.model;

import com.google.gson.annotations.SerializedName;

public class DailyForecastItem{

	@SerializedName("date")
	private String date;

	@SerializedName("ss")
	private String ss;

	@SerializedName("tmp_min")
	private String tmpMin;

	@SerializedName("hum")
	private String hum;

	@SerializedName("vis")
	private String vis;

	@SerializedName("cond_txt_d")
	private String condTxtD;

	@SerializedName("pres")
	private String pres;

	@SerializedName("mr")
	private String mr;

	@SerializedName("pcpn")
	private String pcpn;

	@SerializedName("ms")
	private String ms;

	@SerializedName("cond_code_n")
	private String condCodeN;

	@SerializedName("wind_sc")
	private String windSc;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("wind_spd")
	private String windSpd;

	@SerializedName("pop")
	private String pop;

	@SerializedName("wind_deg")
	private String windDeg;

	@SerializedName("uv_index")
	private String uvIndex;

	@SerializedName("tmp_max")
	private String tmpMax;

	@SerializedName("cond_txt_n")
	private String condTxtN;

	@SerializedName("cond_code_d")
	private String condCodeD;

	@SerializedName("sr")
	private String sr;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getTmpMin() {
		return tmpMin;
	}

	public void setTmpMin(String tmpMin) {
		this.tmpMin = tmpMin;
	}

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

	public String getCondTxtD() {
		return condTxtD;
	}

	public void setCondTxtD(String condTxtD) {
		this.condTxtD = condTxtD;
	}

	public String getPres() {
		return pres;
	}

	public void setPres(String pres) {
		this.pres = pres;
	}

	public String getMr() {
		return mr;
	}

	public void setMr(String mr) {
		this.mr = mr;
	}

	public String getPcpn() {
		return pcpn;
	}

	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getCondCodeN() {
		return condCodeN;
	}

	public void setCondCodeN(String condCodeN) {
		this.condCodeN = condCodeN;
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

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	public String getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(String windDeg) {
		this.windDeg = windDeg;
	}

	public String getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}

	public String getTmpMax() {
		return tmpMax;
	}

	public void setTmpMax(String tmpMax) {
		this.tmpMax = tmpMax;
	}

	public String getCondTxtN() {
		return condTxtN;
	}

	public void setCondTxtN(String condTxtN) {
		this.condTxtN = condTxtN;
	}

	public String getCondCodeD() {
		return condCodeD;
	}

	public void setCondCodeD(String condCodeD) {
		this.condCodeD = condCodeD;
	}

	public String getSr() {
		return sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}
}