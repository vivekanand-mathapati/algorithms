import java.util.*;

class MaximumSumSubArray{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Array size: ");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.print("Array elements: ");
		for(int i=0;i<size;i++){
			arr[i] = in.nextInt();
		}
		maxSubArray(arr,size);
	}
	static void maxSubArray(int arr[], int size){
		int max_so_far = Integer.MIN_VALUE;
		int max_end_here = 0;
		int start = 0, end = 0, s = 0;
		for(int i=0;i<size;i++){
			max_end_here += arr[i];
			if(max_so_far < max_end_here){
				max_so_far = max_end_here;
				start = s;
				end = i;
			}
			if(max_end_here < 0){
				max_end_here = 0;
				s = i+1;
			}
		}
		
		System.out.println("max sum: "+ max_so_far);
		System.out.println("max sub array: "+start+", "+end);		
	}
}
