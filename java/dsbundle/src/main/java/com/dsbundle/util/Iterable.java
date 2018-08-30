package com.dsbundle.util;

import java.util.Iterator;

public interface Iterable {
  Iterator getInOrderIterator();
  Iterator getPreOrderIterator();
  Iterator getPostOrderIterator();
  Iterator getLevelOrderIterator();
}
