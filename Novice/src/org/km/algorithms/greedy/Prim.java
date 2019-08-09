package org.km.algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

public class Prim {
	
	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.weightedEdges.put(n2, 3);
		n1.weightedEdges.put(n3, 4);
		n1.weightedEdges.put(n4, 7);

		n2.weightedEdges.put(n1, 3);
		n2.weightedEdges.put(n3, 11);

		n3.weightedEdges.put(n1, 4);
		n3.weightedEdges.put(n2, 11);
		n3.weightedEdges.put(n4, 2);

		n4.weightedEdges.put(n1, 7);
		n4.weightedEdges.put(n3, 2);
		
		

	}
	
	
}

class Node {
	int nodeId;

	Map<Node, Integer> weightedEdges = new HashMap<Node, Integer>();

	Node(int id) {
		this.nodeId = id;
	}

	public Map<Node, Integer> getWeightedEdges() {
		return weightedEdges;
	}

	public void setWeightedEdges(Map<Node, Integer> weightedEdges) {
		this.weightedEdges = weightedEdges;
	}
}
