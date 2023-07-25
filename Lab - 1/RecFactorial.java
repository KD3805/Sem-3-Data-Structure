import java.util.Scanner;

class RecFactorial {
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
		if(n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
}