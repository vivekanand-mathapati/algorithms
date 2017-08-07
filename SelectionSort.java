import java.util.*;

class SelectionSort{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Array size: ");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.print("Array elemts: ");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		selectionSort(arr,n);
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}
	static void selectionSort(int[] arr,int n){
		for(int i=0;i<n-1;i++){
			int pos = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[i]){
					pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
	}
}
