package com.prateek.BST;

import java.util.ArrayList;

public class BST {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static Node insert(Node root, int val) {
		
		if(root == null) {
			root = new Node(val);
			return root;
		}
		
		if(val < root.data) {
			root.left = insert(root.left, val);
		}
		else {
			root.right = insert(root.right, val);
		}
		
		return root;
		
	}
	
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}

	
	
	/*
	 * BST Search
	 */	

	static boolean search(int key, Node root) {
		
		if(root == null) {
			return false;
		}
		if(key == root.data) {
			return true;
		}
	    else if(key < root.data) {
			return search(key, root.left);
		}
		else  {
			return search(key, root.right);
		}
		
	}
	
	
	/*
	 * BST Delete a node
	 */	
	public static Node delete(Node root, int val) {
		
		//searching node to be deleted
		if(val < root.data) {
			root.left = delete(root.left, val);
		}
		else if(val > root.data) {
			root.right = delete(root.right, val);
		}
		
		else //this else means val == root.data {we have node to be deleted in root)
		{
			//case 1. => No child
			if(root.left == null && root.right == null) {
				return null;
			}
			
			//case 2. => 1 child
			if(root.left == null) {
				return root.right; //since we have node to be deleted in root, so instead of root we are returning its child i.e. root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			
			
			//case 3. => 2 childs
			Node IS = inOrderSuccessor(root.right); //IS = inOrderSuccessor (left most node in right subtree)
			//that's why we are passing right subtree of root(node to be deleted) in the inordersuccessor function 
			//where we will only calculate leftmost node
			
			root.data = IS.data; //replacing the data
			delete(root.right, IS.data); //recursively calling the delete which will delete the original IS
			
			
		}
		return root;
		
	}
	
	static Node inOrderSuccessor(Node root) {
		//since we already passed root.right from delete function, now we only left to calculate left most node
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	
	
	/**************************************************************************
	 ***************************** BST PRINT in Range  *************************
	 ***************************************************************************/	
	public static void printInRange(Node root, int x, int y) {
		if(root == null) {
			return;
		}
		if(x <= root.data && root.data <= y) {
			printInRange(root.left,x,y);
			System.out.print(root.data +" ");
			printInRange(root.right, x, y);
		}
		
		else if(x > root.data) {
			printInRange(root.right, x, y);
		}
		
		else if(y < root.data) {
			printInRange(root.left, x, y);
		}
		
	}
	
	
	/**************************************************************************
	 *****************************  PRINT Root to leaf paths********************
	 ***************************************************************************/
	
	public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
		
		if(root == null) {
			return;
		}
		
		path.add(root.data);
		
		//leaf node condition
		if(root.left == null && root.right == null) {
			printPath(path); //printpath = function which prints arraylist
		}
		else {//non-leaf
			printRoot2Leaf(root.left, path);
			printRoot2Leaf(root.right, path);
		}
		path.remove(path.size()-1); // vapas jaate time(BACKTRACK) return ke time, arraylist se hata denge node
		
	}
	
	public static void printPath(ArrayList<Integer> path) {
		//System.out.println("path size = "+path.size());
		for(int i=0; i<path.size(); i++) {
			System.out.print(path.get(i) + "->");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] bstData = {8, 5, 3, 6, 10, 11, 14};
		Node root = null;
		
		for(int i=0; i<bstData.length; ++i) {
			root = insert(root, bstData[i]);
		}
		
		inOrder(root);
		System.out.println();
		
		System.out.println("-----------Searching Node 6----------");
		boolean isExist = search(6, root);
		System.out.println("Node 6 exist in BST : "+isExist);
		
		//System.out.println("-----------deleting Node 4----------");
		//delete(root, 4);
		//inOrder(root); 
		
		
		System.out.println("-----------Printing in range 2-5----------");
		printInRange(root, 2, 5);
		System.out.println();
		
		System.out.println("-----------Printing Root to leaf paths----------");
		
		printRoot2Leaf(root, new ArrayList<Integer>());


		
	}

}
