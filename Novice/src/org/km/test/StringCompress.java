package org.km.test;

public class StringCompress {

	public static void main(String[] args) {

		String a = "a(-1)rdv(-4)(-4)k";

		int length = a.length();
		String b = "";
		for (int i = 0; i < length; i++) {
			if (a.charAt(i) != '(') {
				b = b + a.charAt(i);
			} else {
				while (a.charAt(i) != ')') {
					i++;
				}
			}
		}
		System.out.println(b);
	}
}
