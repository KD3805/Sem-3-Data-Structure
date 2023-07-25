 // Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array Before Deletion: " + Arrays.toString(arr));

        Deletion del = new Deletion();
        del.deleteElement(arr, size);

    }
}
class Deletion{
    public static void deleteElement(int[] arr, int size) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the location (index) to remove the number: ");
        int index = scanner.nextInt();
        
        int[] newArr = new int[size-1];
        int newIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            newArr[newIndex] = arr[i];
            newIndex++;
        }

        System.out.println("Array after insertion: " + Arrays.toString(newArr));
    }
}
