package org.km.algorithms.dynamicProgramming;

public class TextJustification {

	public static int[][] score;
	public static int maxWidth = 10;
	public static int[] wordInLine;

	public static void main(String[] args) {

		String line = "Karun likes to eat a lot of icecream";

		String[] words = line.split(" ");
		for (String word : words) {
			System.out.println(word);
		}

		score = new int[words.length][words.length];
		wordInLine = new int[words.length];

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				score[i][j] = -1;
			}
			wordInLine[i] = -1;
		}

		System.out.println(justify(words, 0, 0, 10, 0));

		for (int lineNumber : wordInLine)
			System.out.println(lineNumber);

	}
	
	public static int justifyDP(String[] words, int startIndex) {
		
		//Newline starts at 
		return 0;
	}

	public static int justify(String[] words, int wordNumber, int lineNumber, int spaceLeft, int cost) {

		int badness = 1000;

		if (wordNumber >= words.length) {
			return cost;
		}
		if (score[wordNumber][lineNumber] != -1 && score[wordNumber][lineNumber] != 1000) {
			return score[wordNumber][lineNumber];
		} else {

			if (spaceLeft == 10) {
				wordInLine[wordNumber] = lineNumber;
				badness = justify(words, wordNumber + 1, lineNumber, 10 - words[wordNumber].length(),
						(int) Math.pow((10 - words[wordNumber].length()), 2));
				score[wordNumber][lineNumber] = badness;
			} else if (spaceLeft < words[wordNumber].length()) {
				wordInLine[wordNumber] = lineNumber + 1;
				badness = justify(words, wordNumber, lineNumber + 1, 10, cost + spaceLeft * spaceLeft);
				score[wordNumber][lineNumber] = badness;
			} else {
				int badnessSame = 1000;
				int badnessNext = 1000;

				badnessSame = justify(words, wordNumber + 1, lineNumber, spaceLeft - words[wordNumber].length(),
						cost + spaceLeft * (-2 * words[wordNumber].length())
								+ (words[wordNumber].length()) * (words[wordNumber].length()));
				badnessNext = justify(words, wordNumber, lineNumber + 1, 10, cost + spaceLeft * spaceLeft);

				if (badnessSame < badnessNext) {
					wordInLine[wordNumber] = lineNumber;
				} else {
					wordInLine[wordNumber] = lineNumber + 1;
				}

				badness = Math.min(badnessSame, badnessNext);
				score[wordNumber][lineNumber] = badness;
			}
		}

		return badness;
	}
	
	
}
