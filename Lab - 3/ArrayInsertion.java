// Write a program to insert a number at a given location in an array.

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsertion {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = { 0, 1 };
    jenish jn = new jenish(3);
    System.out.println(jn.get(2));
    jn.insert(3);
    jn.insert(5);
    jn.insert(4);
    jn.insert(6);
    System.out.println(jn.get(2));
    jn.insert(7);
    jn.print();
    // Scanner scanner = new Scanner(System.in);

    // System.out.print("Enter the size of the array: ");
    // int size = scanner.nextInt();

    // int[] arr = new int[size];

    // System.out.println("Enter " + size + " numbers:");
    // for (int i = 0; i < size; i++) {
    //     arr[i] = scanner.nextInt();
    // }

    // System.out.println("Array Before insertion: " + Arrays.toString(arr));

    // Insertion in = new Insertion();
    // in.insertElement(arr, size);
    // in.insertElement(arr, size);

  }
}

class Insertion {

  public static void insertElement(int[] arr, int size) {
    Scanner scanner = new Scanner(System.in);

    int[] newArr = new int[size + 1];

    // Copy all the Elements of old Array and Create a new Array with one Extra size
    for (int i = 0; i < size; i++) {
      newArr[i] = arr[i];
    }

    System.out.print("Enter the number to be inserted: ");
    int number = scanner.nextInt();

    System.out.print("Enter the location (index) to insert the number: ");
    int index = scanner.nextInt();

    // Shift elements to the right to create space for the new number
    for (int i = size; i > index; i--) {
      newArr[i] = newArr[i - 1];
    }

    newArr[index] = number;

    System.out.println("Array after insertion: " + Arrays.toString(newArr));
  }
}

class jenish {

  private int[] nums;
  int top = -1;

  jenish(int n) {
    nums = new int[n];
  }

  jenish(int[] nums) {
    this.nums = nums;
    top = nums.length - 1;
  }

  void insert(int x) {
    if (top == nums.length - 1) {
      System.out.println("buffered");
      int[] temp = new int[nums.length + 5];
      int i;
      top++;
      for (i = 0; i < nums.length; i++) {
        temp[i] = nums[i];
      }
      temp[i] = x;
      nums = temp;
    } else {
      System.out.println("space array");
      top++;
      nums[top] = x;
    }
  }

  void print() {
    for (int i = 0; i <= top; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  int get(int ind) {
    if (ind > top || ind < 0) {
      System.out.println("Element not found");
      return 0;
    }
    return nums[ind];
  }
}
