package com.co.certification.despegarautomation.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset; 
public class FilloConnection {

	private static Connection connection;
	private static Recordset recordset;
	private static final String SCENARIO = "ESCENARIO";  
	private FilloConnection() {
	}

	public static List<String> data(String scenarioNumber) {
		System.setProperty("ROW", scenarioNumber);
		Fillo fillo = new Fillo();
		try {
			connection = fillo.getConnection(SetFeature.getFileExcel());
			String strQuery = "Select * from " + SetFeature.getSheetsName();
			recordset = connection.executeQuery(strQuery);
			return recordset.getFieldNames();
		} catch (Exception e) {
			Logger.getLogger("Exception").log(Level.WARNING, e.getMessage());
		}
		return Collections.emptyList();
	}

	public static void closeConnection() {
		recordset.close();
		connection.close();
	}
	
	public static List<String> numberScenario(){
		List<String> numberScenarios = new ArrayList<>();
		Fillo fillo = new Fillo();
		try {
			connection = fillo.getConnection(SetFeature.getFileExcel());
			String strQuery = "Select * from " + SetFeature.getSheetsName();
			recordset = connection.executeQuery(strQuery);
			while (recordset.next()) {
				if (!recordset.getField(SCENARIO).isEmpty()) {
					numberScenarios.add(recordset.getField(SCENARIO));
				}
			}
			return numberScenarios;
			
		} catch (Exception e) {
			Logger.getLogger("Exception").log(Level.WARNING, e.getMessage());
		}
		return Collections.emptyList();
	}

	
}

