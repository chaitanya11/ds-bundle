package com.dsbundle.util;

import com.dsbundle.models.BinaryTreeNode;

import java.util.Stack;

/**
 * 1. Visit the root.
 * 2. Traverse the left subtree, i.e., call Preorder(left-subtree)
 * 3. Traverse the right subtree, i.e., call Preorder(right-subtree)
 * @param <E>
 */
public class PreOrderIterator<E extends BinaryTreeNode> implements Iterator<E> {
  private Stack<E> nodesStack;
  private E curr;

  public PreOrderIterator(final E root) {
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
    if(node.getRight() != null || node.getLeft() != null) {
      if (this.curr.getRight() != null) {
        this.nodesStack.push((E) this.curr.getRight());
      }
      if (this.curr.getLeft() != null) {
        this.curr = (E) this.curr.getLeft();
      } else {
        this.curr = this.nodesStack.pop();
      }
    } else if (!this.nodesStack.empty()) {
        this.curr = this.nodesStack.pop();
    } else {
      this.curr = null;
    }
    return node;
  }
}
