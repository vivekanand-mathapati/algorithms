import java.util.*;

class DeueueOperations{
	int queue[];
	int front = -1;
	int rear = -1;
	int queueSize;
	protected DeueueOperations(int size){
		queueSize = size;
		queue = new int[queueSize];
	}
	protected boolean isFull(){
		if(( front == 0 && rear == queueSize-1 ) || front == rear+1)
			return true;
		return false;
	}
	protected boolean isEmpty(){
		if(front == -1)
			return true;
		return false;
	}
	protected void frontEnQueue(int data){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(front == 0)
			front = queueSize -1;
		else{
			--front;			
		}	
		queue[front] = data;	
	}
	protected void rearEnQueue(int data){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(rear == queueSize -1)
			rear = 0;
		else{
			++rear;
			if(front == -1)
			++front;			
		}
		queue[rear] = data;
	}
	protected void frontDeQueue(){
		if(isEmpty()){
			System.out.print("Queue is empty");
			return;
		}
		if(front == rear)
			front = rear = -1;
		else if(front == queueSize-1)
			front = 0;
		else{
			System.out.println(queue[front]+ " is deleted from queue");
			++front;
		}
			
	}
	protected void rearDeQueue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		if(front == rear)
			rear = front = -1;
		else if(rear == 0)
			rear = queueSize -1;
		else{
			System.out.println(queue[rear]+" Queue is empty");
			--rear;
		}
	}
	protected void display(){
		System.out.print("Front: "+ front+"\n");
		System.out.print("Rear: "+ rear+"\n");
		System.out.println("queue elements");
		for(int i=0;i<queue.length;i++)
			System.out.print(queue[i]+" ");
		System.out.println();
	}
}

class DeQueue{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Queue size: ");
		int queueSize = in.nextInt();
		DeueueOperations dq = new DeueueOperations(queueSize);
		int c,data;
		do{
			System.out.println("1.front enqueue\n2.rear enque\n3.front dequeue\n4. rear dequeue\n5.display\n6.exit");
			c = in.nextInt();
			switch(c){
				case 1:
					System.out.print("Element: ");
					data = in.nextInt();
					dq.frontEnQueue(data);
				break;
				case 2:
					System.out.print("Element: ");
					data = in.nextInt();
					dq.rearEnQueue(data);
				break;
				case 3: 
					dq.frontDeQueue();
				break;
				case 4: 
					dq.rearDeQueue();
				break;
				case 5: 
					dq.display();
				break;
			}
		}while(c!=6);
	}
}
