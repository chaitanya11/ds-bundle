package com.dsbundle.util;

import com.dsbundle.models.BinaryTreeNode;

import java.util.Stack;

/**
 * Main article: Breadth-first search
 * Trees can also be traversed in level-order,
 * where we visit every node on a level before going to a lower level.
 * This search is referred to as breadth-first search (BFS),
 * as the search tree is broadened as much as possible on each depth before going to the next depth.
 * @param <E>
 */
public class LevelOrderIterator<E extends BinaryTreeNode> implements Iterator {
  private Stack<E> nodesStack;
  private E curr;

  public LevelOrderIterator(final E root) {
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
