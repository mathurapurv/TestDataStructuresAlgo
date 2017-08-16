package com.apurv.datastructure.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class handles the logic of level order traversal of a tree , 
 * and exposed an abstract method to handle logic for what has to be done 
 * with each node as we go through them 
 * 
 * Created to keep traversal logic at same place
 * 
 * @author Apurv
 *
 */
public abstract  class TreeLevelOrderTraversalHandler {

	
	protected abstract void processNode(TreeNode<Long> node , int level, Map<String, Object> associatedData);
	

	/**
	 * 
	 * Tree traversal by level , prints elements at individual levels 
	 * @param root
	 */
	public  void levelOrderTreeTraversal(TreeNode<Long> root, Map<String, Object> associatedData) {
		

		LinkedList<TreeNode<Long>> elementQ = new LinkedList<TreeNode<Long>>();
		TreeNode markerInstance = TreeNode.getMarkerInstance();
		TreeNode<Long> temp = null;
		int currentLevel = 0;
		if(associatedData==null)associatedData=new HashMap<String, Object>();

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
					// marker instance is used as boundary between elements of different 
					// levels 
					elementQ.push(markerInstance);
					continue;
				}
			}
			// do what you want to do with the node 
			
			processNode(temp, currentLevel, associatedData);
			if (temp.getLeftNode() != null)
				elementQ.push(temp.getLeftNode());
			if (temp.getRightNode() != null)
				elementQ.push(temp.getRightNode());
		}

	}

	
	
	
}
