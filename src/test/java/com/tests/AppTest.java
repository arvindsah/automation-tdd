package com.tests;


import java.time.Duration;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 
     * @throws  
     */
    @Test
    public void shouldAnswerWithTrue() 
    {
    	WebDriverManager.edgedriver().setup();
    	WebDriver driver= new ChromeDriver();
    	
    	driver.get("https://www.cowin.gov.in/");
    	driver.manage().window().maximize();
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role][2]")));
    	driver.findElement(By.xpath("//div[@role][2]")).click();
    	
    }
}
