package com.hersa.solution.sum.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root;
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt = bt.createBinaryTree();

		/*bt.traverseInOrder(bt.root);
		System.out.println("------------------");
		bt.traversePreOrder(bt.root);
		System.out.println("------------------");
		bt.traversePostOrder(bt.root);*/
		
		bt.traverseLevelOrder();
	}
	
	private BinaryTree createBinaryTree() {
		
		BinaryTree bt = new BinaryTree();
		
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
		
		return bt;
	}
	
	public void traverseLevelOrder() {
		
		if (root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			
			Node node = nodes.remove();
			
			System.out.println(" " + node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
	
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.println(node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.println(node.value);
			traverseInOrder(node.right);
		}
	}
	
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.println(node.value);
		}
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
			
			int smallestValue = findSmallestValue(current.right);
			
			current.value = smallestValue;
			
			current.right = deleteRecursive(current.right, smallestValue);
			
			return current;
			
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		current.right = deleteRecursive(current.right, value);
		
		return current;
		
	}
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public boolean containsNode(int i) {
		return containsNodeRecursive(root, i);
	}

	private boolean containsNodeRecursive(Node current, int value) {
	
		if (current == null) {
			return false;
		}
		
		if (current.value == value) {
			return true;
		}
		
		if (value < current.value) {
			return containsNodeRecursive(current.left, value);
		}if (value > current.value) {
			return containsNodeRecursive(current.right, value);
		}
		
		return false;
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
		}else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}else {
			return current;
		}
		
		return current;
	}
}
