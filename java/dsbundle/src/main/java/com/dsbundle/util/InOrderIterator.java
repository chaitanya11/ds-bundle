package com.dsbundle.util;

import com.dsbundle.models.BinaryTreeNode;

import java.util.Stack;

/**
 * 1. Traverse the left subtree, i.e., call Inorder(left-subtree)
 * 2. Visit the root.
 * 3. Traverse the right subtree, i.e., call Inorder(right-subtree)
 * @param <E>
 */
public class InOrderIterator<E extends BinaryTreeNode> implements Iterator<E> {
  private Stack<E> nodesStack;
  private E curr;

  public InOrderIterator(final E root) {
    this.nodesStack = new Stack<>();
    this.curr = root;
  }

  @Override
  public boolean hasNext() {
    return this.curr != null;
  }

  @Override
  public E next() {
    E node = this.curr;

    return node;
  }
}
