import java.io.*;
import java.util.*;

class InsrtionSort{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		for(int i=0;i<n;i++){
			int j = i;
			int temp = arr[i];
			while(j>0 && temp < arr[j-1]){
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j] = temp;
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}
}
