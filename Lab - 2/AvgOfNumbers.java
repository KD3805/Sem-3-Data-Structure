 //. Write a program to calculate average of first n numbers.

import java.util.Scanner;

class AvgOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int n = sc.nextInt();

		Avg av = new Avg();
		double ans = av.calcAvg(n);

		System.out.println("Average of first "+n+" numbers = "+ans);
	}
}
class Avg{
	public static double calcAvg(int n){
		int sum = 0;
		for(int i=1; i<=n; i++){
			sum += i;
		}
		return (sum/n);
	}
}