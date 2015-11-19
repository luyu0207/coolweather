package com.coolweather.app.model;

import java.io.Serializable;

public class County implements Serializable{
	private int id;
	private String countyName;
	private String countyCode;
	private String cityCode;
	private String stateDetailed;
	private String temp1;
	private String temp2;
	private String windState;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getStateDetailed() {
		return stateDetailed;
	}
	public void setStateDetailed(String stateDetailed) {
		this.stateDetailed = stateDetailed;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	public String getWindState() {
		return windState;
	}
	public void setWindState(String windState) {
		this.windState = windState;
	}
	
}
