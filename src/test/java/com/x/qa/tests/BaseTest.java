package com.x.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.BasePage;

public class BaseTest {
	
	BasePage base= new BasePage();
	
	@BeforeMethod
	public void setUp(){
		base.initProperties();
		base.initDriver();
		
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	protected WebDriver getDriver() {
		return base.getDriver();
	}

}
