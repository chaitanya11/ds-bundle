package com.dsbundle.util;

public interface Iterable {
  public Iterator getInOrderIterator();
  public Iterator getPreOrderIterator();
  public Iterator getPostOrderIterator();
}
