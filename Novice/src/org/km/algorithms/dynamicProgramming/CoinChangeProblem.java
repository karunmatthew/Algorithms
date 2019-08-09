package org.km.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Date;

public class CoinChangeProblem {

	static int n = 3000;
	static int coins[] = { 200, 100, 50, 20, 10, 5 };
	static int memo[][] = new int[n + 1][coins.length];

	public static void main(String[] args) {

		System.out.println(new Date());
		System.out.println(totalWays(n, 0));
		System.out.println(new Date());
		System.out.println(totalWaysMemo(n, 0));
		System.out.println(new Date());

		int m = coins.length;
		System.out.println(countWays(coins, m, n));
		System.out.println(new Date());
	}

	public static int totalWaysMemo(int valueLeft, int startIndex) {

		if (valueLeft < 0) {
			return 0;
		}

		if (startIndex >= coins.length) {
			return 0;
		}

		if (coins.length == 0) {
			return 0;
		}

		if (valueLeft == 0) {
			return 1;
		}

		int selectedValues = 0, notSelectedValues = 0;
		if (valueLeft - coins[startIndex] >= 0 && memo[valueLeft - coins[startIndex]][startIndex] == 0) {
			selectedValues = totalWaysMemo(valueLeft - coins[startIndex], startIndex);
			memo[valueLeft - coins[startIndex]][startIndex] = selectedValues;
		} else if (valueLeft - coins[startIndex] >= 0 && memo[valueLeft - coins[startIndex]][startIndex] != 0) {
			selectedValues = memo[valueLeft - coins[startIndex]][startIndex];
		}

		if (valueLeft >= 0 && startIndex + 1 < coins.length && memo[valueLeft][startIndex + 1] == 0) {
			notSelectedValues = totalWaysMemo(valueLeft, startIndex + 1);
			memo[valueLeft][startIndex + 1] = notSelectedValues;
		} else if (valueLeft >= 0 && startIndex + 1 < coins.length && memo[valueLeft][startIndex + 1] != 0) {
			notSelectedValues = memo[valueLeft][startIndex + 1];
		}

		return selectedValues + notSelectedValues;
	}

	public static int totalWays(int valueLeft, int startIndex) {

		if (valueLeft < 0) {
			return 0;
		}

		if (startIndex >= coins.length) {
			return 0;
		}

		if (coins.length == 0) {
			return 0;
		}

		if (valueLeft == 0) {
			return 1;
		}

		return totalWays(valueLeft - coins[startIndex], startIndex) + totalWays(valueLeft, startIndex + 1);
	}

	static long countWays(int S[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}
}
