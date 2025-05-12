/*
		 * 21. Read two matrices, first 3x2 and second 2x3, perform multiplication operation 
    	   and store result in third matrix and print it.
*/
		
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define matrix dimensions
        int rows1 = 3, cols1 = 2;  // First matrix: 3x2
        int rows2 = 2, cols2 = 3;  // Second matrix: 2x3
        
        // Create matrices
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] result = new int[rows1][cols2];
        
        // Input first matrix
        System.out.println("Enter elements of first matrix (3x2):");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print("Enter element at position [" + (i+1) + "][" + (j+1) + "]: ");
                matrix1[i][j] = sc.nextInt();
            }
        }
        
        // Input second matrix
        System.out.println("\nEnter elements of second matrix (2x3):");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print("Enter element at position [" + (i+1) + "][" + (j+1) + "]: ");
                matrix2[i][j] = sc.nextInt();
            }
        }
        
        // Perform matrix multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        // Display result
        System.out.println("\nResultant Matrix (3x3):");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}

