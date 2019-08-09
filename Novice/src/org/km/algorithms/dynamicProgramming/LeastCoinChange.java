package org.km.algorithms.dynamicProgramming;

public class LeastCoinChange {

	static int[] deno = { 25, 10, 1 };
	static int n = 30;
	static int[][] memo = new int[n + 1][deno.length + 1];

	public static int coinCount(int balance, int index, int coinCount) {

		if (index >= deno.length) {
			return Integer.MAX_VALUE;
		}

		if (balance < 0) {
			return Integer.MAX_VALUE;
		}

		if (balance == 0) {
			return coinCount;
		}

		int coinCountOnSelect = Integer.MAX_VALUE;
		int coinCountNotSelected = Integer.MAX_VALUE;

		if (balance >= deno[index] && memo[balance - deno[index]][index] == 0) {
			coinCountOnSelect = coinCount(balance - deno[index], index, coinCount + 1);
			memo[balance - deno[index]][index] = coinCountOnSelect;
		} else if (balance >= deno[index] && memo[balance - deno[index]][index] != 0) {
			coinCountOnSelect = memo[balance - deno[index]][index];
		}

		if (memo[balance][index + 1] == 0) {
			coinCountNotSelected = coinCount(balance, index + 1, coinCount);
			memo[balance][index + 1] = coinCountNotSelected;
		} else {
			coinCountNotSelected = memo[balance][index + 1];
		}

		return Math.min(coinCountOnSelect, coinCountNotSelected);

	}
	
	public static void main(String[] args) {

		System.out.println(coinCount(n, 0, 0));
	}
}
