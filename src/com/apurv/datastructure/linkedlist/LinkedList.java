package com.apurv.datastructure.linkedlist;

/**
 * 
 * Head ================ Tail
 * 
 * @author Apurv
 *
 */
public class LinkedList {

	private LinkedListNode head = null;
	private int size = 0;

	public LinkedList() {
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
		if (isEmpty() ) {
			insertHead(data);
			return;
		}

		// if data is less then head element , simply insert at head
		if (data <= head.getData()) {
			insertHead(data);
			return;
		}

		// if we have exactly 1 element in list
		// elements will be placed after head
		// we have already covered the condition when
		// element is below head

		if (size == 1) {
			insertAfter(head, data);
			return;
		}

		LinkedListNode temp = head;
		LinkedListNode tempNext = head.getNext();
		while (true) {
			// 1,2,3,4,6,7
			if (data > tempNext.getData()) {
				// move to next
				temp = tempNext;
				tempNext = tempNext.getNext();

				if (tempNext == null) {
					// end of list reched , insert here anyway
					insertAfter(temp, data);
					break;
				}

			} else {
				// need to insert in front of temp
				insertAfter(temp, data);
				break;
			}
		}
	}

	private void insertAfter(LinkedListNode node, int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (node != null) {
			LinkedListNode temp = node.getNext();
			node.setNext(newNode);
			newNode.setNext(temp);
			increaseSize();
		}
	}

	public void insertHead(int numberToInsert) {
		// insert the data in the beginning
		// create a node
		LinkedListNode node = new LinkedListNode(numberToInsert);

		if (isEmpty()) {
			// we are inserting first elememnt in list
			this.head = node;
		} else {
			// put the node at head
			node.setNext(this.head);
			this.head = node;
		}
		// inc size
		increaseSize();
	}

	public void printListToConsole() {
		System.out.println("printing list , size = " + size);
		if (size == 0)
			return;
		LinkedListNode temp = head;
		while (true) {
			System.out.print(temp.getData() + " --> ");
			temp = temp.next;
			if (temp == null) {
				System.out.println("[END]");
				break;
			}
		}

	}

	/**
	 * removes all occurrences of an element from list
	 */
	public void removeElementFromList(int elementtoremove) {
		// nothing to do on empty list
		if (isEmpty())
			return;

		// if we have more then 1 element in the list , we will
		// use 2 consecutive pointers
		// first check if head needs to be removed

		if (elementtoremove == head.getData()) {
			removeHead();
			return;
		}

		if (size > 1) {
			LinkedListNode temp = head;
			LinkedListNode tempNext = head.getNext();

			while (true) {

				if (tempNext == null)
					break;

				if (elementtoremove == tempNext.getData()) {
					// remove tempNext from list

					LinkedListNode tempNextNew = tempNext.getNext();
					temp.setNext(tempNextNew);
					tempNext.setNext(null);
					decreaseSize();
					tempNext = tempNextNew;

				} else {
					temp = tempNext;
					tempNext = tempNext.getNext();
				}
			}
		}

	}

	public void removeHead() {
		head = head.getNext();
		decreaseSize();
	}

	public int getLastElement() {
		return this.getTailNode().getData();
	}

	/**
	 * @return last node in the list
	 */
	private LinkedListNode getTailNode() {

		if (isEmpty())
			return null;

		LinkedListNode temp = head;
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

	private class LinkedListNode {

		private int data;
		private LinkedListNode next = null;

		public LinkedListNode(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public LinkedListNode getNext() {
			return next;
		}

		public void setNext(LinkedListNode next) {
			this.next = next;
		}

	}

}
