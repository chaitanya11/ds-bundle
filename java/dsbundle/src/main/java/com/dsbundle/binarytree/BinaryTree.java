package com.dsbundle.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dsbundle.models.BinaryTreeNode;

/**
 * Binary Tree implementation
 *
 */
public class BinaryTree<T extends Comparable<T>> {

	/**
	 * Root element of the BinaryTree
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Default Constructor of the BinaryTree
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * This method inserts values into the BinaryTree
	 * 
	 * @param value
	 */
	public void insertValue(final T value) {
		this.root = this.insertNode(root, value);
	}

	/**
	 * @param node
	 * @param value
	 * @return
	 */
	private BinaryTreeNode<T> insertNode(BinaryTreeNode<T> node, final T value) {
		if (node == null) {
			node = new BinaryTreeNode<T>(value);
			// System.out.println("Inserting value:" + value);
		} else {
			if (node.getLeft() == null) {
				node.setLeft(insertNode(node.getLeft(), value));
			} else {
				node.setRight(insertNode(node.getRight(), value));
			}
		}
		return node;
	}

    /**
     * Inserts all nodes in single stretch.
     * @param nodes
     */
	public void insertAll(final List<T> nodes) {
        Iterator<T> nodesIterator = nodes.iterator();
        while(nodesIterator.hasNext()) {
            this.insertValue(nodesIterator.next());
        }
    }
	/**
	 * This method returns the values of tree nodes in PreOrder manner.
	 * 
	 * @param node
	 * @return
	 */
	public List<T> preOrderTraverse(final BinaryTreeNode<T> node) {
		final ArrayList<T> preOrder = new ArrayList<T>();
		final Iterator<BinaryTreeNode<T>> iterator = node.getPreOrderIterator();
		while (iterator.hasNext()) {
			preOrder.add(iterator.next().getValue());
		}
		return preOrder;
	}

	/**
	 * This method returns the values of tree nodes in PostOrder manner.
	 * 
	 * @param node
	 * @return
	 */
	public List<T> postOrderTraverse(final BinaryTreeNode<T> node) {
		final ArrayList<T> postOrder = new ArrayList<T>();
		final Iterator<BinaryTreeNode<T>> iterator = node.getPostOrderIterator();
		while (iterator.hasNext()) {
			postOrder.add(iterator.next().getValue());
		}
		return postOrder;
	}

	/**
	 * This method returns the values of tree nodes in InOrder manner.
	 * 
	 * @param node
	 * @return
	 */
	public List<T> inOrderTraverse(final BinaryTreeNode<T> node) {
		final ArrayList<T> inOrder = new ArrayList<T>();
		final Iterator<BinaryTreeNode<T>> iterator = node.getInOrderIterator();
		while (iterator.hasNext()) {
			inOrder.add(iterator.next().getValue());
		}
		return inOrder;
	}

	/**
	 * This method returns the values of tree nodes in LevelOrder manner.
	 * 
	 * @param node
	 * @return
	 */
	public List<T> levelOrderTraverse(final BinaryTreeNode<T> node) {
		final ArrayList<T> levelOrder = new ArrayList<T>();
		final Iterator<BinaryTreeNode<T>> iterator = node.getLevelOrderIterator();
		while (iterator.hasNext()) {
			levelOrder.add(iterator.next().getValue());
		}
		return levelOrder;
	}

	/**
	 * This method returns the root of the BinaryTree
	 * 
	 * @return the root
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * This method sets the root of the BinaryTree
	 * 
	 * @param root
	 *            root
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
	public BinaryTreeNode<T> searchValue(final BinaryTreeNode<T> value) {
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
	private BinaryTreeNode<T> searchForValue(final BinaryTreeNode<T> node, final BinaryTreeNode<T> value) {
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
