package org.km.algorithms.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GeneralTopologicalSort {

	/*
	 * 
	 * REPRESENTAION USING BEFORE RELATION
	 * 
	 * A depth first search can be used to implement topological sort. The DFS has
	 * to start from the node that is has no initial dependencies
	 * 
	 * O(V +E)
	 */

	public static List<String> visitedNodes = new ArrayList<>();

	public static List<String> poppedList = new ArrayList<>();

	public static void main(String[] args) {

		Map<String, List<String>> dependencyList = new HashMap<String, List<String>>();

		List<String> aList = getDependentList(new String[] { "C" });
		List<String> bList = getDependentList(new String[] { "A", "D" });
		List<String> cList = getDependentList(new String[] { "E", "F" });
		List<String> dList = getDependentList(new String[] { "C" });
		List<String> eList = getDependentList(new String[] {});
		List<String> fList = getDependentList(new String[] { "E" });

		dependencyList.put("A", aList);
		dependencyList.put("B", bList);
		dependencyList.put("C", cList);
		dependencyList.put("D", dList);
		dependencyList.put("E", eList);
		dependencyList.put("F", fList);

		topologicalSort(dependencyList);

		// Need to reverse the pop order
		Collections.reverse(poppedList);
		System.out.println("Popped Out " + poppedList);
	}

	public static void topologicalSort(Map<String, List<String>> dependencyList) {
		for (String vertex : dependencyList.keySet()) {
			dfs(vertex, dependencyList);
		}
	}

	public static void dfs(String vertex, Map<String, List<String>> dependencyList) {

		if (!visitedNodes.contains(vertex)) {
			visitedNodes.add(vertex);
		} else {
			return;
		}

		for (String childVertex : dependencyList.get(vertex)) {
			if (!visitedNodes.contains(childVertex)) {
				dfs(childVertex, dependencyList);
			} else if (!poppedList.contains(childVertex)) {
				System.out.println("ACYCLIC");
				System.exit(0);
			}
		}

		// Add entry to list once all its children have been visited
		poppedList.add(vertex);

	}

	public static List<String> getDependentList(String[] dependents) {
		LinkedList<String> dependencyList = new LinkedList<String>();
		for (String dependent : dependents) {
			dependencyList.add(dependent);
		}
		return dependencyList;
	}
}
