//Write a program to read and display n numbers using an array.

import java.util.Scanner;

class ArrayDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Size of an Array : ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		Arr obj = new Arr();
		obj.readArr(arr);
		System.out.println();
		obj.displayArr(arr);

	}
}
class Arr{
	public static void readArr(int[] a){
		Scanner sc = new Scanner(System.in);
		System.out.println("Scan Array Elements...");

		for(int i=0; i<a.length; i++){
			System.out.print("Enter "+i+" index element = ");
			a[i] = sc.nextInt();
		}
	}

	public static void displayArr(int[] a){
		System.out.println("Display Array Elements...");

		for(int i=0; i<a.length; i++){
			System.out.print(i+" index element = "+a[i]);
		}
	}
}