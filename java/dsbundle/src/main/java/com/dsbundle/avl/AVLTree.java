package com.dsbundle.avl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static com.dsbundle.util.GeneralUtils.max;

import com.dsbundle.models.AVLNode;

public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> root;

	public AVLTree() {
		this.root = null;
	}

	/**
	 * @return the root
	 */
	public AVLNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root root
	 */
	public void setRoot(final AVLNode<T> root) {
		this.root = root;
	}

	// A utility function to get the height of the tree
	private int height(AVLNode<T> N) {
		if (N == null)
			return 0;

		return N.getHeight();
	}


	// Get Balance factor of node N
	private int getBalance(AVLNode<T> N) {
		if (N == null)
			return 0;

		return height(N.getLeft()) - height(N.getRight());
	}

	public void insert(T value) {
		this.root = insert(root, new AVLNode<T>(value));
	}

	public void insertAll(final List<T> values) {
		Iterator<T> nodesIterator = values.iterator();
		while (nodesIterator.hasNext()) {
			this.insert(nodesIterator.next());
		}
	}

	private AVLNode<T> insert(AVLNode<T> node, AVLNode<T> newNode) {
		/* 1. Perform the normal BST insertion */
		if (node == null)
			return newNode;
		boolean isLarger = node.compareTo(newNode) < 0 ? true : false;

		if (node.equals(newNode)) {
			return node;
		}

		if (isLarger)
			node.setRight(insert(node.getRight(), newNode));
		else
			node.setLeft(insert(node.getLeft(), newNode));

		/* 2. Update height of this ancestor node */
		node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this node
		 * became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		// newNode < node.getLeft().getKey()
		if (balance > 1 && (newNode.compareTo(node.getLeft()) < 0))
			return node.rightRotate();

		// Right Right Case
		// newNode > node.getRight().getKey()
		if (balance < -1 && (newNode.compareTo(node.getRight()) > 0))
			return node.leftRotate();

		// Left Right Case
		// newNode > node.getLeft().getKey()
		if (balance > 1 && (newNode.compareTo(node.getLeft()) > 0)) {
			node.setLeft(node.getLeft().leftRotate());
			return node.rightRotate();
		}

		// Right Left Case
		// newNode < node.getRight().getKey()
		if (balance < -1 && (newNode.compareTo(node.getRight()) < 0)) {
			node.setRight(node.getRight().rightRotate());
			return node.leftRotate();
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	public List<T> preOrderTraversal(final AVLNode<T> node) {
		final List<T> preOrderList = new ArrayList<>();
		final Iterator<AVLNode<T>> iterator = node.getPreOrderIterator();
		while (iterator.hasNext()) {
			preOrderList.add(iterator.next().getValue());
		}
		return preOrderList;
	}

	/*
	 * Given a non-empty binary search tree, return the node with minimum key value
	 * found in that tree. Note that the entire tree does not need to be searched.
	 */
	private AVLNode<T> minValueNode(AVLNode<T> node) {
		AVLNode<T> current = node;

		/* loop down to find the leftmost leaf */
		while (current.getLeft() != null)
			current = current.getLeft();

		return current;
	}

	public AVLNode<T> deleteNode(AVLNode<T> root, AVLNode<T> value) {
		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null)
			return root;
		boolean isBigger = root.compareTo(value) < 0 ? true : false;
		// If the value to be deleted is smaller than
		// the root's value, then it lies in left subtree
		if (!isBigger)
			root.setLeft(deleteNode(root.getLeft(), value));

		// If the value to be deleted is greater than the
		// root's value, then it lies in right subtree
		else if (isBigger)
			root.setRight(deleteNode(root.getRight(), value));

		// if value is same as root's value, then this is the node
		// to be deleted
		else {

			// node with only one child or no child
			if ((root.getLeft() == null) || (root.getRight() == null)) {
				AVLNode temp = null;
				if (temp == root.getLeft())
					temp = root.getRight();
				else
					temp = root.getLeft();

				// No child case
				if (temp == null) {
					temp = root;
					root = null;
				} else // One child case
					root = temp; // Copy the contents of
				// the non-empty child
			} else {

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				AVLNode<T> temp = minValueNode(root.getRight());

				// Copy the inorder successor's data to this node
				root.setValue(temp.getValue());

				// Delete the inorder successor
				root.setRight(deleteNode(root.getRight(), temp));
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.getLeft()) >= 0)
			return root.rightRotate();

		// Left Right Case
		if (balance > 1 && getBalance(root.getLeft()) < 0) {
			root.setLeft(root.getLeft().leftRotate());
			return root.rightRotate();
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.getRight()) <= 0)
			return root.leftRotate();

		// Right Left Case
		if (balance < -1 && getBalance(root.getRight()) > 0) {
			root.setRight(root.getRight().rightRotate());
			return root.leftRotate();
		}

		return root;
	}

	/**
	 * Search for a given node in the tree If present, Returns the node otherwise
	 * returns null
	 * 
	 * @param node
	 * @return
	 */
	public AVLNode<T> search(final AVLNode<T> node) {
		return searchForValue(this.root, node);

	}

	private AVLNode<T> searchForValue(AVLNode<T> node, AVLNode<T> searchNode) {
		if (node != null) {

			if (node.compareTo(searchNode) < 0) {
				// value of the node is less than the value searched, traverse right
				return searchForValue(node.getRight(), searchNode);
			} else if (node.compareTo(searchNode) > 0) {
				// value of the node is greater than the value searched, traverse left
				return searchForValue(node.getLeft(), searchNode);
			} else if (node.compareTo(searchNode) == 0) {
				return node;
			}
		}
		return null;
	}

}