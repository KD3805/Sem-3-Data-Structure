/*Read n numbers in an array then read two different numbers, replace 1st
number with 2nd number in an array and print its index and final array. */

import java.util.Scanner;

public class ArrayReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Replacement rp = new Replacement();
        rp.replaceNumbers(arr, size);
    }
}
class Replacement {
    public static void replaceNumbers(int[] numbers, int size) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        // Find the index of the first number in the array

        // Linear Search
        // for (int i = 0; i < size; i++) {
        //     if (numbers[i] == firstNumber) {
        //         index = i;
        //         break;
        //     }
        // }

        // Binary Search
        int index = -1;
        int low = 0, mid = 0;
        int high = numbers.length - 1;

        while (high > low) {
            mid = (high + low) / 2;

            if (firstNumber < numbers[mid]) {
                high = mid - 1;
            }

            else if (firstNumber == numbers[mid]) {
                index = mid;
                break;
            }

            else {
                low = mid + 1;
            }
        }

        // Replace the first number with the second number if it exists in the array
        if (index != -1) {
            numbers[index] = secondNumber;
            System.out.println("Index: " + index);
        }
        else{
            System.out.println(firstNumber+" does not exist in Array!");
        }

        System.out.println("Final Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
