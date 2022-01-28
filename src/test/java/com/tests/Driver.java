package com.tests;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.x.qa.util.AssertionUtil;
import com.x.qa.util.ExcelDataUtil;
import com.x.qa.util.ExtentReportUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Driver {
	
	private static final Logger log= LoggerFactory.getLogger(Driver.class);
	public static Map<String, List<Map<String, String>>> excelData;
	public static ExtentReports extentReport; 
	public static ExtentTest child; 
	public static AssertionUtil reportLog;
	/**
	 * 1. read a data for run
	 * @param env
	 * @param suiteName
	 * @param inputFile
	 * 
	 * 2. DB connection
	 * 3. Assertion Util
	 * 4. Extent Report Utl
	 * 
	 */
	
	@BeforeSuite
	@Parameters({"environment", "suite", "inputFile"})
	public void BeforeSuiteSetup(String env, String suiteName, String inputFile) {
		ExcelDataUtil excelDataFile= new ExcelDataUtil();
		excelDataFile.setInputFile(inputFile);
		excelDataFile.readInputFile();
		excelData=excelDataFile.getExcelData();
		
		extentReport=ExtentReportUtil.createInstance(suiteName);
		reportLog= new AssertionUtil();
		
		
		
	}

}
