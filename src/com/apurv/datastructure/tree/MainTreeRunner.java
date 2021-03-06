package com.apurv.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.apurv.util.RandomGenerationUtils;

public class MainTreeRunner {

	public  static  void main(String[] args) {
		System.out.println("-- Start --");
//		createAndPrintTree();
//		 searchInBinarySearchTree();
//		 insertInBinarySearchTree();
//		 findMaxInBinaryTree();
//		 levelOrderTreeTraversal();
//		 findMaxandMinDepth();
//		tryPreOrderTreeTraversal();
//		 rootToLeafPaths();
//		 mirrorTree(); 
//		 pathFromRootToNode();
//		levelOrderTreeTraversal();
//		findLCAofTwoBSTNodes();
//		createBSTFromSortedList();
//		findFloorAndCeilinginBST();
		treerotationafterinsertion();
		System.out.println("-- End --");

	}



	private static  void createAndPrintTree() {

		// TreeNode node = createTreeForFixedHeight(3);
		TreeNode<Integer> node = TreeCreationUtil.createBinarySearchTreeForFixedHeight(3, 100, 999);
		System.out.println("tree created");
		node.printHorizontal("", true);

	}

	private static  void searchInBinarySearchTree() {
		// create a BST and check if a particular number exists

		TreeNode root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(4, 199, 999);

		root.printHorizontal("", true);
		long valueKnownToBepresent = (long) root.getLeftNode().getRightNode().getData();
		System.out.println("Value to search : " + valueKnownToBepresent);
		long valueKnownToBeAbsent = 2000;

		boolean valuePresent = TreeUtility.searchValueInBST(root, valueKnownToBepresent);
		System.out.println("Value present : " + valuePresent);

		System.out.println("Value to search : " + valueKnownToBeAbsent);

		valuePresent = TreeUtility.searchValueInBST(root, valueKnownToBeAbsent);
		System.out.println("Value present : " + valuePresent);

	}

	private static  void insertInBinarySearchTree() {
		TreeNode root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(3, 199, 999);
		root.printHorizontal("", true);
		long valueToInsert;
		for (int i = 0; i < 5; i++) {
			valueToInsert = RandomGenerationUtils.randomLong(3);
			System.out.println("Value to insert : " + valueToInsert);
			TreeUtility.insertValueInBST(root, valueToInsert);
			root.printHorizontal("", true);
			System.out.println("Max Height : " + root.getMaxHeight());
		}
	}

	
	private static  void findMaxInBinaryTree() {
		TreeNode<Long> root = TreeCreationUtil.createTreeForFixedHeight(5);
		root.printHorizontal("", true);
		Long maxValue = TreeUtility.findMaxValueInBinaryTree(root);
		System.out.println("Max Value : "+ maxValue);
		
	}
	
	private static  void levelOrderTreeTraversal(){
		TreeNode<Long> root = TreeCreationUtil.createTreeForFixedHeight(3);
		root.printHorizontal("", true);
		Map<String, Object> associatedData=new HashMap<String, Object>();
		
		(new TreeLevelOrderTraversalHandler() {
			@Override
			protected void processNode(TreeNode<Long> node, int level, Map<String, Object> associatedData) {
				System.out.println("currentLevel : " + level + " : element : " + node.getData());
			}
		}).levelOrderTreeTraversal(root,associatedData);
	}
	
	private static  void findMaxandMinDepth(){
		
		TreeNode<Long> root = TreeCreationUtil.createUnbalancedTreeWithRandomElements(70);
		root.printHorizontal("", true);
		Map<String, Object> associatedData=new HashMap<String, Object>();
		
		final String MAXIMUM_DEPTH = "MAXIMUM_DEPTH";
		final String MAXIMUM_DEPTH_DATA = "MAXIMUM_DEPTH_DATA"; 
		
		associatedData.put(MAXIMUM_DEPTH, 0);
		associatedData.put(MAXIMUM_DEPTH_DATA, root);
		
		(new TreeLevelOrderTraversalHandler() {
			@Override
			protected void processNode(TreeNode<Long> node, int level, Map<String, Object> associatedData) {
				System.out.println("currentLevel : " + level + " : element : " + node.getData());
				if(node.isLeafNode() &&
						(int)associatedData.get(MAXIMUM_DEPTH) < level){
					associatedData.put(MAXIMUM_DEPTH, level);
					associatedData.put(MAXIMUM_DEPTH_DATA, node.getData());
				}
			}
		}).levelOrderTreeTraversal(root,associatedData);
		
		System.out.println("Max depth of leaf : "+associatedData.get(MAXIMUM_DEPTH)  + " With data : "+associatedData.get(MAXIMUM_DEPTH_DATA));
	} 
	
