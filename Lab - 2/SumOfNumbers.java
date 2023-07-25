//Write a program to calculate sum of numbers from m to n.

import java.util.Scanner;

class SumOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Start Number : ");
		int m = sc.nextInt();

		System.out.print("Enter End Number : ");
		int n = sc.nextInt();

		Sum smn = new Sum();
		int ans = smn.calcSum(m,n);

		System.out.println("Sum of numbers from "+m+" to "+n+" = "+ans);
	}
}
class Sum{
	public static int calcSum(int m, int n){
		int sum = 0;
		for(int i=m; i<=n; i++){
			sum += i;
		}
		return sum;
	}
}