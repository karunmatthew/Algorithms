package org.km.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static void main(String[] args) {

		String text = "ABCD";
		List<String> permutations = permute(text);
		System.out.println(permutations);
		System.out.println(permutations.size());

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
					permutations.add(entry.substring(0, i) + character + entry.substring(i, entry.length()));
				}
				permutations.add(entry + character);
			}
		}
		return permutations;
	}
}
