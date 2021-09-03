package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	static Properties prop;
	public void initProperties() {
		String configFile= ".\\src\\main\\java\\config\\config.qa.properties";
		prop=  new Properties();
		try {
			prop.load(new FileInputStream(new File(configFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static String getProperty(String key) {
		return prop.getProperty(key);
		
	}
			
			
	
}
