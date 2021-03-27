package com.hersa.solution.sum.bst;

public class Node2 {

	Node[] childern;
	Node2 parent;
	
	int value;
	int sum;
	
	public Node2(int value) {
		this.value = value;
		this.childern = null;
		this.parent = null;
		this.sum = 0;
	}
	
}
