package org.km.algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable {

	private String name;
	private boolean isVisited = false;
	private boolean isAdded = false;
	
	private List<Node> edges = new ArrayList<>();;

	Node(String name) {
		this.name = name;
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

	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	@Override
	public int compareTo(Object o) {
		return this.getName().compareTo(((Node)o).getName());
	}

	@Override
	public String toString() {
		return "Node [name=" + name + "]";
	}
	
	

}
