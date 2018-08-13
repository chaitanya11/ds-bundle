package com.dsbundle.binarytree.model;

/**
 * Model for BinaryTree Node containing left and right child.
 *
 */
public class BinaryTreeNode<T> {

	private T value;
	private BinaryTreeNode<T> left, right;

	public BinaryTreeNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}
