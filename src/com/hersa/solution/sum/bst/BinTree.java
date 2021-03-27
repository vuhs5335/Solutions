package com.hersa.solution.sum.bst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinTree {

	Node root;
	
	public static void main(String[] args) {
		
		/*
		 * BinTree bt = new BinTree();
		 * 
		 * bt = bt.createBinaryTree();
		 * 
		 * System.out.println("=======in order========"); bt.traverseInOrder(bt.root);
		 * System.out.println("=======pre order========"); bt.traversePreOrder(bt.root);
		 * System.out.println("=======post order========");
		 * bt.traversePostOrder(bt.root);
		 * System.out.println("=======level order========"); bt.traverseLevelOrder();
		 * 
		 * bt.delete(4);
		 */
		
		 int[][] a = {{140, 210} ,{10, 50}, {60, 120}};
			
		  Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
		  System.err.println(a); 
	}
	
	public BinTree createBinaryTree() {
		BinTree bt = new BinTree();
		
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
		
		return bt;
	}
	
	public boolean contains(int value) {
		return recursiveContains(root, value);
	}
	
	private boolean recursiveContains(Node current, int value) {
		
		if (current == null) {
			return false;
		}
		
		if (current.value == value) {
			return true;
		}
		
		if (value < current.value) {
			return recursiveContains(current.left, value);
		}
		
		return recursiveContains(current.right, value);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
		
		if (current == null) {
			return null;
		}
		
		if (current.value == value) {
			
			if (current.left == null && current.right == null) {
				return null;
			}
			
			if (current.left == null) {
				return current.right;
			}
			
			if (current.right == null) {
				return current.left;
			}
			
			// find the smallest value of my right node and that will be 
			// my current element.
			int smallest = findSmallest(current.right);
			
			current.value = smallest;
			//current.parent = smallest.parent;
			
			// delete my old smallest node values. 
			current.right = deleteRecursive(current.right, smallest);
			
			return current;
			
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		current.right = deleteRecursive(current.right, value);
		
		return current;
	}

	private int findSmallest(Node current) {
		return current.left == null ? current.value : findSmallest(current.left);
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private Node addRecursive(Node current, int value) {
		
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
			current.left.parent = current;
		}else if (value > current.value) {
			current.right = addRecursive(current.right, value);
			current.right.parent = current;
		} else {
			return current;
		}
		
		return current;
	}
	
	
	/* traverslas*/
	
	// depth first search
	public void traverseInOrder(Node current) {
		if (current != null) {
			traverseInOrder(current.left);
			System.out.println(current.value);
			traverseInOrder(current.right);
		}
	}
	
	public void traversePreOrder(Node current) {
		if (current != null) {
			System.out.println(current.value);
			traversePreOrder(current.left);
			traversePreOrder(current.right);
		}
	}
	
	public void traversePostOrder(Node current) {
		if (current != null) {
			traversePostOrder(current.left);
			traversePostOrder(current.right);
			System.out.println(current.value);
		}
	}
	
	//breadth
	public void traverseLevelOrder() {
		
		if (root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			
			Node node = nodes.remove();
		
			System.out.println(node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
}
