/* 4.Write a Java program that contains two arrays of two dimensions that hold data of matrix and perform matrix operation like addition, subtraction, and multiplication etc. E.g.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of rows: ");
            int rows = sc.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = sc.nextInt();

            if (rows != cols) {
                System.out.println("Error: Rows and columns must be equal for multiplication.");
                return;
            }

            int[][] A = new int[rows][cols];
            int[][] B = new int[rows][cols];
            int[][] add = new int[rows][cols];
            int[][] sub = new int[rows][cols];
            int[][] mul = new int[rows][cols];
            int[][] div = new int[rows][cols];

            System.out.println("Enter Matrix A:");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    A[i][j] = sc.nextInt();

            System.out.println("Enter Matrix B:");
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    B[i][j] = sc.nextInt();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    add[i][j] = A[i][j] + B[i][j];
                    sub[i][j] = A[i][j] - B[i][j];
                    div[i][j] = (B[i][j] != 0) ? A[i][j] / B[i][j] : 0;
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mul[i][j] = 0;
                    for (int k = 0; k < cols; k++) {
                        mul[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            System.out.println("\nAddition (A+B):");
            print(add);

            System.out.println("Subtraction (A-B):");
            print(sub);

            System.out.println("Multiplication (A×B):");
            print(mul);

            System.out.println("Division (A/B):");
            print(div);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } finally {
            sc.close();
        }
    }

    static void print(int[][] m) {
        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
}
