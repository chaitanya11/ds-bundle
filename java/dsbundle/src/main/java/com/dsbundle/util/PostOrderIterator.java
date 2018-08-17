package com.dsbundle.util;

import com.dsbundle.models.BinaryTreeNode;

import java.util.Stack;

/**
 * 1. Traverse the left subtree, i.e., call Postorder(left-subtree)
 * 2. Traverse the right subtree, i.e., call Postorder(right-subtree)
 * 3. Visit the root.
 * @param <E>
 */
public class PostOrderIterator<E extends BinaryTreeNode> implements Iterator<E> {
  private Stack<E> nodesStack;
  private E curr;

  public PostOrderIterator(final E root) {
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
