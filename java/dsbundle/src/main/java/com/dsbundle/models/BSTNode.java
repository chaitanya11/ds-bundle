package com.dsbundle.models;

import com.dsbundle.util.iterators.InOrderIterator;
import com.dsbundle.util.iterators.LevelOrderIterator;
import com.dsbundle.util.iterators.PostOrderIterator;
import com.dsbundle.util.iterators.PreOrderIterator;

import java.util.Iterator;

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
	public Iterator<BSTNode<T>> getInOrderIterator() {
		return new InOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator<BSTNode<T>> getPreOrderIterator() {
		return new PreOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator<BSTNode<T>> getPostOrderIterator() {
		return new PostOrderIterator<BSTNode<T>>(this);
	}

	@Override
	public Iterator<BSTNode<T>> getLevelOrderIterator() {
		return new LevelOrderIterator<BSTNode<T>>(this);
	}
}
