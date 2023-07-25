// Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array Before insertion: " + Arrays.toString(arr));

		SortArray sa = new SortArray();
		sa.selectionSort(arr);

    }
}
class SortArray{
	public void selectionSort(int []arr) {
		Scanner sc = new Scanner(System.in);
		
		int minIndex = 0, temp=0;
		int [] a = new int[arr.length+1];
				
		for(int i=0;i<(arr.length-1);i++) {
			minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]) {
					minIndex = j;
				}
				
			}
			temp =arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] =temp;
		}

		System.out.println("New sorted array is : "+Arrays.toString(arr) );
		for(int i=0;i<arr.length;i++) {
			System.out.println("At index "+i+" element is "+  arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			a[i]=arr[i];
		}
		
		
		int index, x;
		System.out.println("Enter the index where you want to insert the value according to sorted array : ");
		index = sc.nextInt();
		System.out.println("Enter new value : ");
		x = sc.nextInt();

        Insertion in = new Insertion();
        in.insertElement(a, x, index);
		
	}
}
class Insertion{
    public static void insertElement(int[] a, int element, int index) {
        for(int i = a.length-1; i>=index; i--) {
			if(i == index) {
				a[i] = element;
			}else {
				a[i] = a[i-1];
			}
		}

        System.out.println("Array after insertion: " + Arrays.toString(a));
    }
}
