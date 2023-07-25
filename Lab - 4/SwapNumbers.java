// Write a program to swap two numbers using user-defines method.

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        
        System.out.println("Before swapping...");
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        
        swapNumbers(num1, num2);
        
    }
    public static void swapNumbers(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping...");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
    }
}
