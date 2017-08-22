package com.apurv.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TreeUtility {

	public static boolean searchValueInBST(TreeNode<Long> root, long valueToSearch) {

		if (root == null)
			return false;
		long nodeData = (long) root.getData();
		System.out.println("Node data : " + nodeData);
		boolean doesNodeMatchWithSearchParam = (nodeData == valueToSearch);
		if (doesNodeMatchWithSearchParam)
			return true;
		boolean presentinChild = false;

		if (valueToSearch > nodeData)
			presentinChild = searchValueInBST(root.getRightNode(), valueToSearch);
		else
			presentinChild = searchValueInBST(root.getLeftNode(), valueToSearch);

		return presentinChild;
	}

	public static void insertValueInBST(TreeNode<Long> root, long valueToInsert) {
		// no duplicates allowed
		if (root == null)
			return;

		if ((long) root.getData() > valueToInsert) {
			TreeNode<Long> leftNode = root.getLeftNode();
			if (leftNode == null) {
				TreeNode<Long> nodeToInsert = new TreeNode<Long>(new Long(valueToInsert));
				root.setLeftNode(nodeToInsert);
				return;
			}
			insertValueInBST(leftNode, valueToInsert);
		} else if ((long) root.getData() < valueToInsert) {
			TreeNode rightNode = root.getRightNode();
			if (rightNode == null) {
				TreeNode nodeToInsert = new TreeNode<Long>(new Long(valueToInsert));
				root.setRightNode(nodeToInsert);
				return;
			}
			insertValueInBST(rightNode, valueToInsert);
		}
	}
	
	/**
	 * given a binary tree (not BST) , find the max value 
	 * @param root
	 * @return  - max value
	 */
	public static Long findMaxValueInBinaryTree(TreeNode<Long> root) {
		if (root == null)
			return null;

		// start a variable , initially containing root data
		Long maxElement = root.getData();

		// replace max with (maximum of left , maximum of right ) - whichever is
		// greater

		Long maxElementLeft = findMaxValueInBinaryTree(root.getLeftNode());
		if (maxElementLeft != null)
			maxElement = Math.max(maxElement, maxElementLeft);

		Long maxElementRight = findMaxValueInBinaryTree(root.getRightNode());
		if (maxElementRight != null)
			maxElement = Math.max(maxElement, maxElementRight);

		return maxElement;

	}
	
	
	
	
	/**
	 * 
	 * Tree traversal by level , prints elements at individual levels 
	 * @param root
	 */
	public static void levelOrderTreeTraversal(TreeNode<Long> root) {

		LinkedList<TreeNode<Long>> elementQ = new LinkedList<TreeNode<Long>>();
		TreeNode markerInstance = TreeNode.getMarkerInstance();
		TreeNode<Long> temp = null;
		int currentLevel = 0;

		// push the root in the Q
		elementQ.push(root);
		elementQ.push(markerInstance);

		while (true) {
			// remove from end
			temp = elementQ.removeLast();

			// if this is a marker instance , we are done with current level
			if (temp == markerInstance) {
				currentLevel++;
				// if there are no more elements in Q , we are done with traversal and should exit 
				if (elementQ.isEmpty()){
					break;
				}else{
					// if more elelemtns remain in Q  , we need to proceed to next level 
					// marker instance is used as boundary between elelemnts of different 
					// levels 
					elementQ.push(markerInstance);
					continue;
				}
			}
			System.out.println("currentLevel : " + currentLevel + " : element : " + temp.getData());
			if (temp.getLeftNode() != null)
				elementQ.push(temp.getLeftNode());
			if (temp.getRightNode() != null)
				elementQ.push(temp.getRightNode());
		}

	}

	/**
	 * get all possible  paths from root to leaves ,recursive iteration of the tree ,
	 * get all paths from left and right sub trees , 
	 * add root to start of each path 
	 * 
	 * Exit when u reach leaf node , just return the node data 
	 * 
	 * @param root
	 * @return
	 */
	public static List<String> printRootToLeafPaths(TreeNode<Long> root) {
		// fail safe 
		if(root==null) return null;
		// exit condition 
		// path of leaf to leaf itself 
		if(root.isLeafNode()){
			return Collections.singletonList((new StringBuilder())
					  .append("-->")
					  .append(root.getData())
					  .toString());
		}

		// list of all paths from right or left nodes down to the leaves 
		List<String>  pathsFromChildren = new LinkedList<String>();
		
		// add paths for the left 
		if(root.leftNodeExist()){
			pathsFromChildren.addAll(printRootToLeafPaths(root.getLeftNode()))  ;
		}
		
		// add paths for the right  
		if(root.rightNodeExist()){
			pathsFromChildren.addAll(printRootToLeafPaths(root.getRightNode()))  ;
		}
		// combine
		List<String>  pathsFromThisNode = new ArrayList<>(pathsFromChildren.size());

		// add root name to start 
		for(String childPath : pathsFromChildren){
			
			pathsFromThisNode.add((new StringBuilder())
					  .append("-->")
					  .append(root.getData())
					  .append(childPath).toString());
		}
		return pathsFromThisNode;
		
	}
	
	
	/**
	 * create mirror image of a tree 
	 * 
	 * for any node , mirror the left subtree , mirror the right subtree
	 * and then swap left and right 
	 * 
	 * exit condition : for leaf nodes , return the same 
	 * 
	 * @param root
	 * @return
	 */
	public static TreeNode<Long> createMirrorTree(TreeNode<Long> root) {
		if(root == null) return null;
		if(root.isLeafNode())return root ;
		
		TreeNode<Long> left =null;
		TreeNode<Long> right  =null;
		
		if(root.leftNodeExist()){
			left = createMirrorTree(root.getLeftNode());
		}
		
		if(root.rightNodeExist()){
			right = createMirrorTree(root.getRightNode());
		}
		
		// swap left and right 
		root.setLeftNode(right);
		root.setRightNode(left);
		return root;
	}
	
	
	public static List<TreeNode<Long>> findPathFromRootToNode(TreeNode<Long> root, TreeNode<Long> node) {

		List<TreeNode<Long>> path = null;

		if (root == null || node == null)
			return null;

		if (root == node) {
			path = new LinkedList<>();
			path.add(root);
		} else {
			if (root.leftNodeExist()) {
				path = findPathFromRootToNode(root.getLeftNode(), node);
			}
			if (path == null && root.rightNodeExist()) {
				path = findPathFromRootToNode(root.getRightNode(), node);
			}
			
			if(path!=null)path.add(root);
			
		}
		
		return path;

	}

	/**
	 * for a BST while traversing from top to bottom , first 
	 * node to fall between the smaller and bigger 
	 * range is the LCA 
	 * 
	 * @param root
	 * @param smallerNode
	 * @param biggerNode
	 * @return
	 */
	public static TreeNode<Long> findLCAforNodesInBST(TreeNode<Long> root, 
			TreeNode<Long> smallerNode,
			TreeNode<Long> biggerNode) {

		if(root==null)return null;
		TreeNode<Long>  lca = null;
		
		if (smallerNode.getData() <= root.getData() 
				&& 
				  biggerNode.getData() >= root.getData()) {
			// the root is the lca
			lca = root;
		}

		if(smallerNode.getData() >= root.getData()){
			lca = findLCAforNodesInBST( root.getRightNode(), 
					smallerNode,
					biggerNode);
		}
		
		if(biggerNode.getData()<= root.getData()){
			lca = findLCAforNodesInBST( root.getLeftNode(), 
					smallerNode,
					biggerNode);
		}
		return lca;
	}

	/**
	 * find mid point , make it root , create trees 
	 * from left and right sublist and join as left 
	 * and right sub trees
	 * 
	 * 
	 * @param sortedNumberList
	 * @return
	 */
	public static TreeNode<Long> createBSTfromSortedList(List<Long> sortedNumberList) {
		if(sortedNumberList == null || sortedNumberList.isEmpty()) return null;
		int size = sortedNumberList.size();
		if(size==1){
			return new TreeNode<>(sortedNumberList.get(0));
		}
		if(size==3){
			// we have reached smallest unit , no point using recursion anymore 
			TreeNode<Long> rootNode = new TreeNode<>(sortedNumberList.get(1));
			rootNode.setLeftNode(new TreeNode<>(sortedNumberList.get(0)));
			rootNode.setRightNode(new TreeNode<>(sortedNumberList.get(2)));
			return rootNode;
		}
		
		// find midpoint of sublist 
		int midpoint;
		if(size%2!=0){
			midpoint = (int)size/2;
		}else{
			midpoint = size/2 - 1; 
		}
		System.out.println("size : "+ size + " , midpoint : "+ midpoint);
		TreeNode<Long> rootNode = new TreeNode<>(sortedNumberList.get(midpoint));
		TreeNode<Long> leftNode = createBSTfromSortedList(sortedNumberList.subList(0, midpoint));
		TreeNode<Long> rightNode = createBSTfromSortedList(sortedNumberList.subList(midpoint+1, size));
		rootNode.setLeftNode(leftNode);
		rootNode.setRightNode(rightNode);
		return rootNode;
	}

	/**
	 * given a marker value , find 2 nodes which are just below and just above 
	 * the marker value.
	 * 
	 * We need to find a set of parent - child node where the marker value falls 
	 * between the values of these nodes
	 * 
	 * @param root
	 * @param floor
	 * @param ceiling
	 * @param markerValue
	 */
	public static void identifyFloorAndCeiling(TreeNode<Long> root, double markerValue) {
		
		// failsafe condition
		if(root==null || root.isLeafNode() ) return ;
		
	    final  String MARKERVALUE_KEY = "markerValue";
	    final  String FLOOR_VALUE_KEY = "floor";
	    final  String CIELING_VALUE_KEY = "cieling";
	    
		Map<String, Object> associatedData = new HashMap<String, Object>();
		associatedData.put(MARKERVALUE_KEY , new Double(markerValue));

		(new TreePreOrderTraversalHandler() {
			
			@Override
			protected void processNode(TreeNode<Long> node, int level, Map<String, Object> associatedData) {
				Double markerVal =  (Double)associatedData.get(MARKERVALUE_KEY);
				Double floor = associatedData.containsKey(FLOOR_VALUE_KEY) ? ((TreeNode<Long>)associatedData.get(FLOOR_VALUE_KEY)).getData() : (-1*Double.MAX_VALUE);
				Double cieling = associatedData.containsKey(CIELING_VALUE_KEY) ?  ((TreeNode<Long>)associatedData.get(CIELING_VALUE_KEY)).getData()  : Double.MAX_VALUE;
				
				Long nodeData = node.getData();
//				System.out.println("floor : "+floor+" ,markerval : "+markerVal+" node : "+node+" , ceil : "+cieling);
				//  currentFloor <<< nodedata <<<<  marker value : change floor to node data 
				if(nodeData < markerVal  
						&&
						floor < nodeData
						){
					associatedData.put(FLOOR_VALUE_KEY , node);
				}
				// markervalue << nodedata  << currentcieling
				if(markerVal < nodeData  
						&&
						nodeData < cieling
						){
					associatedData.put(CIELING_VALUE_KEY , node);
				}
			}
		}).preOrderTreeTraversal(root, associatedData);
		
		
		TreeNode<Long> floor = (TreeNode<Long>)associatedData.get(FLOOR_VALUE_KEY);
		TreeNode<Long> ceiling = (TreeNode<Long>)associatedData.get(CIELING_VALUE_KEY);
		System.out.println("floor : "+floor);
		System.out.println("ceiling : "+ceiling);
	}
	
	public static boolean isAVLTree(TreeNode root){
		
		if(root!=null){
			
			
			if(root.isLeafNode())return true;
			int leftHeight = 0;
			if(root.leftNodeExist()){
				leftHeight = root.getLeftNode().getMaxHeight();
			}
			int rightHeight = 0;
			if(root.rightNodeExist()){
				rightHeight = root.getRightNode().getMaxHeight();
			}
			
			System.out.println("root : "+root+" leftHeight : "+leftHeight+"rightHeight :  "+rightHeight);
			
			if(  Math.abs(leftHeight - rightHeight)  > 1   ){
				return false;
			}else{
				return TreeUtility.isAVLTree( root.getRightNode()) 
						&&
						TreeUtility.isAVLTree( root.getLeftNode());
			}
			
			
		}
		
		return false;
	}
	

}
