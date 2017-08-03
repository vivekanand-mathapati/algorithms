import java.util.*;
import java.io.*;

class Node{
	int data;
	Node next;	
	
	public Node(int data){
		this.data = data;
	}	
}

class LinkedList{
	Node head;
	public void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
	}
	public void prepend(int data){
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	public void deleteWithValue(int data){
		if(head == null)
			return;
		if(head.data == data){
			head = head.next;
			return;
		}
		Node current = head;
		while(current.next != null){
			if(current.next.data == data){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	public void display(){
		Node current = head;
		while(current.next != null){
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}	
}
class MainClass{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		LinkedList l = new LinkedList();
		int c,data;
		do{
			System.out.println("1.append\n2.prepend\n3.delete\n4.disply\n5.exit");
			c = in.nextInt();
			switch(c){
				case 1:
					System.out.print("Add value: ");
					data = in.nextInt();
					l.append(data);
				break;
				case 2:
					System.out.print("Add value: ");
					data = in.nextInt();
					l.prepend(data);
				break;
				case 3:
					System.out.print("Add value: ");
					data = in.nextInt();
					l.deleteWithValue(data);
				break;
				case 4:
					l.display();
				break;
			}
		}while(c!=5);
	}
}
