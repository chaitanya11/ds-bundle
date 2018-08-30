package com.dsbundle.bst;

import com.dsbundle.models.BSTNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * Root Node of the Binary Search Tree
	 */
	private BSTNode<T> root;

	/**
	 * @return the root
	 */
	public BSTNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root root
	 */
	public void setRoot(final BSTNode<T> root) {
		this.root = root;
	}

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
	public void insert(T key) {
		this.root = insertRec(this.root, new BSTNode<T>(key));
	}

	public void insertAll(final List<T> nodes) {
		final Iterator<T> iterator = nodes.iterator();
		while(iterator.hasNext()) {
			this.insert(iterator.next());
		}
	}

	/**
	 * This method deletes the provided key in Binary Search Tree
	 * 
	 * @param key
	 */
	public void deleteKey(T key) {
		this.root = deleteRec(this.root, new BSTNode<T>(key));
	}

	/**
	 * An utility function to return the inorder successor
	 * 
	 * @param node
	 * @return
	 */
	T minValue(BSTNode<T> node) {
		T minv = node.getValue();
		while (node.getLeft() != null) {
			minv = node.getLeft().getValue();
			node = node.getLeft();
		}
		return minv;
	}

	/**
	 * A recursive utility function to insert a new key in Binary Search Tree
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private BSTNode<T> insertRec(BSTNode<T> node, BSTNode<T> key) {

		/* If the tree is empty, return a new node */
		if (node == null) {
			return key;
		}

		/* Otherwise, recur down the tree */
		// key < node.getValue()
		boolean isLarger = node.compareTo(key) < 0 ? true : false;
		if (!isLarger)
			node.setLeft(insertRec(node.getLeft(), key));
		else
			node.setRight(insertRec(node.getRight(), key));

		/* return the updated node pointer */
		return node;
	}

	/**
	 * A recursive utility function to delete a key in Binary Search Tree
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	BSTNode<T> deleteRec(BSTNode<T> node, BSTNode<T> key) {
		/* Base Case: If the node is empty */
		if (node == null) {
			return key;
		}

		/* If node has a tree, recur down the tree */
		// key < node.getValue()
		if (node.compareTo(key) > 0) {
			node.setRight(deleteRec(node.getLeft(), key));
		} else if (node.compareTo(key) < 0) {
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
			node.setValue(minValue(node.getRight()));

			// Delete the inorder successor
			node.setRight(deleteRec(node.getRight(), node));
		}

		return node;
	}

	// This method mainly calls InorderRec()
	List<T> inorder() {
		return inorderRec(root);
	}

	List<T> preorder(final BSTNode<T> node) {
		final List<T> nodes = new ArrayList<T>();
		final Iterator<BSTNode<T>> inOrderIterator = node.getPreOrderIterator();
		while(inOrderIterator.hasNext()) {
			nodes.add(inOrderIterator.next().getValue());
		}
		return nodes;
	}

	List<T> postorder(final BSTNode<T> node) {
		final List<T> nodes = new ArrayList<T>();
		final Iterator<BSTNode<T>> inOrderIterator = node.getPostOrderIterator();
		while(inOrderIterator.hasNext()) {
			nodes.add(inOrderIterator.next().getValue());
		}
		return nodes;
	}

	List<T> levelorder(final BSTNode<T> node) {
		final List<T> nodes = new ArrayList<T>();
		final Iterator<BSTNode<T>> inOrderIterator = node.getLevelOrderIterator();
		while(inOrderIterator.hasNext()) {
			nodes.add(inOrderIterator.next().getValue());
		}
		return nodes;
	}

	/**
	 * In order traversal of Binary Search Tree
	 * 
	 * @param node
	 */
	List<T> inorderRec(final BSTNode<T> node) {
		final List<T> nodes = new ArrayList<T>();
		final Iterator<BSTNode<T>> inOrderIterator = node.getInOrderIterator();
		while(inOrderIterator.hasNext()) {
			nodes.add(inOrderIterator.next().getValue());
		}
		return nodes;
	}

}