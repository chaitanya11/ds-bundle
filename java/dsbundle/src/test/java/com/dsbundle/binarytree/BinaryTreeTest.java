package com.dsbundle.binarytree;

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
		tree.insertValue(3);
		tree.insertValue(2);
		tree.insertValue(4);
		tree.insertValue(7);
		tree.insertValue(6);
		tree.insertValue(8);
		tree.traverseTree();
	}

}
