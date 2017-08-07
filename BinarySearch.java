import java.util.*;
import java.io.*;

class BinarySearch{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Size of the array: ");
		int n = in.nextInt();
		System.out.print("Array elements: ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}		
		System.out.print("Key: ");
		int key = in.nextInt();
		if(binarySearch(arr,0,n-1,key))
			System.out.println("Key found");
		else
			System.out.println("Key not found");
	}
	static boolean binarySearch(int[] arr,int low,int high,int key){
		while(low <= high){
			int mid = (low+high)/2;
			if(key == arr[mid])
				return true;
			if(key < arr[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		return false;
	}
}

