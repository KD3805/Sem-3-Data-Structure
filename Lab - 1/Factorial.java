import java.util.Scanner;

class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int n = sc.nextInt();

		FindFactorial fn = new FindFactorial();
		int answer = fn.factorial(n);

		System.out.println("Factorial of "+n+" is "+answer);

	}
}
class FindFactorial{
	public static int factorial(int n) {
		int fact=1;

		for(int i=1; i<=n; i++) {
			fact *= i;
		}
		return fact;
	}
}