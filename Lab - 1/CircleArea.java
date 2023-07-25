import java.util.Scanner;

class CircleArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Radius of Circle : ");
		double rad = sc.nextDouble();

		CalcArea ca = new CalcArea();

		double area = ca.calcArea(rad);

		System.out.println("Area of Circle = "+area);
	}

}
class CalcArea {
	public static double calcArea(double r) {
		return Math.PI*r*r;
	}
}