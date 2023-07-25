import java.util.Scanner;

class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Base : ");
		int x = sc.nextInt();

		System.out.print("Enter Power : ");
		int y = sc.nextInt();

		FindPower fp = new FindPower();
		fp.calcPower(x,y);

	}
}
class FindPower{
	public static void calcPower(int x, int y) {
		int ans=1;

		for(int i=0; i<y; i++) {
			ans *= x;
		}

		System.out.println("Answer = "+ans);
	}
}