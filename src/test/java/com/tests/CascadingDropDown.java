package com.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * https://www.youtube.com/watch?v=HxzO160e-sk&t=144s
 * @author Admin
 *
 *https://geodata.solutions/
 *https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_cascading_dropdown
 */
public class CascadingDropDown {
	private static WebDriver driver=null;
	@SuppressWarnings("deprecation")
	@Test
	public void CasecadeDropDownValidation() throws StreamReadException, DatabindException, IOException {
		
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("D:\\eclipse-workspace\\web-tdd\\Resources\\jsonFile\\UI.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Select select = new Select( driver.findElement(By.cssSelector("#subject")));
		List<WebElement> elementsList = select.getOptions();
		elementsList.remove(0);
		List<String> actualObject= new ArrayList<>();
		actualObject=elementsList.stream().map(ele->ele.getText()).collect(Collectors.toList());

		System.out.println("From UI " + actualObject);
		
		String fileLocation=System.getProperty("user.dir")+"\\Resources\\jsonFile\\cascadingJson.json";
		File file= new File(fileLocation);
		ObjectMapper objMap= new ObjectMapper();
		
		Map<String, Object> expected=objMap.readValue(file, new TypeReference<Map<String, Object>>(){});
		Set<String> expectedSet=expected.keySet();
		List<String> expectedlist=new ArrayList<String>();
		expectedlist.addAll(expectedSet);

		System.out.println("from json file " + expectedlist);
		Assert.assertEquals(actualObject, expectedlist);
		
		
		driver.findElement(By.cssSelector("#subject")).click();
		select.selectByValue("Front-end");
		Select selectTopic = new Select(driver.findElement(By.id("topic")));
		List<WebElement> listOfTopics= new ArrayList<WebElement>();
		listOfTopics=selectTopic.getOptions();
		listOfTopics.remove(0);
		List<String> listOfFroneEndTopics=listOfTopics.stream().map(e->e.getText()).collect(Collectors.toList());
		
		Map<String, Object> frontEndMap=(Map<String, Object>) expected.get("Front-end");
		Set<String> frontEndmapSet=frontEndMap.keySet();
		List<String>  ListExpectedFrontEndTopic= new ArrayList<>();
		ListExpectedFrontEndTopic.addAll(frontEndmapSet);
		System.out.println("Actul--- " + listOfFroneEndTopics+ ",  Exoected list " + frontEndmapSet);
		Assert.assertEquals(listOfFroneEndTopics,frontEndmapSet );
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("closed driver");
	}

}
