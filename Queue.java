import java.util.*;
class QueueOperations{
	int queue[];
	int rear = -1;
	int queueSize;
	protected QueueOperations(int size){
		queueSize = size;
		queue = new int[size];
	}
	protected void enQueue(int data){
		++rear;
		if(rear == queueSize){
			System.out.println("Queue size is full");
			return;
		}		
		queue[rear] = data;
	}
	protected void deQueue(){
		if(rear < 0){
			System.out.println(" Queue is empty");
			return;
		}
		System.out.println(queue[rear]+ "is removed from queue");
		--rear;
	}	
}
class Queue{
	public static void main(String args[]){		
		Scanner in = new Scanner(System.in);
		System.out.print("Queue size: ");
		int size = in.nextInt();
		QueueOperations q = new QueueOperations(size);
		int c, data;
		do{
			System.out.print("1.enqueue\n2.dequeue\n3.exit\n");
			c = in.nextInt();
			switch(c){
				case 1: 
					System.out.print("Element: ");
					data = in.nextInt();
					q.enQueue(data);
				break;
				case 2: 
					q.deQueue();					
				break;
			}
		}while(c!=3);		
	}
}
