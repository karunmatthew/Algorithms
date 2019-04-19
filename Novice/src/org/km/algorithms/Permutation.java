package org.km.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static int count = 0;
	public static void main(String[] args) {

		String text = "ABCDE";
		List<String> permutations = permute(text);
		//System.out.println(permutations);
		System.out.println(permutations.size());
		System.out.println(count);

	}

	public static List<String> permute(String text) {
		
		List<String> permutations = new ArrayList<String>();

		if (text.length() == 1) {
			permutations.add(text);
		} else {
			String character = text.charAt(text.length() - 1) + "";
			List<String> aList = permute(text.substring(0, text.length() - 1));
			for (String entry : aList) {
				for (int i = 0; i < entry.length(); i++) {
					count++;
					permutations.add(entry.substring(0, i) + character + entry.substring(i, entry.length()));
				}
				permutations.add(entry + character);
			}
		}
		return permutations;
	}
}
