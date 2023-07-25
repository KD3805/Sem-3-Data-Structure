 //Write a program to find position of the smallest number from given n numbers.

import java.util.Scanner;

class SmallestNo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many Numbers do you want to enter? = ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		Minimum mn = new Minimum();
		int smPos = mn.minNumber(arr);

		System.out.println("Position of the smallest number from given "+n+" numbers = "+smPos);

	}
}
class Minimum{
	public static int minNumber(int[] a){
		Scanner sc = new Scanner(System.in);
		System.out.println("Scan Elements...");

		for(int i=0; i<a.length; i++){
			System.out.print("Enter "+i+" index element = ");
			a[i] = sc.nextInt();
		}
		int sm = a[0];
		int smInd = 0;
	
		for(int i=0; i<a.length; i++) {
			if(a[i] < sm) {
				sm = a[i];
				smInd = i;
			}
		}
		return smInd;
	} 
}