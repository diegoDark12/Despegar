package com.co.certification.despegarautomation.models;

import java.util.List;

public class ModelReserv {
	private String cityOrigin;
	private String cityDestination;
	private String dateGo;
	private String dateReturn;

	public ModelReserv(List<String> listData) {
		this.cityOrigin = listData.get(1);
		this.cityDestination = listData.get(2);
		this.dateGo = listData.get(3);
		this.dateReturn = listData.get(4);
	}


	public void setCityOrigin(String cityOrigin) {
		this.cityOrigin = cityOrigin;
	}

	public String getCityOrigin() {
		return cityOrigin;
	}
	

	public String getCityDestination() {
		return cityDestination;
	}

	public void setCityDestination(String cityDestination) {
		this.cityDestination = cityDestination;
	}
	
	

	public String getDateGo() {
		return dateGo;
	}


	public void setDateGo(String dateGo) {
		this.dateGo = dateGo;
	}


	public String getDateReturn() {
		return dateReturn;
	}


	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}


	public static ModelReserv getData(List<String> listData) {
		return new ModelReserv(listData);
	}
}
