package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// Base class
	//create base method to intilize the driver instanace
	
	
	ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public  WebDriver getDriver() {
		return tl.get();
	}
			
			
	
	public void initDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		tl.set(driver);
		
		}
}
