package com.Prateek.linkedLIST;

import java.util.LinkedList;

public class LL {
	Node head;
	private int size;
	
	LL(){
		this.size = 0;
	}
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
			size++;
		}
	}
	
	//add - first, last
	// first - we already have linkedlist and we will add new node at first
	// last - we already have linkedlist and we will add new node at last of linked list
	
	public void addFirst(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
		
	}
	
	// adding to the last of LL.
	public void addLast(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}

		Node currNode = head;
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		
		currNode.next = newNode;
	}
	
	//printing the LL
	
	public void printList() {
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		
		Node currNode = head;
		while(currNode != null) {
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		
		System.out.println("NULL");
	
	}

	
	//deleting a linked list
	
	//delete-first, delete last
	
	//to delete first, we make next of head as head || 
	//the first which is not pointed to any will be collected by Java garbage collector;
	
	public void deleteFirst() {
		
		if(head == null) {
			System.out.println("List is emplty");
			return;
		}
		size--;
		head = head.next;		
	}
	
	//delete last -> we will iterate to 2nd last node and point its next to null
	//now the last node which is not pointed by any node will be collected by Java garbage collector;
	
	public void deleteLast() {
		
		if(head == null) {
			System.out.println("the list is empty");
			return;
		}
		
		size--;
		
		if(head.next == null) {// ek hi node hai list me bas
			head = null;
			return;
		}
		
		Node secondLast = head;
		Node lastNode = head.next;
		
		while(lastNode.next != null) { //lastNode.next = head.next.next
			lastNode = lastNode.next;
			secondLast = secondLast.next;
		}
		//this loop will stop when last.next is null means we will have lastNode in lastnode variable
		// second last node in secondLast variable
		
		secondLast.next = null;
		
	}
	
	
	//reverse linked list in iterative and recursive way
	
	//ITERATIVE
	public void reverseIterative() {
		
		if(head == null || head.next == null) {
			return;
		}
		
		Node prevNode = head;
		Node currNode = head.next;	
		
		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			
			//update the nodes
			prevNode = currNode;
			currNode = nextNode;
		}
		
		//ab yaha pr loop ke baad currNode hoga null and prevNode hoga last node
		//to last node ko head banana padega
		head.next = null;
		head = prevNode;
	}
	
	
	//RECURSUVE REVERSE
	
	public Node reverseRecursive(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = reverseRecursive(head.next);
		
		head.next.next = head;
		head.next = null;
		return newHead;
		
	}
	
	public int getSize() {
		return size;
	}
	
	
	
	//Question - Find and delete nth node from the end of linked list
	
		public void deleteNth(int n) {
			
			Node currNode = head;
			
			int sizeOfLL = 0;
			
			while(currNode != null) {
				currNode = currNode.next;
				sizeOfLL++;
				
			}
			
			System.out.println(sizeOfLL);
			//dfs = distance from start
			int dfs = sizeOfLL - n + 1;
			System.out.println("dfs = "+dfs);
			
			currNode = head;
			for(int i=1; i<dfs-1; i++) {
				currNode = currNode.next;
			}
			
			Node nodeToBeDeleted = currNode.next;
			
			currNode.next = nodeToBeDeleted.next;
			
					
		}
	
	
	public static void main(String[ ]args) {
		
		LL list = new LL();
		
		list.printList();
		
//		list.addFirst("a");
//		list.addFirst("is");
//		
//		list.printList();
//		
//		list.addLast("Linked");
//		list.addLast("list");
//		
//		list.addFirst("this");
//		list.printList();
//		
//		list.deleteFirst();
//		list.printList();
//		
//		list.deleteLast();
//		list.printList();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.printList();
		
		
		//list.head =list.reverseRecursive(list.head);
		
		list.deleteNth(3);
		list.printList();
		
		//System.out.println(list.getSize());
	}

}
