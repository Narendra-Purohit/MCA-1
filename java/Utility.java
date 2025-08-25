/* 5.Create a class named ‘Utility’ with the following static methods:
1.public static long factorial (long value)
=> Returns the factorial of the given number as a long.
2.public static boolean isPrime(int value)
=>Returns true if the given number is prime; otherwise, returns false.
3.public static boolean isEven(long value)
=>Returns true if the given number is even; otherwise, returns false.
4.public static boolean isOdd(long value)
=>Returns true if the given number is odd; otherwise, returns false */

import java.util.Scanner;
public class Utility {

    public static long factorial(long value) {
        if (value < 0) 
            throw new IllegalArgumentException(" Factorial not defined for negative numbers: " + value);
        
        long fact = 1;
        for (long i = 1; i <= value; i++) fact *= i;
        return fact;
    }

    public static boolean isPrime(int value) {
        if (value < 2) 
            throw new IllegalArgumentException(" Prime check invalid for numbers less than 2: " + value);
        
        for (int i = 2; i <= Math.sqrt(value); i++) 
            if (value % i == 0) return false;
        
        return true;
    }

    public static boolean isEven(long value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(long value) {
        return value % 2 != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print(" Enter a number for factorial: ");
            long num1 = sc.nextLong();
            System.out.println(" Factorial of " + num1 + " = " + factorial(num1));

            System.out.print("\n Enter a number to check prime: ");
            int num2 = sc.nextInt();
            System.out.println(" Is " + num2 + " prime? " + isPrime(num2));

            System.out.print("\n Enter a number to check even/odd: ");
            long num3 = sc.nextLong();
            System.out.println("Is " + num3 + " even? " + isEven(num3));
            System.out.println(" Is " + num3 + " odd? " + isOdd(num3));

        } 
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Unexpected Error: Please enter valid input.");
        }
        finally {
            sc.close();
        }
    }
}
