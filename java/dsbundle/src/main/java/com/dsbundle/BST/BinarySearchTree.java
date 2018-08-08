package com.dsbundle.BST;

import com.dsbundle.models.BSTNode;

public class BinarySearchTree {

	/**
	 * Root Node of the Binary Search Tree
	 */
	private BSTNode root;

	/**
	 * Constructor
	 */
	BinarySearchTree() {
		this.root = null;
	}

	/**
	 * This method inserts a new key in Binary Search Tree
	 * 
	 * @param key
	 */
	public void insert(int key) {
		this.root = insertRec(this.root, key);
	}

	/**
	 * This method deletes the provided key in Binary Search Tree
	 * 
	 * @param key
	 */
	public void deleteKey(int key) {
		this.root = deleteRec(this.root, key);
	}

	/**
	 * An utility function to return the inorder successor
	 * 
	 * @param root
	 * @return
	 */
	int minValue(BSTNode node) {
		int minv = node.getKey();
		while (node.getLeft() != null) {
			minv = node.getLeft().getKey();
			node = node.getLeft();
		}
		return minv;
	}

	/**
	 * A recursive utility function to insert a new key in Binary Search Tree
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private BSTNode insertRec(BSTNode node, int key) {

		/* If the tree is empty, return a new node */
		if (node == null) {
			node = new BSTNode(key);
			return node;
		}

		/* Otherwise, recur down the tree */
		if (key < node.getKey())
			node.setLeft(insertRec(node.getLeft(), key));
		else if (key > node.getKey())
			node.setRight(insertRec(node.getRight(), key));

		/* return the updated node pointer */
		return node;
	}

	/**
	 * A recursive utility function to delete a key in Binary Search Tree
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	BSTNode deleteRec(BSTNode node, int key) {
		/* Base Case: If the node is empty */
		if (node == null) {
			return node;
		}

		/* If node has a tree, recur down the tree */
		if (key < node.getKey()) {
			node.setRight(deleteRec(node.getLeft(), key));
		} else if (key > root.getKey()) {
			node.setRight(deleteRec(node.getRight(), key));
		} else {
			// If current node has the key to be deleted

			// node with only one child or no child
			if (node.getLeft() == null)
				return node.getRight();
			else if (node.getRight() == null)
				return node.getLeft();

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			node.setKey(minValue(node.getRight()));

			// Delete the inorder successor
			node.setRight(deleteRec(node.getRight(), node.getKey()));
		}

		return node;
	}

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	/**
	 * In order traversal of Binary Search Tree
	 * 
	 * @param root
	 */
	void inorderRec(BSTNode node) {
		if (node != null) {
			inorderRec(node.getLeft());
			// TODO : To remove Sys out and send values in list
			System.out.println(node.getKey());
			inorderRec(node.getRight());
		}
	}

}