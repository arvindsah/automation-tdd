package com.tests;

import java.util.Arrays;

import org.testng.annotations.Test;

public class StringProblem {

	@Test
	public void StringReversal() {
		
		String input = "Today is January 5th";
		String[] orgInput = input.split(" ");
		String reveresedInput = "";

		for(int i=orgInput.length -1 ; i>=0 ; i--) {
			reveresedInput=reveresedInput+orgInput[i];
		}
		
		StringBuilder sb = new StringBuilder(reveresedInput);
		int counter=0;
		
		for(int i=0; i< orgInput.length -1 ; i++) {
		counter= counter+orgInput[i].length();
	    sb.insert(counter, " ");
	    counter++;
		}
		System.out.println("Actual string = "+sb.toString());
		System.out.println("Expected string = " + "5thJa nu aryisTo day");
	}
}
