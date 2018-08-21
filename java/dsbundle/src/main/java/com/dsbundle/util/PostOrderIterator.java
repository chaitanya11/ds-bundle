package com.dsbundle.util;

import com.dsbundle.models.BinaryTreeNode;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 1. Traverse the left subtree, i.e., call Postorder(left-subtree)
 * 2. Traverse the right subtree, i.e., call Postorder(right-subtree)
 * 3. Visit the root.
 * @param <E>
 */
public class PostOrderIterator<E extends BinaryTreeNode> implements Iterator<E> {
  private Stack<E> nodesStack;

  public PostOrderIterator(final E root) {
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
    if (!this.nodesStack.empty()) {
      E top = this.nodesStack.peek();
      if (node == top.getLeft()) {
        findNextLeaf((E) top.getRight());
      }
    }
    return node;
  }

  private void findNextLeaf(E curr) {
    while (curr != null) {
      this.nodesStack.push(curr);
      if (curr.getLeft() != null) {
        curr = (E) curr.getLeft();
      } else {
        curr = (E) curr.getRight();
      }
    }
  }
}
