package com.x.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDataUtil {
	
	private static final Logger log= LoggerFactory.getLogger(ExcelDataUtil.class);
	private String inputFile;
	Map<String, List<Map<String, String>>> excelData;
	
	public void setInputFile(String inputFile) {
		
		this.inputFile=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\"+inputFile+".xlsx";
		
		log.info("file name {}", this.inputFile);
		
	}

	public Map<String, List<Map<String, String>>> getExcelData() {
		
		return this.excelData;
	}
	
	private void setExcelData(Map<String, List<Map<String, String>>> excelData) {
		this.excelData = excelData;
	}

	public void readInputFile() throws IOException {
		//InputStream is= this.getClass().getClassLoader().getResourceAsStream(inputFile);

		FileInputStream is= new FileInputStream( new File(inputFile));

		XSSFWorkbook wb = new XSSFWorkbook(is);
		int numberOfSheets=wb.getNumberOfSheets();
		DataFormatter format= new DataFormatter();
		Map<String, List<Map<String,String>>> excelData = new HashMap<String, List<Map<String,String>>>();
		
		for(int i=0; i<numberOfSheets; i++) {
			Sheet sheet= wb.getSheetAt(i);
			String sheetName=sheet.getSheetName();
			Iterator<Row> rowIterator=sheet.iterator();
			List<String> cellHeader= new ArrayList<String>();
			List<Map<String, String>> sheetData= new ArrayList<>();
			
			
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.iterator();
				
				if(row.getRowNum()==0) {
				while(cellIterator.hasNext()) {
					Cell cell =cellIterator.next();
					String cellValue=format.formatCellValue(cell);
					cellHeader.add(cellValue);
				
				}
				continue;
				}
				
				int j=0;
				Map<String, String> rowData= new HashMap<>();
				while(cellIterator.hasNext()) {
					Cell cell =cellIterator.next();
					String cellValue=format.formatCellValue(cell);
					rowData.put(cellHeader.get(j),cellValue);
					j++;
				}
				if(!rowData.isEmpty() || rowData.size() == cellHeader.size()) {
					sheetData.add(rowData);
				}
			}
			excelData.put(sheetName, sheetData);
			log.info("Input data sheet {}, Data {}", sheetName, sheetData);
		} 
		wb.close();
		setExcelData(excelData);
	} 


}
