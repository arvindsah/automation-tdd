package com.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.x.qa.util.ExtentReportUtil;

public class ExtentReportTestet {
	
	@Test
	public void checkingReport() {
		ExtentReports extentReport=ExtentReportUtil.getInstance();
		extentReport.createTest("Arvind Sah");
		extentReport.flush();
		
	}
	
	@Test
	public void checkingExtentReportUsingVersion5() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();
	}
}
