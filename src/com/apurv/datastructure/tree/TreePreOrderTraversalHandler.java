package com.apurv.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

public abstract class TreePreOrderTraversalHandler {

	protected abstract void processNode(TreeNode<Long> node, int level, Map<String, Object> associatedData);

	/**
	 * 
	 * @param root
	 * @param associatedData
	 */
	private void preOrderTreeTraversal(TreeNode<Long> root, int level, Map<String, Object> associatedData) {
		if (root == null)
			return;
		if (associatedData == null)
			associatedData = new HashMap<String, Object>();
		// exit condition : if node is leaf node , process it and go
		if (root.isLeafNode()) {
			processNode(root, level, associatedData);
		} else {
			// if node is NOT leaf node , process left , root and right (pre
			// order)
			preOrderTreeTraversal(root.getLeftNode(), level + 1, associatedData);
			processNode(root, level, associatedData);
			preOrderTreeTraversal(root.getRightNode(), level + 1, associatedData);
		}
	}

	/**
	 * Traverse a tree in pre-order fashion [left-root-right]
	 * 
	 * @param root
	 * @param associatedData
	 */
	public void preOrderTreeTraversal(TreeNode<Long> root, Map<String, Object> associatedData) {
		preOrderTreeTraversal(root, 0, associatedData);
	}

}
