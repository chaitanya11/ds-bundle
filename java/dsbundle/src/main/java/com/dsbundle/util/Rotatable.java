package com.dsbundle.util;

import com.dsbundle.models.BaseNode;

public interface Rotatable<T extends BaseNode<?>> {
  T rightRotate();
  T leftRotate();
}
