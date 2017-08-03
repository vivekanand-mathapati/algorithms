import java.io.*;
import java.util.*;

class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data = data;
	}
}
class LinkedList{
	Node head,end;
	public void append(int data){
		if(head == null){
			head = new Node(data);
			end = head;
			return;
		}
		Node temp = new Node(data);
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = temp;
		temp.prev = current;
		end = temp;
	}
	public void display(){
		Node current = end;
		while(current.prev != null){
			System.out.println(current.data);
			current = current.prev;
		}
		System.out.println(current.data);
	}
}
class DoublyLinkedList{
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
				case 4:
					l.display();
				break;
			}
		}while(c!=5);
	}
}

