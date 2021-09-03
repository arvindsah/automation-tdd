package com.tests;

import org.testng.annotations.Test;

public class Sample extends BaseTest{

	@Test
	public void loginTest() throws InterruptedException {
		this.getDriver().get(base.getProperty("url"));
		Thread.sleep(5000l);
	}
	
	
	
}
