package com.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetBooksApi extends Driver {
	
	
	@DataProvider(name="getBooks")
	public Iterator<Object[]> getBookPositiveScn(){
		
		String sheetName="getBookSheet";
		
		List<Map<String, String>> getBookSheetData=excelData.get(sheetName);
		
		Collection<Object[]> rowData= new ArrayList<Object[]>();
		
		
		for( Map<String, String> row:getBookSheetData) {
			rowData.add( new Object[] {row});
			
		}
		return rowData.iterator();
	}
	
	
	
	@Test()
			//dataProvider = "getBooks")
	public void getBooks() {
		
		
		String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();


        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");

        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));

        //This token will be used in later requests
        String token = JsonPath.from(jsonString).get("token");
	        
		RestAssured.baseURI = baseUrl;
		System.out.println("hello - am getBooks method");
		
		response = request.get("/BookStore/v1/Books");

	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println(response.body().asPrettyString());
	    jsonString = response.asString();
	    List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
	        Assert.assertTrue(books.size() > 0);

	         //This bookId will be used in later requests, to add the book with respective isbn
	    String bookId = books.get(0).get("isbn");
		
		
		//read the data file from testng file
		// read the file data as part of of the driver 
		// get the sheet data by providing the sheetName
		
		//make get api call and store the response
		
		// from response validate the required content
		
		
	}

}
