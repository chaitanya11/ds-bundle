package com.dsbundle.avl;

import org.junit.BeforeClass;
import org.junit.Test;

public class AVLTreeTest {
    private static AVLTree avlTree;

    @BeforeClass
    public static void createTree() {
        avlTree = new AVLTree();
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        avlTree.root = avlTree.insert(avlTree.root, 9);
        avlTree.root = avlTree.insert(avlTree.root, 5);
        avlTree.root = avlTree.insert(avlTree.root, 10);
        avlTree.root = avlTree.insert(avlTree.root, 0);
        avlTree.root = avlTree.insert(avlTree.root, 6);
        avlTree.root = avlTree.insert(avlTree.root, 11);
        avlTree.root = avlTree.insert(avlTree.root, -1);
        avlTree.root = avlTree.insert(avlTree.root, 1);
        avlTree.root = avlTree.insert(avlTree.root, 2);
    }


    @Test
    public void insert() {
        avlTree.insert(avlTree.root, 20);
        avlTree.preOrder(avlTree.root);
    }

    @Test
    public void delete() {
        avlTree.deleteNode(avlTree.root, 20);
        avlTree.preOrder(avlTree.root);
    }

    
}
