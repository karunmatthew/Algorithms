package org.km.algorithms;

public class Subsets {

	public static void main(String[] args) {
		String text = "ABC";
		generate(text, text.length());
	}

	public static void generate(String text, int n) {

		double temp;
		for (int i = 0; i < Math.pow(2, n); i++) {
			temp = i;
			for (int j = n - 1; j >= 0; j--) {
				if (Math.pow(2, j) <= temp) {
					temp = temp - Math.pow(2, j);
					System.out.print(text.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
