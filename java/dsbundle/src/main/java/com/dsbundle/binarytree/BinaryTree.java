package com.dsbundle.binarytree;

import java.util.Random;

import com.dsbundle.binarytree.model.BinaryTreeNode;

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
			System.out.println("Inserting root:" + value);
			return node;
		}
		if (node.getLeft() == null) {
			node.setLeft(new BinaryTreeNode<T>(value));
			System.out.println("Inserting value:" + value + "as left child of:" + node.getValue());
			return node;
		} else if (node.getRight() == null) {
			node.setRight(new BinaryTreeNode<T>(value));
			System.out.println("Inserting value:" + value + "as right child of:" + node.getValue());
			return node;
		}
		if (new Random().nextInt(2) % 2 == 0) {
			insertNode(node.getLeft(), value);
		} else {
			insertNode(node.getLeft(), value);
		}
		return node;
	}

	private void traverse(BinaryTreeNode<T> node) {
		if (node != null) {
			System.out.println(node.getValue());
			traverse(node.getLeft());
			traverse(node.getRight());
		}
	}

	public void traverseTree() {
		this.traverse(root);
	}
}
