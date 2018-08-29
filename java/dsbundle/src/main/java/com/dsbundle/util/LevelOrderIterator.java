package com.dsbundle.util;

import com.dsbundle.models.BaseNode;
import com.dsbundle.models.BinaryTreeNode;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Main article: Breadth-first search
 * Trees can also be traversed in level-order,
 * where we visit every node on a level before going to a lower level.
 * This search is referred to as breadth-first search (BFS),
 * as the search tree is broadened as much as possible on each depth before going to the next depth.
 * @param <E>
 */
public class LevelOrderIterator<E extends BaseNode> implements Iterator {
  private Stack<E> nodesStack;

  public LevelOrderIterator(final E root) {
    this.nodesStack = new Stack<>();
    this.nodesStack.push(root);
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
    E sibling = null;
    if (!this.nodesStack.empty()) {
        sibling = this.nodesStack.pop();
    }
    if (node.getRight() != null) this.nodesStack.push((E) node.getRight());
    if (node.getLeft() != null) this.nodesStack.push((E) node.getLeft());
    if (sibling != null) this.nodesStack.push(sibling);
    return node;
  }
}
