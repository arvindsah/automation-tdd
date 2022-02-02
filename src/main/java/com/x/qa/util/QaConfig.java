package com.x.qa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *load properties from multiple qa properties file
 *and keep them ready
 * @author Admin
 *
 */
public class QaConfig {
	
	private static final Logger log = LoggerFactory.getLogger(QaConfig.class);
	private final Properties props= new Properties();
	
	private QaConfig(){
		
		
		for (String fileName:Arrays.asList("cascadingJson.json", "propertyFileExample.properties")) {
			InputStream in =this.getClass().getClassLoader().getSystemResourceAsStream(fileName);
			
			try {
				props.load(in);
				log.info("property side {}",props.size());
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error on resouce:{}" , fileName,e);
			}
		}
		
	}
	private static class Holder{
		private static final QaConfig Instance = new QaConfig();
	}
	public static QaConfig getInstance() {
		return Holder.Instance;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	

}
