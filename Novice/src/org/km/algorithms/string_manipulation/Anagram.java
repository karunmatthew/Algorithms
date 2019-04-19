package org.km.algorithms.string_manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {

		List<String> aList = new ArrayList<String>();
		aList.add("RAT");
		aList.add("ART");
		aList.add("TAR");
		aList.add("BRAT");
		aList.add("NOON");
		aList.add("MOON");
		aList.add("MOO");
		aList.add("TOON");
		aList.add("NOOT");

		findAnagrams(aList);
	}

	/*
	 * Generates all possible anagrams
	 */
	public static List<String> anagram(String text) {

		List<String> anagrams = new ArrayList<String>();
		if (text.length() == 1) {
			anagrams.add(text);
		} else {
			String character = text.charAt(0) + "";
			List<String> smallerAnagrams = anagram(text.substring(1, text.length()));
			for (String entry : smallerAnagrams) {
				for (int i = 0; i < entry.length(); i++) {
					anagrams.add(entry.substring(0, i) + character + entry.substring(i));
				}
				anagrams.add(entry + character);
			}
		}
		return anagrams;
	}

	/*
	 * Find pairs of anagrams in a list of string
	 */
	private static void findAnagrams(List<String> aList) {

		List<String> sortedWords = new ArrayList<String>();

		Map<String, List<String>> matchedAnagrams = new HashMap<String, List<String>>();

		for (String entry : aList) {
			char chars[] = new char[entry.length()];
			for (int i = 0; i < entry.length(); i++) {
				chars[i] = entry.charAt(i);
			}
			quickSort(chars, 0, chars.length - 1);
			sortedWords.add(new String(chars));
		}

		for (int i = 0; i < aList.size(); i++) {
			for (int j = 0; j < aList.size(); j++) {
				if (i != j && sortedWords.get(i).contentEquals(sortedWords.get(j))) {
					if (!matchedAnagrams.containsKey(sortedWords.get(i))) {
						List<String> matchedEntry = new ArrayList<String>();
						matchedEntry.add(aList.get(i));
						matchedEntry.add(aList.get(j));
						matchedAnagrams.put(sortedWords.get(i), matchedEntry);
					} else if (!matchedAnagrams.get(sortedWords.get(i)).contains(aList.get(Math.max(i, j)))) {
						matchedAnagrams.get(sortedWords.get(i)).add(aList.get(Math.max(i, j)));
					}
				}
			}
		}

		System.out.println(matchedAnagrams);
	}

	private static void quickSort(char[] word, int lo, int hi) {

		if (lo < hi) {
			int pos = hoarePartition(word, lo, hi);
			quickSort(word, lo, pos - 1);
			quickSort(word, pos + 1, hi);
		}
	}

	private static int hoarePartition(char[] A, int lo, int hi) {

		char pivot = A[lo];
		int i = lo;
		int j = hi;

		while (i < j) {
			while (i < hi && A[i] <= pivot) {
				i++;
			}
			while (j > lo && A[j] > pivot) {
				j--;
			}
			swap(i, j, A);
		}
		swap(i, j, A);
		swap(lo, j, A);
		return j;
	}

	private static void swap(int i, int j, char[] A) {
		char temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
