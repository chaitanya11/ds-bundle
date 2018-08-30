package com.dsbundle.models;

import com.dsbundle.util.Rotatable;
import com.dsbundle.util.iterators.InOrderIterator;
import com.dsbundle.util.iterators.LevelOrderIterator;
import com.dsbundle.util.iterators.PostOrderIterator;
import com.dsbundle.util.iterators.PreOrderIterator;
import static com.dsbundle.util.GeneralUtils.max;

import java.util.Iterator;

public class AVLNode<T extends Comparable<T>> extends BaseNode<T> implements Rotatable {
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

    @Override
    public AVLNode<T> rightRotate() {
        AVLNode<T> y = this;
        AVLNode<T> x = y.getLeft();
        AVLNode<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new root
        return x;
    }

    @Override
    public AVLNode<T> leftRotate() {
        AVLNode<T> x = this;
        AVLNode<T> y = x.getRight();
        AVLNode<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        // Return new root
        return y;
    }

    // A utility function to get the height of the tree
    private int height(AVLNode<T> N) {
        if (N == null)
            return 0;

        return N.getHeight();
    }
}