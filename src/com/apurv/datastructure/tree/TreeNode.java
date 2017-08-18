package com.apurv.datastructure.tree;

public class TreeNode<T extends Comparable<T>> {

	private T data;
	private TreeNode<T> leftNode = null;
	private TreeNode<T> rightNode = null;

	@SuppressWarnings("unchecked")
	private final static TreeNode markerInstance = new TreeNode();

	public TreeNode() {
	}

	public static TreeNode getMarkerInstance() {
		return markerInstance;
	}

	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public void printHorizontal(String prefix, boolean isRoot) {
		System.out.println(prefix + (isRoot ? "|__ " : "|-- ") + this.data);

		if (leftNode != null)
			leftNode.printHorizontal(prefix + (isRoot ? "    " : "|   "), false);

		if (rightNode != null)
			rightNode.printHorizontal(prefix + (isRoot ? "    " : "|   "), false);

	}

	public boolean isLeafNode() {
		return (rightNode == null) && (leftNode == null);
	}

	public boolean leftNodeExist() {
		return (leftNode != null);
	}

	public boolean rightNodeExist() {
		return (rightNode != null);
	}

	@Override
	public String toString() {
		return paddedDataValue();
	}

	private String paddedDataValue() {
		return String.format("%1$4s", data);
	}

	public int getMaxHeight() {

		int leftHeight = 0;
		int rightHeight = 0;

		if (leftNode != null) {
			leftHeight = leftNode.getMaxHeight();
		}
		if (rightNode != null) {
			rightHeight = rightNode.getMaxHeight();
		}

		return 1 + Math.max(rightHeight, leftHeight);

	}

}
