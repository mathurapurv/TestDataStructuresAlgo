package com.apurv.datastructure.linkedlist;


public class DoubleLinkedList {
	
	private DoubleLinkedListNode head = null;
	private int size = 0;
	
	public DoubleLinkedList() {
		initialize();
	}

	private void initialize() {
		// initialization stuff
	}
	
	
	/**
	 * assume that existing elements of list are in sorted order
	 * 
	 * @param data
	 */
	public void insertInSortedOrder(int data) {
		
		// if we have empty list , insert first element
		if (isEmpty()) {
			insertHead(data);
			return;
		}
		
		// if data is less then head element , simply insert at head
		if (data <= head.getData()) {
			insertHead(data);
			return;
		}
		
		
		// traverse the chain , stop when we find bigger
		DoubleLinkedListNode temp = head;
		while(true){
			
			
			
			
			
			
			if(data>temp.getData()        ) {
				
				if(temp.getNext()==null){
					// insert ahead of the previous
					insertAfter(temp, data);
					break;
				}
				
				
				
				
				temp=temp.getNext();
				continue;
			}else{
				// insert ahead of the previous
				insertAfter(temp.getPrevious(), data);
				break;
			}
		}
		
		

	}
	
	
	private void insertAfter(DoubleLinkedListNode node, int data) {
		DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
		
		
		if (node != null) {
			DoubleLinkedListNode temp = node.getNext();
			node.setNext(newNode);
			newNode.setNext(temp);
			newNode.setPrevious(node);
			if(temp!=null) temp.setPrevious(newNode);
			increaseSize();
		}
	}
	
	
	public void insertHead(int numberToInsert) {
		// insert the data in the beginning
		// create a node
		DoubleLinkedListNode node = new DoubleLinkedListNode(numberToInsert);

		if (isEmpty()) {
			// we are inserting first elememnt in list
			this.head = node;
		} else {
			
			head.setPrevious(node);
			// put the node at head
			node.setNext(this.head);
			this.head = node;
		}
		// inc size
		increaseSize();
	}

	
	
	
	
	/**
	 * @return last node in the list
	 */
	private DoubleLinkedListNode getTailNode() {

		if (isEmpty())
			return null;

		DoubleLinkedListNode temp = head;
		while (true) {
			if (temp.getNext() != null) {
				temp = temp.getNext();
				continue;
			} else {
				break;
			}
		}
		return temp;
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}

	private void increaseSize() {
		size++;
	}

	private void decreaseSize() {
		size--;
	}
	
	
	public void printListToConsole() {
		System.out.println("printing list , size = " + size);
		if (size == 0)
			return;
		DoubleLinkedListNode temp = head;
		while (true) {
			System.out.print(temp.getData() + " <==> ");
			temp = temp.next;
			if (temp == null) {
				System.out.println("[END]");
				break;
			}
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private class DoubleLinkedListNode{
		
		
		private int data;
		private DoubleLinkedListNode next=null;
		private DoubleLinkedListNode previous=null;
		
		
		public DoubleLinkedListNode(int data){
			this.data=data;
		}
		
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public DoubleLinkedListNode getNext() {
			return next;
		}
		public void setNext(DoubleLinkedListNode next) {
			this.next = next;
		}
		public DoubleLinkedListNode getPrevious() {
			return previous;
		}
		public void setPrevious(DoubleLinkedListNode previous) {
			this.previous = previous;
		}

		
	}

}
