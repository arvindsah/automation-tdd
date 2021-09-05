package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// Base class
	//create base method to intilize the driver instanace
	
	
	ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public synchronized WebDriver getDriver() {
		return tl.get();
	}
			
			
	
	public void initDriver() {
		
		
		WebDriver driver = null;
		String browser = null;
		if(System.getProperty("browser") != null) {
			browser=System.getProperty("browser");
		}else {
			browser=prop.getProperty("browser");
		}
		switch(browser){
			case "chrome" :
				WebDriverManager.chromedriver().setup();		
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();		
				driver = new FirefoxDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();		
				driver = new ChromeDriver();
				break;
		}
		 
		
		driver.manage().window().maximize();
		
		tl.set(driver);
		
		}
	static Properties prop;
	String env=null;
	public void initProperties() {
		String configFile= "."+File.separator+"src"+File.separator+"main"+File.separator+
				"java"+File.separator+"config"+File.separator;
		prop=  new Properties();
		
		if(System.getProperty("env")!=null) {
			env=System.getProperty("env");
		}else {
			System.out.println("setting default env as qa, as no value provided for env");
			env="qa";
		}
		
		switch(env) {
		case "qa":
			configFile=configFile.concat("config.qa.properties");
			break;
		case "uat":
			configFile=configFile.concat("config.uat.properties");
			break;
		case "sit":
			configFile=configFile.concat("config.sit.properties");
			break;
		default:
			configFile=configFile.concat("config.qa.properties");
			break;
		}
		
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
