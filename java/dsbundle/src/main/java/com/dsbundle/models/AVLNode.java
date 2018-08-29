package com.dsbundle.models;

import com.dsbundle.util.InOrderIterator;
import com.dsbundle.util.Iterator;
import com.dsbundle.util.LevelOrderIterator;
import com.dsbundle.util.PostOrderIterator;
import com.dsbundle.util.PreOrderIterator;

public class AVLNode<T extends Comparable<T>> extends BaseNode<T> {
    private int height;
    private AVLNode<T> left, right;

    public AVLNode(T value) {
        super(value);
        height = 1;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height height
     */
    public void setHeight(final int height) {
        this.height = height;
    }

    /**
     * @return the left
     */
    @Override
    public AVLNode<T> getLeft() {
        return left;
    }

    /**
     * @param left left
     */
    public void setLeft(final AVLNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    @Override
    public AVLNode<T> getRight() {
        return right;
    }

    /**
     * @param right right
     */
    public void setRight(final AVLNode<T> right) {
        this.right = right;
    }

    @Override
    public Iterator<AVLNode<T>> getInOrderIterator() {
        return new InOrderIterator<AVLNode<T>>(this);
    }

    @Override
    public Iterator<AVLNode<T>> getPreOrderIterator() {
        return new PreOrderIterator<AVLNode<T>>(this);
    }
    @Override
    public Iterator<AVLNode<T>> getPostOrderIterator() {
        return new PostOrderIterator<AVLNode<T>>(this);
    }

    @Override
    public Iterator<AVLNode<T>> getLevelOrderIterator() {
        return new LevelOrderIterator<AVLNode<T>>(this);
    }
}