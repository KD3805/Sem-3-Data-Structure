// Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsertion {
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

        Insertion in = new Insertion();
        in.insertElement(arr, size);

    }
}
class Insertion{
    public static void insertElement(int[] arr, int size) {
        Scanner scanner = new Scanner(System.in);
        
        int[] newArr = new int[size+1];

        // Copy all the Elements of old Array and Create a new Array with one Extra size
        for(int i=0; i<size; i++){
            newArr[i] = arr[i];
        }

        System.out.print("Enter the number to be inserted: ");
        int number = scanner.nextInt();

        System.out.print("Enter the location (index) to insert the number: ");
        int index = scanner.nextInt();

        // Shift elements to the right to create space for the new number
        for (int i = size ; i > index; i--) {
            newArr[i] = newArr[i - 1];
        }

        newArr[index] = number;

        System.out.println("Array after insertion: " + Arrays.toString(newArr));
    }
}
