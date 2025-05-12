 //Write a program to find whether the array contains a duplicate number or not.

import java.util.Scanner;

class Duplicate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many Numbers do you want to enter? = ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.println(arr);

		FindDuplicate fd = new FindDuplicate();
		fd.isDuplicate(arr);
	}
}
class FindDuplicate {
	public static void isDuplicate(int[] a){
		Scanner sc = new Scanner(System.in);
		System.out.println("Scan Elements...");

		for(int i=0; i<a.length; i++){
			System.out.print("Enter "+i+" index element = ");
			a[i] = sc.nextInt();
		}

		boolean flag = false;
		for(int i=0; i<a.length; i++){
			for(int j=(i+1); j<a.length; j++){
				if(a[i]==a[j]){
					flag = true;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("Array contains duplicate elements.");
		}
		else{
			System.out.println("Array does not contain duplicate elements.");
		}
	}
}