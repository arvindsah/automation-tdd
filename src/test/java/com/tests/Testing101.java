package com.tests;

public class Testing101 {

	/**
	 * Q: Given a digit d and number N, Find the number of occurences of digit d in
	 * all even numbers from 1 to N. to Everyone input1 -> 22, 5 //o/p - 15, 5 //to
	 * Everyone //input2 -> 22, 2 //
	 */

	public static void main(String[] args) {
		findOccurance(12, 1);
		// output is 2
	}

	public static void findOccurance(int number, int digit) {
		int counter = 0;
		for (int i = 0; i <= number; i++) {
			int temp = i;
			if (i % 2 != 0)
				continue;

			do {
				if (String.valueOf(temp).substring(0, 0).contains(String.valueOf(digit))) {
					counter++;
				}
				temp = temp % 10;
			} while ((temp % 10 > 0));

			// every iteration reduce lenth of the temp 97, 77,
		}

		System.out.println("counter value " + counter);
	}
}