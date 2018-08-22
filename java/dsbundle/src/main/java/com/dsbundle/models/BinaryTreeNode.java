package com.dsbundle.models;

import com.dsbundle.binarytree.BaseNode;
import com.dsbundle.util.InOrderIterator;
import com.dsbundle.util.Iterable;
import com.dsbundle.util.Iterator;
import com.dsbundle.util.LevelOrderIterator;
import com.dsbundle.util.PostOrderIterator;
import com.dsbundle.util.PreOrderIterator;

/**
 * Model for BinaryTree Node containing left and right child.
 *
 */
public class BinaryTreeNode<T> extends BaseNode<T> implements Iterable {

	private BinaryTreeNode<T> left, right;

	public BinaryTreeNode(T value) {
		super(value);
	}
	
	/**
	 * @return the left
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left left
	 */
	public void setLeft(final BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right right
	 */
	public void setRight(final BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public Iterator getInOrderIterator() {
		return new InOrderIterator<BinaryTreeNode>(this);
	}

	@Override
	public Iterator getPreOrderIterator() {
		return new PreOrderIterator<BinaryTreeNode>(this);
	}

	@Override
	public Iterator getPostOrderIterator() {
		return new PostOrderIterator<BinaryTreeNode>(this);
	}

	@Override
	public Iterator getLevelOrderIterator() {
		return new LevelOrderIterator<BinaryTreeNode>(this);
	}

	@Override
	public String toString() {
		return super.toString()+"BinaryTreeNode [left=" + left + ", right=" + right + "]";
	}
	
}
