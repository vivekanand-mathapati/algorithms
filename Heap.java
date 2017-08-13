import java.util.*;

class Heapify{
	public void buildMaxHeap(int[] arr,int n){
		for(int i = n/2; i>=1;i--){
			maxHeap(arr,i,n);
		}
		for(int i=1;i<=n;i++)
			System.out.print(arr[i]+" ");
	}
	public void maxHeap(int[] arr,int i,int n){
		int l = 2*i;
		int r = (2*i)+1;
		int largest = i;
		if(l<=n && arr[l]>arr[largest])
			largest = l;
		if(r<=n && arr[r]>arr[largest])
			largest = r;
		if(i != largest){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeap(arr,largest,n);
		}		
	}
	public void increaseKey(int[] arr,int i,int n,int key){
		if(key < arr[i]){
			System.out.print("Value must be greater than "+arr[i]);
			return;
		}
		arr[i] = key;
		int j = i;
		while( j>=1 && arr[j/2] > arr[j]){
			int temp = arr[j];
			arr[j] = arr[j/2];
			arr[j/2] = temp;
			j = j/2;
		}
	}
	public void insert(int arr[],int n,int data){
		arr[n] = Integer.MIN_VALUE;
		increaseKey(arr,n,n,data);
	}
	public void deleteMax(int[] arr, int n){
		int max = arr[1];
		arr[1] = arr[n];
		arr[n] = 0;
		maxHeap(arr,1,n);
		System.out.println(max);
	}
	
}

class Heap{
	public static void main(String args[]){
		Heapify heap = new Heapify();
		Scanner in = new Scanner(System.in);
		System.out.print("Heap size: ");
		int n = in.nextInt();
		System.out.print("Heap elements: ");
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++)
			arr[i] = in.nextInt();
		
		int data;
		int c;
		do{
			System.out.println("\n1.insert\n2.delete\n3.increase\n4.disply\n5.exit");
			c = in.nextInt();
			switch(c){
				case 1: 
					System.out.print("Element: ");
					data = in.nextInt();
					heap.insert(arr,n,data);
				break;
				case 2:
					heap.deleteMax(arr,n);
				break;
				case 3:
					System.out.print("Posision: ");
					int pos = in.nextInt();
					System.out.print("Key: ");
					int key = in.nextInt();
					heap.increaseKey(arr,pos,n,key);
				break;
				case 4:
					heap.buildMaxHeap(arr,n);
				break;				
			}
		}while(c !=5);
	}
}
