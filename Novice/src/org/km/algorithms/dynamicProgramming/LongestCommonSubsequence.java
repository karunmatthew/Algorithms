package org.km.algorithms.dynamicProgramming;

public class LongestCommonSubsequence {
	// Function to find length of Longest Common Subsequence of
	// sequences X[0..m-1] and Y[0..n-1]
	static String X = "ACDBABCDBACACDADACDACABABDCDACD", Y = "AABCDCADBCADACBADACABDCADACAB";
	static int cost[][] = new int[X.length() + 1][Y.length() + 1];

	public static int LCSLengthMemo(String X, String Y, int m, int n) {
		// return if we have reached the end of either sequence
		if (m == 0 || n == 0) {
			return 0;
		}

		if (cost[m][n] != 0) {
			return cost[m][n];
		}

		// if last character of X and Y matches
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			cost[m][n] = LCSLengthMemo(X, Y, m - 1, n - 1) + 1;
			return cost[m][n];
		}

		// else if last character of X and Y don't match
		cost[m][n] = Integer.max(LCSLengthMemo(X, Y, m, n - 1), LCSLengthMemo(X, Y, m - 1, n));
		return cost[m][n];
	}

	public static int LCSLength(String X, String Y, int m, int n) {
		// return if we have reached the end of either sequence
		if (m == 0 || n == 0) {
			return 0;
		}

		// if last character of X and Y matches
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			return LCSLength(X, Y, m - 1, n - 1) + 1;
		}

		// else if last character of X and Y don't match
		return Integer.max(LCSLength(X, Y, m, n - 1), LCSLength(X, Y, m - 1, n));
	}

	// main function
	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		System.out.println("The length of LCS is " + LCSLengthMemo(X, Y, X.length(), Y.length()));
		System.out.println(System.currentTimeMillis());
		System.out.println("The length of LCS is " + LCSLength(X, Y, X.length(), Y.length()));
		System.out.println(System.currentTimeMillis());
	}
}