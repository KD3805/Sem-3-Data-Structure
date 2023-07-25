// Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the Array 1: ");
        int size1 = scanner.nextInt();

        int[] arr1 = new int[size1];

        System.out.println("Enter " + size1 + " numbers:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the Array 2: ");
        int size2 = scanner.nextInt();

        int[] arr2 = new int[size2];

        System.out.println("Enter " + size2 + " numbers:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        Merge ma = new Merge();
        int[] mergedArray = ma.mergeArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

    }
}
class Merge{
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] mergedArray = new int[length1 + length2];

        for (int i = 0; i < length1; i++) {
            mergedArray[i] = array1[i];
        }

        for (int i = 0; i < length2; i++) {
            mergedArray[length1 + i] = array2[i];
        }

        return mergedArray;
    }
}