package com.dsbundle.util;

import com.dsbundle.models.BaseNode;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 1. Traverse the left subtree, i.e., call Inorder(left-subtree)
 * 2. Visit the root.
 * 3. Traverse the right subtree, i.e., call Inorder(right-subtree)
 * @param <E>
 */
public class InOrderIterator<E extends BaseNode> implements Iterator<E> {
  private Stack<E> nodesStack;

  public InOrderIterator(final E root) {
    this.nodesStack = new Stack<>();
    this.findNextLeaf(root);
  }

  @Override
  public boolean hasNext() {
    return !this.nodesStack.empty();
  }


  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No other nodes found.");
    }

    E node = this.nodesStack.pop();
    findNextLeaf((E) node.getRight());
    return node;
  }

  private void findNextLeaf(E curr) {
    while (curr != null) {
      this.nodesStack.push(curr);
      curr = (E) curr.getLeft();
    }
  }
}
