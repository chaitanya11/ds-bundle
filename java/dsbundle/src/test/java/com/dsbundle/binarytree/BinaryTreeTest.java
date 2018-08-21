package com.dsbundle.binarytree;

import com.dsbundle.models.BinaryTreeNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {

	static BinaryTree<Integer> tree;

	@BeforeClass
	public static void beforeClass() {
		tree = new BinaryTree<Integer>();
	}

	@Test
	public void testInsertion() {
		tree.insertValue(1);
	}

	@Test
	public void test() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insertValue(1);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.insertValue(4);
		tree.insertValue(5);
		tree.insertValue(6);
		tree.insertValue(7);
		tree.insertValue(8);
		String result = tree.preOrderTraverseTree();
		Assert.assertEquals(result, "12345678");
	}

	@Test
	public void postOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setRoot(new BinaryTreeNode<>(1));
		tree.getRoot().setLeft(new BinaryTreeNode<>(2));
		tree.getRoot().setRight(new BinaryTreeNode<>(3));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
		tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
		String result = tree.postOrderTraverse(tree.getRoot());
		Assert.assertEquals(result, "45231");
	}

	@Test
	public void inOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setRoot(new BinaryTreeNode<>(1));
		tree.getRoot().setLeft(new BinaryTreeNode<>(2));
		tree.getRoot().setRight(new BinaryTreeNode<>(3));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
		tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
		String result = tree.inOrderTraverse(tree.getRoot());
		Assert.assertEquals(result, "42513");
	}

    @Test
    public void levelOrderTest() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.setRoot(new BinaryTreeNode<>(1));
        tree.getRoot().setLeft(new BinaryTreeNode<>(2));
        tree.getRoot().setRight(new BinaryTreeNode<>(3));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
        String result = tree.levelOrderTraverse(tree.getRoot());
        Assert.assertEquals(result, "12345");
    }
}
