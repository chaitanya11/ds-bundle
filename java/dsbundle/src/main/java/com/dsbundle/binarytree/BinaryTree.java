package com.dsbundle.binarytree;

import java.util.Iterator;

import com.dsbundle.models.BinaryTreeNode;

/**
 * Binary Tree implementation
 *
 */
public class BinaryTree<T> {
	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Inserts values randomly
	 * 
	 * @param value
	 */
	public void insertValue(T value) {
		this.root = this.insertNode(root, value);
	}

	private BinaryTreeNode<T> insertNode(BinaryTreeNode<T> node, T value) {
		if (node == null) {
			node = new BinaryTreeNode<T>(value);
			System.out.println("Inserting value:" + value);

		} else {
			if (node.getLeft() == null) {
				node.setLeft(insertNode(node.getLeft(), value));
			} else {
				node.setRight(insertNode(node.getRight(), value));
			}
		}
		return node;
	}

	private String preOrderTraverse(BinaryTreeNode<T> node) {
		final StringBuilder stringBuilder = new StringBuilder();
		Iterator<BinaryTreeNode<T>> iterator = node.getPreOrderIterator();
		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next().getValue());
		}
		return stringBuilder.toString();
	}

	public String postOrderTraverse(BinaryTreeNode<T> node) {
		final StringBuilder stringBuilder = new StringBuilder();
		Iterator<BinaryTreeNode<T>> iterator = node.getPostOrderIterator();
		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next().getValue());
		}
		return stringBuilder.toString();
	}

	public String inOrderTraverse(BinaryTreeNode<T> node) {
		final StringBuilder stringBuilder = new StringBuilder();
		Iterator<BinaryTreeNode<T>> iterator = node.getInOrderIterator();
		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next().getValue());
		}
		return stringBuilder.toString();
	}

	public String levelOrderTraverse(BinaryTreeNode<T> node) {
		final StringBuilder stringBuilder = new StringBuilder();
		Iterator<BinaryTreeNode<T>> iterator = node.getLevelOrderIterator();
		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next().getValue());
		}
		return stringBuilder.toString();
	}

	public String preOrderTraverseTree() {
		return this.preOrderTraverse(root);
	}

	/**
	 * @return the root
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root root
	 */
	public void setRoot(final BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Searches for the given node in the tree returns the node if found and null,
	 * if not present.
	 * 
	 * @param value
	 * @return
	 */
	public BinaryTreeNode<T> searchValue(BinaryTreeNode<T> value) {
		return this.searchForValue(root, value);
	}

	/**
	 * Searches for the given node in the tree returns the node if found and null,
	 * if not present.
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private BinaryTreeNode<T> searchForValue(BinaryTreeNode<T> node, BinaryTreeNode<T> value) {
		if (node != null) {
			if (value.equals(node.getValue())) {
				return node;
			} else {
				BinaryTreeNode<T> result = searchForValue(node.getLeft(), value);
				if (result == null) {
					result = searchForValue(node.getRight(), value);
				}
				return result;
			}
		}
		return null;
	}
}
