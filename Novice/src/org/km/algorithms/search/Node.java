package org.km.algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements Comparable {

	private String name;
	private boolean isVisited = false;
	private boolean isAdded = false;
	public int height = 0;
	public int value = 0;
	public Node leftNode = new Node(0);
	public Node rightNode = new Node(0);

	private List<Node> edges = new ArrayList<>();
	private Map<Node, Integer> weightedEdges = new HashMap<Node, Integer>();

	public Node(String name) {
		this.name = name;
	}

	public Node(int n) {
		this.value = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getEdges() {
		return edges;
	}

	public void setEdges(List<Node> edges) {
		this.edges = edges;
	}

	public Map<Node, Integer> getWeightedEdges() {
		return weightedEdges;
	}

	public void setWeightedEdges(Map<Node, Integer> weightedEdges) {
		this.weightedEdges = weightedEdges;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isVisited() {
		return this.isVisited;
	}

	public void setAsVisited() {
		this.isVisited = true;
	}

	public void addRelationship(Node... nodes) {
		for (Node node : nodes) {
			this.edges.add(node);
		}
	}

	public void addWeightedEdge(Node n, int distance) {
		this.weightedEdges.put(n, distance);
	}

	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	@Override
	public int compareTo(Object o) {
		return this.getName().compareTo(((Node) o).getName());
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}

}
