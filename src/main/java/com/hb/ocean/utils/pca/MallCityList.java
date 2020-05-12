package com.hb.ocean.utils.pca;

import java.util.List;

public class MallCityList {
	private String cityCode;
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	private String cityName;
	private List<MallAreaList> mallAreaList; 
	public List<MallAreaList> getMallAreaList() {
		return mallAreaList;
	}
	public void setMallAreaList(List<MallAreaList> mallAreaList) {
		this.mallAreaList = mallAreaList;
	}
	public MallCityList() {}
}
