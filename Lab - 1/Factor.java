import java.util.Scanner;

class Factor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int n = sc.nextInt();

		FindFactor fn = new FindFactor();
		fn.factor(n);

	}
}
class FindFactor{
	public static void factor(int n) {
		System.out.println("Factor of "+n+" are...");

		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				System.out.print(i+" ");
			}
		}
	}
}