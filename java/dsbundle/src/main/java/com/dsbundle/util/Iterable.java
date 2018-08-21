package com.dsbundle.util;

public interface Iterable {
  Iterator getInOrderIterator();
  Iterator getPreOrderIterator();
  Iterator getPostOrderIterator();
  Iterator getLevelOrderIterator();
}
