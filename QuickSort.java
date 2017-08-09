import java.util.*;

class QuickSort{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Array size: ");
		int n = in.nextInt();
		System.out.print("Array elements: ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		quickSort(arr,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}
	public static void quickSort(int[] arr,int low, int high){
		if(low < high){
			int p = partition(arr,low,high);
			quickSort(arr,low,p-1);
			quickSort(arr,p+1,high);
		}
	}
	public static int partition(int[] arr,int low,int high){
		int pivot = arr[low];
		int i = low+1;
		int j = high;
		while(true){
			while(arr[i]<pivot && i<j)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}else{
				break;
			}
		}
		arr[low] = arr[j];
		arr[j] = pivot;
		return j;
	}
}
