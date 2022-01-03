package com.co.certification.despegarautomation.models;

import java.util.List;

import com.co.certification.despegarautomation.utils.FilloConnection;

public class Data {
	
	private static ModelReserv dataSSFF;
	 
	 private Data() {
		    throw new IllegalStateException("Utility class");
		  }
	public static void dataLoad(String scenarioNumber) {
		List<String> listData = FilloConnection.data(scenarioNumber);
		dataSSFF = ModelReserv.getData(listData);
		FilloConnection.closeConnection();
	}
	
	public static ModelReserv data()
	{
		return dataSSFF;
	}
}