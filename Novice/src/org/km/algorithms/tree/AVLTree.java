package org.km.algorithms.tree;

public class AVLTree {

	public static void main(String[] args) {

		Node root = insert(null, 10);
		root = insert(root, 20);
		root = insert(root, (30));
		root = insert(root, (40));
		root = insert(root, (50));
		root = insert(root, (25));

		System.out.println();
		preorderTraversal(root);

	}

	public static void preorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		System.out.println(root.value);
		preorderTraversal(root.leftNode);
		preorderTraversal(root.rightNode);
	}

	public static void postorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		postorderTraversal(root.leftNode);
		postorderTraversal(root.rightNode);
		System.out.println(root.value);
	}

	public static void inorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inorderTraversal(root.leftNode);
		System.out.println(root.value);
		inorderTraversal(root.rightNode);
	}

	static int getBalance(Node N) {
		if (N == null)
			return 0;

		return getHeight(N.leftNode) - getHeight(N.rightNode);
	}

	public static Node insert(Node root, int key) {

		if (root == null) {
			return new Node(key);
		}
		if (key < root.value) {
			root.leftNode = insert(root.leftNode, key);
		} else {
			root.rightNode = insert(root.rightNode, key);
		}
		int leftTreeHeight = getHeight(root.leftNode);
		int rightTreeHeight = getHeight(root.rightNode);

		root.height = Math.max(leftTreeHeight, rightTreeHeight) + 1;
		int balance = getBalance(root);

		if (Math.abs(balance) > 1) {
			System.out.println("Violation at " + root.value + " during insert of " + key);
		}

		// rotate
		if (balance > 1 && key < root.leftNode.value) {
			return rightRotate(root);
		}
		// right heavy and node's right child also right heavy
		if (balance < -1 && key > root.rightNode.value) {
			return leftRotate(root);
		}
		if (balance > 1 && key > root.leftNode.value) {
			root.leftNode = leftRotate(root.leftNode);
			return rightRotate(root);
		}
		if (balance < -1 && key < root.rightNode.value) {
			root.rightNode = rightRotate(root.rightNode);
			return leftRotate(root);
		}
		return root;
	}

	public static Node rightRotate(Node y) {
		Node x = y.leftNode;
		Node T2 = x.rightNode;
		x.rightNode = y;
		y.leftNode = T2;

		x.height = Math.max(getHeight(x.leftNode), getHeight(x.rightNode)) + 1;
		y.height = Math.max(getHeight(y.leftNode), getHeight(y.rightNode)) + 1;

		return x;
	}

	public static int getHeight(Node n) {

		if (n == null) {
			return 0;
		} else {
			return n.height;
		}
	}

	public static Node leftRotate(Node y) {
		Node x = y.rightNode;
		Node T2 = x.leftNode;
		y.rightNode = T2;
		x.leftNode = y;

		x.height = Math.max(getHeight(x.leftNode), getHeight(x.rightNode)) + 1;
		y.height = Math.max(getHeight(y.leftNode), getHeight(y.rightNode)) + 1;

		return x;
	}
}

class Node {
	public int height = -1;
	public int value = 0;
	public Node leftNode = null;
	public Node rightNode = null;

	public Node() {

	}

	public Node(int n) {
		this.height = 1;
		this.value = n;
		// this.leftNode = new Node();
		// this.rightNode = new Node();
	}
}
