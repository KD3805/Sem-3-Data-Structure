import java.util.Scanner;

class OddEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a No. : ");
		int n = sc.nextInt();

		OE oe = new OE();
		oe.check(n);
	}
}
class OE {
	public static void check(int n) {
		if(n%2==0) {
			System.out.println("Entered No. is Even");
		}
		else {
			System.out.println("Entered No. is Odd");
		}
	}
}