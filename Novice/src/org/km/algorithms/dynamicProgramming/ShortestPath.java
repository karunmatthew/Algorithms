package org.km.algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import org.km.algorithms.search.Node;

public class ShortestPath {

	public static int[][] dist = { { 0, 4, 100, 100, 3 }, { 4, 0, 2, 100, 100 }, { 100, 2, 0, 1, 100 },
			{ 100, 100, 1, 0, 7 }, { 3, 100, 100, 7, 0 } };

	public static int[][] cost = new int[dist.length][dist.length];

	public static void main(String[] args) {

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				cost[i][j] = -1;
			}
		}

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");

		a.addWeightedEdge(b, 4);
		b.addWeightedEdge(c, 2);
		c.addWeightedEdge(d, 1);
		e.addWeightedEdge(d, 7);
		a.addWeightedEdge(e, 3);

		List<Integer> visitedNodes = new ArrayList<Integer>();
		System.out.println(System.currentTimeMillis());
		System.out.println(getShortestDistance(0, 4, visitedNodes));
		System.out.println(System.currentTimeMillis());

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int getShortestDistance(int start, int end, List<Integer> parentNodes) {

		int min = 100;

		List<Integer> visitedNodes = new ArrayList<Integer>();
		visitedNodes.add(start);

		for (Integer element : parentNodes) {
			visitedNodes.add(element);
		}

		if (start == end) {
			return 0;
		} else if (cost[start][end] != -1 && cost[start][end] != 100) {
			return cost[start][end];
		} else {

			// get neighboring nodes for start
			for (int i = 0; i < 5; i++) {
				int totalDistance = 100;
				if (dist[start][i] != 0 && dist[start][i] != 100 && !visitedNodes.contains(i)) {
					totalDistance = dist[start][i] + getShortestDistance(i, end, visitedNodes);
				}
				if (totalDistance < min) {
					min = totalDistance;
				}
			}
			cost[start][end] = min;
		}
		return min;
	}
	
}
