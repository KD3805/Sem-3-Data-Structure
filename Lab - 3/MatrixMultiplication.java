/*
		 * 21. Read two matrices, first 3x2 and second 2x3, perform multiplication operation 
    	   and store result in third matrix and print it.
*/
		
import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		int [][]a ;
		int [][]b;
		int r1 =0 , c1=0, r2=0, c2=0;
		System.out.println("Enter the number of rows of first matrix :");
		r1 =sc.nextInt();		
		System.out.println("Enter the number of columns of first matrix:");
		c1 = sc.nextInt();
		
		System.out.println("Enter the number of rows of second matrix :");
		r2 =sc.nextInt();		
		System.out.println("Enter the number of columns of second matrix :");
		c2 = sc.nextInt();
		if(c1 != r2) {
			System.out.println("Given sets of row and colums does not follow rules of matrix multiplication.");
		}
		else {
			a = new int[r1][c1];
			b =  new int[r2][c2];
			
			System.out.println("Enter the value of first matrix (row wise) : ");
			for(int i=0;i<r1;i++) {
			    System.out.println("row "+(i+1)+" : ");
				for(int j=0;j<c1;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("Enter the value of second matrix (row wise) : ");
			for(int i=0;i<r2;i++) {
				
				System.out.println("row "+(i+1)+" : ");
				
				for(int j=0;j<c2;j++) {
					b[i][j] = sc.nextInt();
				}
			}
			Multiplication mp = new Multiplication();
			mp.multiplication(a, b);
		}

	}

}
class Multiplication{
	public void multiplication(int [][]a, int [][]b) {
		int temp = 0, sum =0;
		int [][] c = new int[a.length][b[0].length];
		
		for(int i=0; i<a.length; i++) {
			sum =0;
			for(int j=0; j<b[0].length; j++) {
				temp = a[i][j] * b[j][i];
				sum = sum + temp;				
			}
			
			for(int j=0; j<b[0].length; j++) {
				c[i][j] =sum;
			}
		}
		
		System.out.println("Multiplication of given matries is :");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b[0].length; j++) {
				System.out.print(" "+c[i][j]);
			}			
			System.out.println("");
		}
	}
}

