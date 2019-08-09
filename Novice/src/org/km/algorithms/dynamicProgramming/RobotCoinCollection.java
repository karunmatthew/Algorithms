package org.km.algorithms.dynamicProgramming;

public class RobotCoinCollection {

	static int coin[][]; // { { 0, 1, 0, 108 }, { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 100, 0, 0 } };
	static int cost[][];
	static int path[][];
	
	// gets coins collected from (0,0) to (x,y) memoization or top down approach
	public static int getBestPath(int x, int y) {

		if (cost[x][y] != -1) {
			return cost[x][y];
		} else if (x == 0 && y == 0) {
			cost[x][y] = coin[0][0];
		} else if (x == 0) {
			cost[x][y] = coin[x][y] + getBestPath(x, y - 1);
		} else if (y == 0) {
			cost[x][y] = coin[x][y] + getBestPath(x - 1, y);
		} else {
			cost[x][y] = Math.max(coin[x][y] + getBestPath(x - 1, y), coin[x][y] + getBestPath(x, y - 1));
		}

		return cost[x][y];
	}

	public static void main(String[] args) {

		int m, n;
		m = n = 500;

		cost = new int[m][n];
		coin = new int[m][n];
		path = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				coin[i][j] = (int) (Math.random() * 10);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cost[i][j] = -1;
				path[i][j] = -1;
			}
		}

		System.out.println(System.currentTimeMillis());
		System.out.println(getBestPath(m - 1, n - 1));
		System.out.println(System.currentTimeMillis());
		System.out.println(getBestPathNoArray(0, 0, m, n));
		System.out.println(System.currentTimeMillis());

	}



	/*
	 * Is extremely slow
	 */
	public static int getBestPathNoArray(int x, int y, int m, int n) {

		if (path[x][y] != -1) {
			return path[x][y];
		} else if (x == m - 1 && y == n - 1) {
			return coin[m - 1][n - 1];
		} else if (x == m - 1) {
			path[x][y] = coin[x][y] + getBestPathNoArray(x, y + 1, m, n);
		} else if (y == n - 1) {
			path[x][y] = coin[x][y] + getBestPathNoArray(x + 1, y, m, n);
		} else {
			path[x][y] = coin[x][y] + Math.max(getBestPathNoArray(x + 1, y, m, n), getBestPathNoArray(x, y + 1, m, n));
		}

		return path[x][y];

	}
}
