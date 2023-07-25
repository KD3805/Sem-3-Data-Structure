import java.util.Scanner;

class Prime{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int n = sc.nextInt();

		PrimeOrNot pr = new PrimeOrNot();
		pr.isPrime(n);
	}
}
class PrimeOrNot {
	public static void isPrime(int n) {
		boolean flag=true;

		for(int i=2; i<=n/2; i++) {
			if(n%i==0) {
				flag = false;
			}
		}

		if(flag) {
			System.out.println("Entered No. is Prime number");
		}
		else{
			System.out.println("Entered No. is not a Prime number");
		}
	}
}