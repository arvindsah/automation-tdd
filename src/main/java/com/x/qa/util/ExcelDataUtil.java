package com.x.qa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDataUtil {
	
	private static final Logger log= LoggerFactory.getLogger(ExcelDataUtil.class);
	private String inputFile;
	Map<String, List<Map<String, String>>> excelData;
	
	public void setInputFile(String inputFile) {
		this.inputFile=inputFile;
		
	}

	public Map<String, List<Map<String, String>>> getExcelData() {
		
		return this.excelData;
	}

	public void readInputFile() throws IOException {
		InputStream is= this.getClass().getResourceAsStream(inputFile);
		
		XSSFWorkbook wb = new XSSFWorkbook(is);
		int numberOfSheets=wb.getNumberOfSheets();
		
		for(int i=0; i<numberOfSheets; i++) {
			
		}
	}

}
