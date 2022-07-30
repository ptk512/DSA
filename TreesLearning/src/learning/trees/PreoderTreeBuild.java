package learning.trees;

import java.util.*;
import java.io.*;

public class PreoderTreeBuild {
	
	static class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}	
		
	}
	
	
	static class BinaryTree{
		static int idx = -1;
		public static Node buildTree(int[] nodes) {
			
			idx++;
			
			if(nodes[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			
			return newNode;
			
			 
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println(root.data);
		
		//---calling preorder traversal -----------------//
		
		System.out.println("--------Pre-Order --------");
		preOrderTraversal(root);
		
		System.out.println();
		
		System.out.println("--------in-Order --------");
		inOrderTraversal(root);
		
		System.out.println();
		
		System.out.println("--------Post-Order --------");
		postOrderTraversal(root);
		
		System.out.println();
		
		System.out.println("--------LEVEL-Order --------");
		levelOrderTraversal(root);
		
		System.out.println("--------Count Number of Nodes --------");
		System.out.println(countNodes(root));
		
		System.out.println("--------Sum of Nodes --------");
		System.out.println(sumOfNodes(root));
		
		System.out.println("--------Height of Tree --------");
		System.out.println(heightOfTree(root));
		
		System.out.println("--------Diameter of Tree --------");
		System.out.println(diameterOfTree(root));
		
		System.out.println("--------Diameter of Tree in better approach --------");
		System.out.println(diameter2(root).diam);
		
	}
	
	
	//------------------------------PRE-ORDER TRAVERSAL-------------------------------//
	
	/* 
	 * Root
	 * Left Subtree
	 * Right Subtree
	 */
	
	public static void preOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}
	
	//------------------------------IN-ORDER TRAVERSAL-------------------------------//

	 	/*
	 	 * Left Subtree
	 	 * Root
	 	 * Right Subtree 
	 	 */

		public static void inOrderTraversal(Node root) {
			
			if(root == null) {
				return;
			}
			
			inOrderTraversal(root.left);
			System.out.print(root.data +" ");
			inOrderTraversal(root.right);
			
		}
		
		//------------------------------POST-ORDER TRAVERSAL-------------------------------//

	 	/*
	 	 * Left Subtree
	 	 * Right Subtree 
	 	 * Root
	 	 */

		public static void postOrderTraversal(Node root) {
			
			if(root == null) {
				return;
			}
			
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
			
		}
		
		
		//------------------------------LEVEL-ORDER TRAVERSAL-------------------------------//

	 	/*
	 	 * LEVEL - 1
	 	 * LEVEL - 2
	 	 * LEVEL - 3
	 	 * ---SO ON
	 	 */

		public static void levelOrderTraversal(Node root) {
			
			if(root == null) {
				return;
			}
			
			Queue<Node> q = new LinkedList<>();
			
			q.add(root);
			q.add(null);
			
			while(!q.isEmpty()) {
				
				Node currNode = q.remove();
				
				if(currNode == null) {
					
					System.out.println();
					
					if(q.isEmpty()) {
						break;
					}
					else {
						q.add(null);
					}				
					
				}
				
				else {
					
					System.out.print(currNode.data + " ");
					
					if(currNode.left != null) {
						q.add(currNode.left);
					}
					if(currNode.right != null) {
						q.add(currNode.right);
					}
				}
				
				
			}
			
			
			
		}
		
		
		
		//---------------------------Count No of Nodes --------------------------//
		
		static int countNodes(Node root) {
			
			if(root == null) return 0;
			
			int leftNodeCount = countNodes(root.left);
			int rightNodeCount = countNodes(root.right);
			
			return leftNodeCount + rightNodeCount + 1;
			
		}
		
		
		//---------------------------Sum of Nodes --------------------------//
		
			static int sumOfNodes(Node root) {
					
					if(root == null) return 0;
					
					int leftSum = sumOfNodes(root.left);
					int rightSum = sumOfNodes(root.right);
					
					return leftSum + rightSum + root.data;
					
		}
	
			//---------------------------Height of Tree --------------------------//
			
		static int heightOfTree(Node root) {
					
					if(root == null) return 0;
					
					int leftHeight = heightOfTree(root.left);
					int rightHeight = heightOfTree(root.right);
					
					return Math.max(leftHeight, rightHeight)+1;
					
		}
		
		//----------------Diameter of Tree in O(N^2) Approach 1--------------------//
		
		static int diameterOfTree(Node root) {
				if(root == null) return 0;
							
				int diam1 = diameterOfTree(root.left); //case 1
				int diam2 = diameterOfTree(root.right); //case 2
							
				int diam3 = heightOfTree(root.left) + heightOfTree(root.right)+1; //case 3
							
				return Math.max(diam3, Math.max(diam1, diam2));
							
		}
		
		
		//----------------Diameter of Tree in O(N) Approach 2--------------------//
		
		static class TreeInfo{
			
			int ht;
			int diam;
			
			TreeInfo(int ht, int diam){
				this.ht = ht;
				this.diam = diam;
			}
			
		}
		
		
		public static TreeInfo diameter2(Node root) {
			
			if(root == null) {
				return new TreeInfo(0,0);
			}
			
			
			TreeInfo left = diameter2(root.left);
			TreeInfo right = diameter2(root.right);
			
			int myHeight = Math.max(left.ht, right.ht) + 1; // height of tree at any given node
			
			int diam1 = left.diam;
			int diam2 = right.diam;
			int diam3 = left.ht + right.ht + 1;
			
			int myDiam = Math.max(Math.max(diam1, diam2), diam3);
			
			TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
			
			return myInfo;
			
			
		}
		
	
}


	
	
