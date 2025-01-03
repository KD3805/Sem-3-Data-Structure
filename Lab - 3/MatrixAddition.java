/*
	* 20. Read two 2x2 matrices and perform addition of matrices into third matrix and 
	  print it.
*/

import java.util.Scanner;

public class MatrixAddition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [][]a ;
		int [][]b;
		int r = 0 ,c = 0;
		System.out.println("Enter the number of rows :");
		r =sc.nextInt();
		
		System.out.println("Enter the number of columns :");
		c = sc.nextInt();
		
		a = new int[r][c];
		b =  new int[r][c];
		
		System.out.println("Enter the value of first matrix (row wise) : ");
		for(int i=0;i<r;i++) {
		    System.out.println("row "+(i+1)+" :");
			for(int j=0;j<c;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the value of second matrix (row wise) : ");
		for(int i=0;i<r;i++) {
			System.out.println("row "+(i+1)+" :");
			for(int j=0;j<c;j++) {
				b[i][j] = sc.nextInt();
			}
		}

		Addition add =new Addition();
		add.addMatrices(a, b);
	}

}
class Addition{
	public void addMatrices(int [][]a , int [][]b) {
		int [][]c = new int[a.length][a[0].length];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.println("a["+i+"]= "+a[i]);
				System.out.println("a["+i+"].length= "+a[i].length);

				c[i][j] = a[i][j] + b[i][j];
			}
			
		}
		System.out.println("After Addition, Resultant Matrix :");
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(" "+c[i][j]);
			}
			System.out.println("");
		}
	}
}

