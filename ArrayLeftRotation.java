import java.io.*;
import java.util.*;

public class ArrayLeftRotation {
    static void leftRotation(int[] arr, int size, int shift){
		int output[] = new int[size];
		for(int i=0;i<size;i++){
			int pos = ((size-shift)+i)%size;
			output[pos] = arr[i];
		}
		for(int i=0;i<size;i++){
			System.out.print(output[i]+" ");
		}
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int shift = in.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
			arr[i] = in.nextInt();
		}
		leftRotation(arr,size,shift);
    }
}
