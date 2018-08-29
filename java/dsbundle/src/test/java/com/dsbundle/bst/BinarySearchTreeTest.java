package com.dsbundle.bst;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {

	static BinarySearchTree<Integer> tree;

	@BeforeClass
	public static void beforeClass() {
		tree = new BinarySearchTree<Integer>();
	}

	@Test
	public void testInsertion() {
		tree.insert(20);
	}

	@Test
	public void testDeletion() {
		tree.deleteKey(20);
	}

	@Test
	public void testTraversals() {
		BinarySearchTree tree = new BinarySearchTree();

		/*
		 * Let us create following bst 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the bst
		List<Integer> inOrdernodes = tree.inorder();
		List<Integer> preOrdernodes = tree.preorder(tree.getRoot());
		List<Integer> postOrdernodes = tree.postorder(tree.getRoot());
		List<Integer> levelOrdernodes = tree.levelorder(tree.getRoot());
		Assert.assertEquals(inOrdernodes, Arrays.asList(new Integer[] {20, 30, 40, 50, 60, 70, 80}));
		Assert.assertEquals(preOrdernodes, Arrays.asList(new Integer[] {50, 30, 20, 40, 70, 60, 80}));
		Assert.assertEquals(postOrdernodes, Arrays.asList(new Integer[] {20, 40, 30, 60, 80, 70, 50}));
		Assert.assertEquals(levelOrdernodes, Arrays.asList(new Integer[] {50, 30, 70, 20, 60, 80, 40}));
	}

	@Test
	public void insertAllTest() {
		BinarySearchTree tree = new BinarySearchTree();
		List<Integer> values = Arrays.asList(new Integer[] {20, 30, 40, 50, 60, 70, 80});
		tree.insertAll(values);
		List<Integer> inOrderValues = tree.inorder();
		Assert.assertEquals(inOrderValues, Arrays.asList(new Integer[] {20, 30, 40, 50, 60, 70, 80}));
	}

}
