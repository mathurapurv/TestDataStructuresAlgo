package com.apurv.util;

public class AnalyseHashing {

	public static void main(String[] args) {
		   int h = 0;
		   int hash;
		   int tableLength = 16;
		   int index ;
		   
		   int objectHashCode =  121;

		   System.out.println("objectHashCode : "+ Integer.toBinaryString(objectHashCode));

	        h ^= objectHashCode;
	        System.out.println("h ^= objectHashCode : "+Integer.toBinaryString(h));

	        System.out.println("(h >>> 20) : "         		
	        		+Integer.toBinaryString(h >>> 20));
	        
	        System.out.println("(h >>> 12) : "         		
	        		+Integer.toBinaryString(h >>> 12));
	        
	        System.out.println("(h >>> 20) ^ (h >>> 12) : "         		
	        		+Integer.toBinaryString((h >>> 20) ^ (h >>> 12)));
	        
	        h ^= (h >>> 20) ^ (h >>> 12);
	        
	        System.out.println("h : "         		
	        		+Integer.toBinaryString(h));
	        
	        System.out.println("(h >>> 7) : "         		
	        		+Integer.toBinaryString((h >>> 7)));

	        System.out.println("(h >>> 4) : "         		
	        		+Integer.toBinaryString((h >>> 4)));
	        
	        
	        hash= h ^ (h >>> 7) ^ (h >>> 4);
	        
	        System.out.println("hash : "         		
	        		+Integer.toBinaryString(hash));
	        
	        
	        index=   h & (tableLength-1);
	        System.out.println("index : "+index);
	        
		
	}

}
