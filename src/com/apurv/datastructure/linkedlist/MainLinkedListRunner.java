package com.apurv.datastructure.linkedlist;

import com.apurv.util.RandomGenerationUtils;

public class MainLinkedListRunner {

	public static void main(String[] args) {
		
		System.out.println("-- Start --");
//		createlist();
//		createlistandinsertsorted();
//		createlistandgetlastnode();
//		createlistandRemoveElement();
		createdoublelistandinsertsorted();
		
		System.out.println("-- End --");
	

	}
	
	
	private  static void createdoublelistandinsertsorted(){
		DoubleLinkedList list = new DoubleLinkedList();
		for(int i=0;i<15;i++){
			list.insertInSortedOrder((int)RandomGenerationUtils.randomLong(3));
			list.printListToConsole();
		}
	}
	
	
	private  static void createlistandRemoveElement(){
		LinkedList list = new LinkedList();
		int[] numbers = {12,45,56,23,78,12,89,345,45,97};

		for(int i : numbers){
			list.insertHead(i);
		}
		
		
		list.printListToConsole();
		System.out.println("remove from list : 12");
		list.removeElementFromList(12);
		list.printListToConsole();
		
		System.out.println("remove from list : 78 ");
		list.removeElementFromList(78);
		list.printListToConsole();
		
		
		System.out.println("remove from list : 97 ");
		list.removeElementFromList(97);
		list.printListToConsole();
		
	}
	
	
	
	
	private  static void createlist(){
		LinkedList list = new LinkedList();
		for(int i=0;i<10;i++){
			list.insertHead((int)RandomGenerationUtils.randomLong(3));
			list.printListToConsole();
		}
	}
	
	private  static void createlistandinsertsorted(){
		LinkedList list = new LinkedList();
		for(int i=0;i<15;i++){
			list.insertInSortedOrder((int)RandomGenerationUtils.randomLong(3));
			list.printListToConsole();
		}
	}
	
	
	private  static void createlistandgetlastnode(){
		LinkedList list = new LinkedList();
		for(int i=0;i<10;i++){
			list.insertHead((int)RandomGenerationUtils.randomLong(3));
			
		}
		
		list.printListToConsole();
		System.out.println("Last element : "+ list.getLastElement());
		
		
		
		
	}
	
	
	
	

}
