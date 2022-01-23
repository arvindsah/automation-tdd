package com.tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClassLoader {
	
	@Test
	public void classLoader() throws IOException {
		File file = new File(System.getProperty("user.dir")+File.separator+"Resources"+ 
				File.separator+"jsonFile");
		//System.out.println(file.getAbsolutePath());
		
		//another way to load the content of the diffrent files
		//https://stackoverflow.com/questions/2914375/getting-file-path-in-java/21906160
		System.out.println("location" + getClass().getClassLoader().getResource(" ").getPath());
		InputStream inputStream=(this.getClass().getClassLoader().getResourceAsStream("jsonFile" + File.separator
				+"propertyFileExample.properties"));
		Properties prop = new Properties();
		prop.load(inputStream);
		
		System.out.println("file content  -  " +  IOUtils.toString(inputStream, "UTF-8"));
		
		System.out.println("all content of property file" + prop.toString());
		System.out.print("file content -- " +prop.getProperty("name"));
	}

}
