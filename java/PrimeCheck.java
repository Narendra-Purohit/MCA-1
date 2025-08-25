/* 1.Write a Java program that:
• Accepts an integer
• Prints whether it is prime
• Use for/while/ or do-while loops
• Uses if-else
• Demonstrate break and continue :*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int num = sc.nextInt();

            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(num + " is a Prime Number.");
            } else {
                System.out.println(num + " is NOT a Prime Number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer!");
        }

        sc.close();
    }
}