	private static  void tryPreOrderTreeTraversal() {
		TreeNode<Long> root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(10, 10, 999);
		root.printHorizontal("", true);
		Map<String, Object> associatedData = new HashMap<String, Object>();
		List<Long> sortedNumberList = new LinkedList<>();
		associatedData.put("sortedNumberList", sortedNumberList);
		
		(new TreePreOrderTraversalHandler() {
			
			@Override
			protected void processNode(TreeNode<Long> node, int level, Map<String, Object> associatedData) {
				((List<Long>)associatedData.get("sortedNumberList")).add(node.getData());
				
			}
		}).preOrderTreeTraversal(root, associatedData);
		
		for( Long l :  (List<Long>)associatedData.get("sortedNumberList")){
			System.out.print(l+" --> ");
		}
		
	}
	
	
	/**
	 * print all root to leaf paths 
	 */
	private static  void rootToLeafPaths(){
		TreeNode<Long> root = TreeCreationUtil.createUnbalancedTreeWithRandomElements(100);
		root.printHorizontal("", true);
		List<String> paths =  TreeUtility.printRootToLeafPaths(root);
		for(String path : paths)System.out.println(path);
	}
	
	private static  void mirrorTree(){
		TreeNode<Long> root = TreeCreationUtil.createUnbalancedTreeWithRandomElements(5);
		root.printHorizontal("", true);
		root = TreeUtility.createMirrorTree(root);
		System.out.println("Printing mirror tree");
		root.printHorizontal("", true);
	}

	private static  void pathFromRootToNode() {

		TreeNode<Long> root = TreeCreationUtil.createTreeForFixedHeight(2);
		root.printHorizontal("", true);

		TreeNode<Long> node = root.getRightNode().getLeftNode();
		System.out.println(node);

		List<TreeNode<Long>> path = TreeUtility.findPathFromRootToNode(root, node);

		for (TreeNode<Long> temp : path) {
			System.out.print(temp + "---> ");
		}

	}
	
	private static  void findLCAofTwoBSTNodes() {
		TreeNode<Long> root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(5, 10, 999);
		root.printHorizontal("", true);
		
		TreeNode<Long> smallerNode = root.getLeftNode().getLeftNode().getRightNode();
		TreeNode<Long> biggerNode = root.getLeftNode().getRightNode().getLeftNode();
		
		System.out.println("smallerNode : "+ smallerNode);
		System.out.println("biggerNode : "+ biggerNode);
		
		TreeNode<Long> lca = TreeUtility.findLCAforNodesInBST(root , smallerNode,biggerNode);
		
		System.out.println("lca : "+lca);
		
	}
	
	private static  void createBSTFromSortedList() {
		int numberOfNodes=31;
		List<Long> sortedNumberList = new ArrayList<Long>(numberOfNodes);
		for (int i = 0; i < numberOfNodes; i++) {
			sortedNumberList.add(i+ 10l);
		}
		TreeNode<Long> root = TreeUtility.createBSTfromSortedList(sortedNumberList);
		root.printHorizontal("", true);
	}
	
	private static  void findFloorAndCeilinginBST() {
		TreeNode<Long> root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(5, 10, 999);
		root.printHorizontal("", true);
		// find a random node 
		double markerValue =  (root.getRightNode().getLeftNode().getData()+root.getRightNode().getRightNode().getData())/2;
		// something outside the range - upper side 
//		double markerValue =  9999;
		// something outside the range - lower side
//		double markerValue =  5;
		System.out.println("markerValue : "+markerValue);
		TreeNode<Long> floor=new TreeNode<>();
		TreeNode<Long> ceiling=new TreeNode<>();
		TreeUtility.identifyFloorAndCeiling(root ,markerValue);
	}
	
	private static void treerotationafterinsertion() {
		
		TreeNode root = TreeCreationUtil.createBinarySearchTreeForFixedHeight(3, 199, 999);
		root.printHorizontal("", true);
		long valueToInsert= RandomGenerationUtils.randomLong(3);;
		System.out.println("TreeUtility.isAVLTree(root) : "+TreeUtility.isAVLTree(root));
		for (int i = 0; i < 5; i++) {
			valueToInsert++;
			System.out.println("Value to insert : " + valueToInsert);
			TreeUtility.insertValueInBST(root, valueToInsert);
			root.printHorizontal("", true);
			System.out.println("TreeUtility.isAVLTree(root) : "+TreeUtility.isAVLTree(root));
			System.out.println("Max Height : " + root.getMaxHeight());
		}
	}
}
