package com.dsbundle.binarytree;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dsbundle.models.BinaryTreeNode;

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
	public void preOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insertValue(1);
		tree.insertValue(2);
		tree.insertValue(3);
		tree.insertValue(4);
		tree.insertValue(5);
		tree.insertValue(6);
		tree.insertValue(7);
		tree.insertValue(8);
		List<Integer> preOrder = tree.preOrderTraverse(tree.getRoot());
		Assert.assertEquals(preOrder, Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8}));
	}

	@Test
	public void postOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setRoot(new BinaryTreeNode<>(1));
		tree.getRoot().setLeft(new BinaryTreeNode<>(2));
		tree.getRoot().setRight(new BinaryTreeNode<>(3));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
		tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
		List<Integer> postOrder = tree.postOrderTraverse(tree.getRoot());
		Assert.assertEquals(postOrder, Arrays.asList(new Integer[] {4,5,2,3,1}));
	}

	@Test
	public void inOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setRoot(new BinaryTreeNode<>(1));
		tree.getRoot().setLeft(new BinaryTreeNode<>(2));
		tree.getRoot().setRight(new BinaryTreeNode<>(3));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
		tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
		List<Integer> inOrder = tree.inOrderTraverse(tree.getRoot());
		Assert.assertEquals(inOrder, Arrays.asList(new Integer[] {4,2,5,1,3}));
	}

	@Test
	public void levelOrderTest() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.setRoot(new BinaryTreeNode<>(1));
		tree.getRoot().setLeft(new BinaryTreeNode<>(2));
		tree.getRoot().setRight(new BinaryTreeNode<>(3));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
		tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));
		List<Integer> levelOrder = tree.levelOrderTraverse(tree.getRoot());
		Assert.assertEquals(levelOrder, Arrays.asList(new Integer[] {1,2,3,4,5}));
	}

	@Test
	public void searchTest() {
		BinaryTree<Fruit> tree = new BinaryTree<Fruit>();
		tree.setRoot(new BinaryTreeNode<Fruit>(new Fruit("Apple", 12F)));
		tree.getRoot().setLeft(new BinaryTreeNode<>(new Fruit("Mango", 10.5F)));
		tree.getRoot().setRight(new BinaryTreeNode<>(new Fruit("Banana", 20F)));
		tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(new Fruit("Orange", 7F)));
		BinaryTreeNode<Fruit> test = tree.searchValue(new BinaryTreeNode<Fruit>(new Fruit("Orange", 7F)));
		Assert.assertEquals("Orange", test.getValue().getName());
		test = tree.searchValue(new BinaryTreeNode<Fruit>(new Fruit("Mango", 10.5F)));
		Assert.assertEquals("Mango", test.getValue().getName());
		test = tree.searchValue(new BinaryTreeNode<Fruit>(new Fruit("Apple", 9F)));
		Assert.assertNull(test);
	}
	
	@Test
	public void insertAlltest() {
		BinaryTree<Fruit> tree = new BinaryTree<>();
		List<Fruit> fruits = Arrays.asList(new Fruit[] {
				new Fruit("Apple", 12F),
				new Fruit("Banana", 12F),
				new Fruit("mango", 10F),
				new Fruit("Orange", 5F),
				new Fruit("Grapes", 20F)
		});
		tree.insertAll(fruits);
		List<Fruit> insertedFruits = tree.inOrderTraverse(tree.getRoot());
		Assert.assertEquals(insertedFruits.size(), fruits.size());
	}
}
