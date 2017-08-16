package com.apurv.datastructure.tree;

import com.apurv.util.RandomGenerationUtils;

public class TreeCreationUtil {

	public static TreeNode<Long> createUnbalancedTreeWithRandomElements(long maxHeight) {

		TreeNode<Long> node = new TreeNode<Long>(new Long(RandomGenerationUtils.randomLongBetweenLimits(10l, 9999l)));

		if (maxHeight <= 1)
			return node;

		long leftHeight = RandomGenerationUtils.randomLongBetweenLimits(1, maxHeight - 1);
		long rightHeight = RandomGenerationUtils.randomLongBetweenLimits(1, maxHeight - 1);

		TreeNode<Long> leftNode = createUnbalancedTreeWithRandomElements(leftHeight);
		TreeNode<Long> rightNode = createUnbalancedTreeWithRandomElements(rightHeight);

		node.setLeftNode(leftNode);
		node.setRightNode(rightNode);

		return node;

	}

	public static TreeNode<Long> createTreeForFixedHeight(int height) {
		//
		TreeNode<Long> node = new TreeNode<Long>(new Long(RandomGenerationUtils.randomLongBetweenLimits(10l, 9999l)));
		if (height > 0) {
			TreeNode<Long> leftNode = createTreeForFixedHeight(height - 1);
			TreeNode<Long> rightNode = createTreeForFixedHeight(height - 1);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
		}
		return node;
	}

	public static TreeNode createBinarySearchTreeForFixedHeight(int height, long lowerRange, long upperRange) {
		// get a number between the range
		long dataValue = RandomGenerationUtils.randomLongBetweenLimits(lowerRange, upperRange);
		// create a node item with this value
		TreeNode node = new TreeNode(dataValue);
		if (height > 0) {
			// create a tree with values less then datavalue, use it for left
			// sub tree
			TreeNode leftNode = createBinarySearchTreeForFixedHeight(height - 1, lowerRange, dataValue - 1);
			// create a tree with values more then datavalue, use it for right
			// sub tree
			TreeNode rightNode = createBinarySearchTreeForFixedHeight(height - 1, dataValue + 1, upperRange);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
		}
		return node;
	}

}
