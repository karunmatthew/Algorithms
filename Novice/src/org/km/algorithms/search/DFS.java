package org.km.algorithms.search;

import java.util.List;

public class DFS {

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

		search(A);

	}

	public static void search(Node node) {

		node.setAsVisited();
		List<Node> neighbours = node.getEdges();
		/*
		 * neighbours.sort(new Comparator<Node>() { public int compare(Node o1, Node o2)
		 * { return o1.getName().compareTo(o2.getName()); } });
		 */

		for (Node neighbour : neighbours) {

			if (!neighbour.isVisited()) {
				search(neighbour);
			}
		}

		count++;
		System.out.println(node.getName() + "  " + count);

	}
}
