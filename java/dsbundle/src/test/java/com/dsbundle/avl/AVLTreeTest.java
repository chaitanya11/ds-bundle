package com.dsbundle.avl;

import com.dsbundle.models.AVLNode;
import org.junit.BeforeClass;
import org.junit.Test;

public class AVLTreeTest {
    private static AVLTree<Integer> avlTree;

    @BeforeClass
    public static void createTree() {
        avlTree = new AVLTree<Integer>();
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        avlTree.insert(9);
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(0);
        avlTree.insert(6);
        avlTree.insert(11);
        avlTree.insert(-1);
        avlTree.insert(1);
        avlTree.insert(2);
    }


    @Test
    public void insert() {
//        avlTree.insert(20);
        avlTree.preOrderTraversal(avlTree.getRoot());
    }

    @Test
    public void delete() {
        avlTree.deleteNode(avlTree.getRoot(), new AVLNode<Integer>(20));
//        avlTree.preOrderTraversal(avlTree.root);
    }

    
}
