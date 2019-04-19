package org.km.algorithms.bruteforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	/*
	 * 
	 * REPRESENTAION USING REQUIRES RELATION
	 * 
	 * A depth first search can be used to implement topological sort. The DFS has
	 * to start from the node that is has no initial dependencies
	 * 
	 * O(V +E)
	 */

	public static List<String> visitedNodes = new ArrayList<>();

	public static void main(String[] args) {

		Map<String, List<String>> dependencyList = new HashMap<String, List<String>>();

		List<String> aList = getDependentList(new String[] { "C" });
		List<String> bList = getDependentList(new String[] { "A", "D", "E" });
		List<String> cList = getDependentList(new String[] { "D" });
		List<String> dList = getDependentList(new String[] {});
		List<String> eList = getDependentList(new String[] { "C" });

		dependencyList.put("E", eList);
		dependencyList.put("A", aList);
		dependencyList.put("B", bList);
		dependencyList.put("C", cList);
		dependencyList.put("D", dList);

		topologicalSort(dependencyList);
	}

	public static void topologicalSort(Map<String, List<String>> dependencyList) {
		for (String vertex : dependencyList.keySet()) {
			dfs(vertex, dependencyList);
		}
	}

	public static void dfs(String vertex, Map<String, List<String>> dependencyList) {

		if (visitedNodes.contains(vertex)) {
			return;
		} else {
			for (String child : dependencyList.get(vertex)) {
				if (!visitedNodes.contains(child)) {
					dfs(child, dependencyList);
				}
			}
		}
		System.out.println(vertex);
		visitedNodes.add(vertex);

	}

	public static List<String> getDependentList(String[] dependents) {
		LinkedList<String> dependencyList = new LinkedList<String>();
		for (String dependent : dependents) {
			dependencyList.add(dependent);
		}
		return dependencyList;
	}
}
