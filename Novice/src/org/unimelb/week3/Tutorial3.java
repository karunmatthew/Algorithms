package org.unimelb.week3;

import java.util.Scanner;

public class Tutorial3 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			question1();
			question2();
			question3();
		} finally {
			scanner.close();
		}
	}

	/*
	 * Write a program that reads two floating point numbers and print their sum,
	 * difference, and product
	 */
	public static void question1() {
		System.out.println("Enter a number");
		float num1 = scanner.nextFloat();
		System.out.println("Enter another number");
		float num2 = scanner.nextFloat();

		System.out.printf("%-12s: " + (num1 + num2) + "%n", "SUM");
		System.out.printf("%-12s: " + Math.abs(num1 - num2) + "%n", "DIFFERENCE");
		System.out.printf("%-12s: " + num1 * num2 + "%n", "PRODUCT");
	}

	/*
	 * Write a program that reads the radius of a sphere and prints its volume and
	 * surface area
	 */
	public static void question2() {
		float radius = 0;
		System.out.println("Enter the radius of the sphere");
		radius = scanner.nextFloat();
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
		System.out.printf("%-15s : %6.3f%n", "VOLUME", volume);
		System.out.printf("%-15s : %6.3f%n", "SURFACE AREA", surfaceArea);
	}

	/*
	 * Write a program that calculates the total wages based on the number of hours
	 * worked. The wages are calculated at a rate of 8.25 per hour for hours less
	 * than 40 and at the rate of 1.5 the standard rate for any hours greater than
	 * 40. Number of hours is a command line argument to the program
	 */
	public static void question3() {
		System.out.println("Enter the hours worked");
		scanner.hasNext();
		int hours = scanner.nextInt();
		double wages = hours > 40 ? (hours - 40) * 1.5 * 8.25 + 40 * 8.25 : hours * 8.25;
		System.out.printf("HOURS : %d%n", hours);
		System.out.printf("WAGES : %.2f%n", wages);
	}
}
