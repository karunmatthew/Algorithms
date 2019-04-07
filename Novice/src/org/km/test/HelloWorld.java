package org.km.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");

		double a = 12344789.22231;
        char aa = 'Z';
		System.out.printf("Start%10.5eEnd", a);
		System.out.println();

		double price = 19.8;
		String name = "magic apple";
		System.out.printf("%4s%n", name);
		System.out.printf("$%.2fABCD", a, name);
		
		/* Currency Formatter */
		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println("\n" + currencyFormatter.format(14.444));
		
		System.out.println();
		DecimalFormat p1 = new DecimalFormat(".000");
		System.out.println(p1.format(7.0));
		
		DecimalFormat d1 = new DecimalFormat("00.00%");
		System.out.println(d1.format(-17.0));
		
		Scanner scanner = new Scanner(System.in);
		String aWord = scanner.next();
		String line = scanner.nextLine();
		System.out.println(aWord);
		System.out.println(line);
		scanner.close();
		
		String String;
		String = "34";

	}
}
