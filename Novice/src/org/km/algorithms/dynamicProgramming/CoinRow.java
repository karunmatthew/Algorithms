package org.km.algorithms.dynamicProgramming;

public class CoinRow {

	public static int coins[] = { 15, 26, 10, 0, 0, 500, 1000, 98 };
	public static int value[] = new int[coins.length];
	public static int table[] = new int[coins.length + 1];

	public static void main(String[] args) {

		int n = coins.length;
		System.out.println("Memoization Method : " + coinRowProblemMemo(n - 1));
		coinRowTabulation(coins.length);
		System.out.println("Tabulation Method  : " + table[coins.length]);

	}

	public static int coinRowProblemMemo(int n) {

		if (n < 0) {
			return 0;
		} else if (n == 0) {
			value[n] = coins[n];
		} else if (value[n] != 0) {
			return value[n];
		} else {
			value[n] = Math.max(coins[n] + coinRowProblemMemo(n - 2), coinRowProblemMemo(n - 1));
		}

		return value[n];
	}

	public static void coinRowTabulation(int n) {

		table[0] = 0;
		table[1] = coins[0];

		for (int i = 2; i <= n; i++) {
			table[i] = Math.max(coins[i - 1] + table[i - 2], table[i - 1]);
		}
	}

}
