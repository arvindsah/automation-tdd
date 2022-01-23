import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QaConfig {

	private static final Logger log= LoggerFactory.getLogger(QaConfig.class);
	private static Properties prop = new Properties();
	
	//private contructot
	private QaConfig(){
		log.info("Load properties");
		
		for(String resource: Arrays.asList("api.keys", "common.properties")) {
		
		/*
		 * class load will only work if the file
		 *  kept under source folder instead of normal folder
		 *  so make sure your file is kept under source folder
		 */
			try {
				InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(resource);
			
			Properties prop= new Properties();
			
				prop.load(inputStream);
				log.info("props size : {}", prop.size());
			} catch (IOException e) {
				
				e.printStackTrace();
				log.error("error while laoding resource : {}", resource ,e);
			}
			
			log.info("properties loaded successfully");
			
		}
	}
	
	public static QaConfig getInstance() {
		
		return Holder.QA_CONFIG_INSTANCE;
	}
	
	private static class Holder{
		private static final QaConfig QA_CONFIG_INSTANCE= new QaConfig();
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	
}
