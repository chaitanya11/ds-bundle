package com.dsbundle.models;

/* BST Node containing left and right child of current node and key value */
public class BSTNode {
	int key;
	BSTNode left, right;

	public BSTNode(int item) {
		key = item;
		left = right = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}
	
}
