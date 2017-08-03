import java.util.*;
import java.io.*;

class Node{
	int data;
	Node left,right;
	public Node(int data){
		this.data = data;
	}
}

class BinaryTree{
	Node root;
	public void insert(int data){
		root = insertRec(root,data);
	}
	public Node insertRec(Node root,int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		if(data <= root.data){
			root.left = insertRec(root.left,data);
		}else{
			root.right = insertRec(root.right,data);
		}
		return root;
	}
	public void inOrder(){
		inOrderRec(root);
	}
	public void postOrder(){
		postOrderRec(root);
	}
	public void preOrder(){
		preOrderRec(root);
	}
	public void inOrderRec(Node root){
		if(root != null){
			inOrderRec(root.left);
			System.out.println(root.data);
			inOrderRec(root.right);
		}
	}
	public void postOrderRec(Node root){
		if(root != null){
			postOrderRec(root.left);			
			postOrderRec(root.right);
			System.out.println(root.data);
		}
	}
	public void preOrderRec(Node root){
		if(root != null){
			System.out.println(root.data);
			preOrderRec(root.left);			
			preOrderRec(root.right);			
		}
	}
}
class BinarySearchTree{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		BinaryTree tree = new BinaryTree();
		int c,data;
		do{
			System.out.println("1.insert\n2.in-order\n3.post-order\n4.pre-order\n5.exit");
			c = in.nextInt();			
			switch(c){
				case 1:
					System.out.print("Enter data: ");
					data = in.nextInt();
					tree.insert(data);
				break;
				case 2: 
					System.out.println("In order traversal");
					tree.inOrder();
				break;
				case 3: 
					System.out.println("In order traversal");
					tree.postOrder();
				break;
				case 4: 
					System.out.println("In order traversal");
					tree.preOrder();
				break;				
			}
		}while(c!=5);
	}
}
