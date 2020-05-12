package com.hb.ocean.utils.pca;

import java.util.List;

public class ProviceList {
	private String provinceCode;
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	private String provinceName;
	private List<MallCityList> mallCityList;
	public List<MallCityList> getMallCityList() {
		return mallCityList;
	}
	public void setMallCityList(List<MallCityList> mallCityList) {
		this.mallCityList = mallCityList;
	}
	public ProviceList() {}
}
