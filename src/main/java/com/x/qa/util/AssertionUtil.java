package com.x.qa.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertionUtil {
	
	private String expected	,actual, log;
	private ExtentTest test;
	private int actualInteger,expectedInteger;
	
	private void extertLog() throws Exception
	{
		if (expected.equalsIgnoreCase(actual))
		{
		test.log(Status.PASS, log+ "verification pass with actual "+ actual+ " and exepcted " + expected);	
		}else {
			test.log(Status.FAIL, log+ "verification fail with actual "+ actual+ " and exepcted " + expected);
		}
	}
	
	
	public void ExtentInput(String actual, String expected, String log, ExtentTest test) throws Exception{
		this.actual=actual; this.expected=expected; this.log=log; this.test=test;
		extertLog();
	}
	
	//similarly for other time of validation we can add in the public methods like inputNotEqual,LogEquals();
	//NullCompare, notNullCompare, contains
	
	
	

}
