import java.util.*;
class Stack{
	int max=5,top =-1,minTop=-1;
	int stack[] = new int[max];//stack contains original values
	int minStack[] = new int[max];//auxiliary stack contains min elements
	public void push(int data){
		if(top == max-1)
			System.out.println("stack is full");
		else{
			++top;
			stack[top] = data;
			if(minTop == -1){
				++minTop;
				minStack[minTop] = data;
			}else if(data < minStack[minTop]){
				++minTop;
				minStack[minTop] = data;
			}
		}
	}
	
	public void pop(){
		if(top == -1){
			System.out.println("stack is empty!");
			return;
		}else{
			System.out.println(stack[top]+" popped");
			if(stack[top] == minStack[minTop]){
				--top;
				--minTop;
			}else{
				--top;
			}				
		}
	}
	
	public void min(){
		if(top > -1)
			System.out.println(minStack[minTop]);
		else
			System.out.println("stack is empty!");
	}
}

class SpecialStack{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Stack st = new Stack();
		int data,c;
		do{
			System.out.println("1.push\n2.pop\n3.min\n4.exit");
			c = in.nextInt();
			switch(c){
				case 1:
					System.out.print("data: ");
					data = in.nextInt();
					st.push(data);
				break;
				case 2:
					st.pop();
				break;
				case 3:
					st.min();
				break;
			}
		}while(c!=4);
	}
}
