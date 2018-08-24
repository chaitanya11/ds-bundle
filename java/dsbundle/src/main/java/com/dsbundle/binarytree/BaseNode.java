package com.dsbundle.binarytree;

import com.dsbundle.annotations.KeyProperty;

import java.lang.reflect.Field;

/**
 * Base class for the tree node. Overrides the equals method.
 *
 * @param <T>
 */
public abstract class BaseNode<T> {

	private T value;

	public BaseNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean equals(Object value) {
		if (value == null)
			return false;
		return getIdentifierValue(this.value).equals(getIdentifierValue((T) value));
	}

	/**
	 * Returns the value of the field which is annotated with @Identifier annotation
	 * Currently searches for only one field. Can be extended to support for
	 * multiple fields.
	 * 
	 * @param value
	 * @return
	 */
	public Object getIdentifierValue(T value) {
		Field[] fields = value.getClass().getDeclaredFields();
		Object result = new Object();
		for (Field field : fields) {
			if (field.isAnnotationPresent(KeyProperty.class)) {
				try {
					field.setAccessible(true);
					result = field.get(value);
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "BaseNode [value=" + value + "]";
	}
}
