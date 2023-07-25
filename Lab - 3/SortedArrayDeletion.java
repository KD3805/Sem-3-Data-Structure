 // Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array Before Deletion: " + Arrays.toString(arr));

        SortArray sa = new SortArray();
		arr = sa.selectionSort(arr);

        Deletion del = new Deletion();
        del.deleteElement(arr, size);

    }
}
class SortArray{
	public int[] selectionSort(int[] arr) {
		Scanner sc = new Scanner(System.in);
		
		int minIndex = 0, temp=0;

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
		
        return arr;
	}
}
class Deletion{
    public static void deleteElement(int[] arr, int size) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the location (index) to insert the number: ");
        int index = sc.nextInt();
        
        int[] newArr = new int[size-1];
        int newIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            newArr[newIndex] = arr[i];
            newIndex++;
        }

        System.out.println("Array after Deletion: " + Arrays.toString(newArr));
    }
}
