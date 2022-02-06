package com.tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.x.qa.util.ExcelDataUtil;

public class GetBooksApi extends Driver {
	
	
	@Test
	public void getBooks() {
		System.out.println("hello - am getBooks method");
		
		String sheetName="getBookSheet";
		
		List<Map<String, String>> getBookSheetData=excelData.get(sheetName);
		
		//read the data file from testng file
		// read the file data as part of of the driver 
		// get the sheet data by providing the sheetName
		
		//make get api call and store the response
		
		// from response validate the required content
		
		
	}

}
