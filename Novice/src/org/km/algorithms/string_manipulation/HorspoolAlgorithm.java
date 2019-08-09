package org.km.algorithms.string_manipulation;

import java.util.HashMap;
import java.util.Map;

public class HorspoolAlgorithm {

	public static Map<String, Integer> shift = new HashMap<String, Integer>();

	public static void main(String[] args) {

		String pattern = "BARBER";
		String text = "RBEERBARBBARBERBARBY";
		buildShiftMap(pattern);
		System.out.println(shift);
		System.out.println("MATCH AT " + horspoolMatching(text, pattern));
	}

	public static void buildShiftMap(String pattern) {
		int m = pattern.length();
		shift.put("*", m);
		shift.put(pattern.charAt(pattern.length() - 1) + "", m);

		String character = "";
		int index = 0;
		for (int i = 0; i < m - 1; i++) {

			character = pattern.charAt(i) + "";
			index = pattern.length() - i - 1;
			shift.put(character, index);
		}
	}

	public static int horspoolMatching(String text, String pattern) {

		int m = pattern.length();
		int n = text.length();

		int textIndex = m - 1;
		int patternIndex = m - 1;

		while (textIndex < n) {

			int a = 0;
			while (a < m && pattern.charAt(patternIndex - a) == text.charAt(textIndex - a)) {
				a++;
			}

			if (a == m) {
				return textIndex - m + 1;
			} else {
				String currentCharacter = text.charAt(textIndex) + "";
				int shiftIndex = shift.containsKey(currentCharacter) == true ? shift.get(currentCharacter)
						: shift.get("*");
				textIndex = textIndex + shiftIndex;
			}
		}

		return -1;
	}
}
