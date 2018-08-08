package com.dsbundle;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {

	static BinarySearchTree tree;

	@BeforeClass
	public static void beforeClass() {
		tree = new BinarySearchTree();
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
	public void test() {
		BinarySearchTree tree = new BinarySearchTree();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder();
	}

}
