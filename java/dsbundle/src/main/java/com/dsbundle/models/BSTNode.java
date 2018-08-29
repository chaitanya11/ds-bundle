package com.dsbundle.models;

import com.dsbundle.util.InOrderIterator;
import com.dsbundle.util.Iterator;
import com.dsbundle.util.LevelOrderIterator;
import com.dsbundle.util.PostOrderIterator;
import com.dsbundle.util.PreOrderIterator;

/* bst Node containing left and right child of current node and key value */
public class BSTNode<T extends Comparable<T>> extends BaseNode<T> {
	BSTNode<T> left, right;

	public BSTNode(T item) {
		super(item);
		left = right = null;
	}

	@Override
	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	@Override
	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	@Override
	public Iterator getInOrderIterator() {
		return new InOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator getPreOrderIterator() {
		return new PreOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator getPostOrderIterator() {
		return new PostOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator getLevelOrderIterator() {
		return new LevelOrderIterator<BSTNode<T>>(this);
	}
}
