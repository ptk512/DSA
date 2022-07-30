package com.Prateek.linkedLIST;

import java.util.*;

public class LLusingCollections {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.addFirst(1);
		list.addFirst(2);
		System.out.println(list);
		
		list.addLast(3);
		list.add(4); //default add will add the element to last of list
		System.out.println(list);
		
		list.addFirst(5);
		System.out.println(list);
		
		list.remove(); //it will remove the first element
		System.out.println(list);
		
		list.remove(2);  //removing the element at index 2
		System.out.println(list);
		
		list.add(2, 6); //adding "linked" at the index 2
		System.out.println(list);
		
		
		
	}
	
	
}
