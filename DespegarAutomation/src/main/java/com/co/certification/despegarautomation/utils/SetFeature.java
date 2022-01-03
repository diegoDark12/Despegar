package com.co.certification.despegarautomation.utils;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetFeature {
	private static String fileExcel;
	private static String sheetsName;
	private static BufferedReader buffReader;
    

	public static String getFileExcel() {
		return fileExcel;
	}

	public static void setFileExcel(String fileExcel) {
		SetFeature.fileExcel = fileExcel;
	}

	public static String getSheetsName() {
		return sheetsName;
	}

	public static void setSheetsName(String sheetsName) {
		SetFeature.sheetsName = sheetsName;
	}

	private SetFeature() {

	}

	private static List<File> listOfFeatureFiles(File folder) {
		List<File> featureFiles = new ArrayList<>();
		if (folder.getName().endsWith(".feature")) {
			featureFiles.add(folder);
		} else {

			for (File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					featureFiles.addAll(listOfFeatureFiles(fileEntry));
				} else if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
					featureFiles.add(fileEntry);
				}
			}
		}
		return featureFiles;
	}

	public static List<String> setFeature(File featureFile) throws IOException {
		List<String> fileData = new ArrayList<>();
		boolean featureData = false;
		boolean foundHashTag = false;
		String data;
		
		try {buffReader = new BufferedReader(new InputStreamReader(
					new BufferedInputStream(new FileInputStream(featureFile)), StandardCharsets.UTF_8));
			while ((data = buffReader.readLine()) != null) {
				String[] dataVector = null;
                String sheetName = null;
                String excelFilePath = null;
				if (data.trim().contains("##@externaldata")) {
					dataVector = data.trim().split("@");
					excelFilePath = dataVector[2];
                    sheetName = dataVector[3];
					foundHashTag = true;
					fileData.add(data);
					setFileExcel(excelFilePath);
	                setSheetsName(sheetName);
				}
				if (foundHashTag) {
					loopData(fileData);
					foundHashTag = false;
					featureData = true;
					continue;
				}
				if (data.startsWith("|") || data.endsWith("|")) {
					ifFeatureData(featureData, fileData, data);
					continue;
				} else {
					featureData = false;
				}
				fileData.add(data);
			}
			
		} catch (FileNotFoundException e) {
			Logger.getLogger("Exception").log(Level.WARNING, e.getMessage());
		}finally {
		buffReader.close();
		}

		return fileData;
	}

	private static List<String> ifFeatureData(boolean featureData, List<String> fileData, String data) {
		if (!featureData) {
			fileData.add(data);
		}
		return fileData;

	}

	public static List<String> loopData(List<String> fileData) {
		List<String> listData = FilloConnection.numberScenario();
		StringBuilder cellData = new StringBuilder("");
		for (int rowNumber = 0; rowNumber < listData.size(); rowNumber++) {
			cellData.append("   |");
			cellData.append(listData.get(rowNumber));
			cellData.append("   |");
			cellData.append("\n");
		}
		String cellDataStr = cellData.toString();
		fileData.add(cellDataStr);
		return fileData;

	}

	public static void overrideFeatureFiles(String featuresDirectoryPath) throws IOException {
		List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
		for (File featureFile : listOfFeatureFiles) {
			List<String> featureWithExcelData = setFeature(featureFile);
			try (BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(featureFile), StandardCharsets.UTF_8))) {
				for (String string : featureWithExcelData) {
					writer.write(string);
					writer.newLine();
				}
			}
		}

	}
}
