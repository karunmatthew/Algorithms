package org.km.algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BFS {

	public static int count = 0;

	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");

		A.addRelationship(C, D, E);
		D.addRelationship(A, C);
		C.addRelationship(A, D, F);
		E.addRelationship(A, B, F);
		B.addRelationship(E, F);
		F.addRelationship(B, C, E);

		G.addRelationship(H, J);
		H.addRelationship(G, I);
		I.addRelationship(H, J);
		J.addRelationship(G, I);

		LinkedList<Node> searchQueue = new LinkedList<>();

		// searchQueue.push(A);
		// search(searchQueue);

		count = 0;
		// searchAlt(A, searchQueue);

		Map<Node, List<Node>> adjacencyList = new HashMap<>();

		BFS.addEntries(adjacencyList, A, C, D, E);
		BFS.addEntries(adjacencyList, B, E, F);
		BFS.addEntries(adjacencyList, C, A, D, F);
		BFS.addEntries(adjacencyList, D, A, C);
		BFS.addEntries(adjacencyList, E, A, B, F);
		BFS.addEntries(adjacencyList, F, B, C, E);

		BFS.addEntries(adjacencyList, G, H, J);
		BFS.addEntries(adjacencyList, H, G, I);
		BFS.addEntries(adjacencyList, I, H, J);
		BFS.addEntries(adjacencyList, J, G, I);

		breadthFirstSearchAdjacencyList(adjacencyList);

	}

	/*
	 * Will not work independently. Uncomment the other mutator methods
	 */
	public static void breadthFirstSearchAdjacencyList(Map<Node, List<Node>> aList) {

		LinkedList<Node> queue = new LinkedList<>();

		for (Node node : aList.keySet()) {

			/*if (node.isVisited()) {
				continue;
			}*/

			queue.add(node);
			
			while (!queue.isEmpty()) {

				Node visitingNode = queue.removeFirst();
				if (!visitingNode.isVisited()) {
					count = count + 1;
					System.out.println(visitingNode.getName() + " " + count);
					visitingNode.setAsVisited();

					for (Node neighbour : visitingNode.getEdges()) {
						if (!neighbour.isVisited()) {
							queue.add(neighbour);
						}
					}
				}

			}

		}

	}

	public static void addEntries(Map<Node, List<Node>> adjacencyList, Node key, Node... nodes) {

		List<Node> nodeList = new ArrayList<Node>();
		for (Node node : nodes) {
			nodeList.add(node);
		}
		adjacencyList.put(key, nodeList);
	}

	public static void search(LinkedList<Node> searchStack) {

		if (searchStack.size() == 0) {
			return;
		}

		Node node = searchStack.removeFirst();
		if (!node.isVisited()) {
			node.setAsVisited();
			count++;
			System.out.println(node.getName() + "  " + count);
			List<Node> neighbours = node.getEdges();
			for (Node neighbour : neighbours) {
				if (!neighbour.isVisited()) {
					searchStack.add(neighbour);
				}
			}
		}
		search(searchStack);
	}

	public static void searchAlt(Node node, LinkedList<Node> queue) {

		if (node.isVisited())
			return;

		count++;
		System.out.println(node.getName() + " " + count);
		node.setAsVisited();

		for (Node adjacentNode : node.getEdges()) {
			if (!adjacentNode.isVisited()) {
				queue.add(adjacentNode);
			}
		}

		while (!queue.isEmpty()) {
			searchAlt(queue.removeFirst(), queue);
		}

	}

}
