/* 3.Write a program that accepts a string and a character as input. The program should print the frequency of the character in the string and list all the positions (indices) where the
character appears.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException("String cannot be empty!");
            }

            System.out.print("Enter a character to search: ");
            String charInput = sc.next();

            if (charInput.length() != 1) {
                throw new IllegalArgumentException("Please enter exactly one character!");
            }

            char ch = charInput.charAt(0);
            int count = 0;

            System.out.print("Positions: ");
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ch) {
                    System.out.print(i + " ");
                    count++;
                }
            }

            System.out.println("\nFrequency: " + count);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
