package com.hersa.solution.sum.bst;

public class Node {

	Node left;
	Node right;
	Node parent;
	
	int value;
	int sum;
	
	public Node(int value) {
		this.value = value;
		this.right = null;
		this.left = null;
		this.parent = null;
		this.sum = 0;
	}
	
	
}
