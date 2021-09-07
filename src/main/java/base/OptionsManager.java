package base;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties prop;

	public OptionsManager(Properties prop) {
		this.prop=prop;
		}
	
	public ChromeOptions getChromeOptions() {
		
			// silent chrome driver logs
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			//OR
			System.setProperty("webdriver.chrome.silentOutput", "true");
			co = new ChromeOptions();
			
			//String downloadFilepath = System.getProperty("user.dir")+File.separator+"download"+File.separator;
			String downloadFilepath = System.getProperty("user.dir")+File.separator+"downloads";
			
			//set the download path and disable save as modal window
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("download.prompt_for_download", "false");
			co.setExperimentalOption("prefs", chromePrefs);
			
			co.addArguments("--disable-notifications", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
			
			
			co.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			co.setExperimentalOption("useAutomationExtension", false);
			co.addArguments("--start-maximized");
			
//			if(prop.getProperty("incognito").equals("true")) {co.addArguments("--incognito");}
//			if(prop.getProperty("headless").equals("true")) {co.addArguments("--headless");}
//			
			
						
			return co;
		}
	
	public FirefoxOptions getFirefoxOptions() {
		
		// Creating FirefoxOptions to set profile
		 fo = new FirefoxOptions();
//		 if(prop.getProperty("incognito").equals("true")) fo.addArguments("--incognito");
//     	 if(prop.getProperty("headless").equals("true")) fo.addArguments("--headless");
     	 
     	String downloadFilepath = System.getProperty("user.dir")+"\\downloads";
     	fo.addPreference("browser.download.dir", downloadFilepath);
     	fo.addPreference("browser.download.useDownloadDir", true);
     	fo.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
     	fo.addPreference("pdfjs.disabled", true);
     	 
     	 // Creating firefox profile
         /*FirefoxProfile profile = new FirefoxProfile();
  
         // Instructing firefox to use custom download location
         profile.setPreference("browser.download.folderList", 2);
         profile.setPreference("browser.download.useDownloadDir", true);
         profile.setPreference("pdfjs.disabled", true);
  
         // Setting custom download directory
        
         profile.setPreference("browser.download.dir", downloadFilepath);
  
         // Skipping Save As dialog box for types of files with their MIME
         profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                 "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
  
         
         fo.setProfile(profile);*/
     	 
     	 //TODO check FF download location issue
     	System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
     	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
     	 return fo;
		}
	
}
