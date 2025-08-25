/* 6.Define and Use a Class: Create a Student class with the following:
Fields: name (String), rollNo (int), marks (float)
Method: displayDetails(), This method should display the student's name, rollNo, and marks.
Instantiate an object of the student class and call the displayDetails() method. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    String name;
    int rollNo;
    float marks;

    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();

        try {
            System.out.print("Enter Student Name: ");
            s1.name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            s1.rollNo = sc.nextInt();

            System.out.print("Enter Marks: ");
            s1.marks = sc.nextFloat();

            s1.displayDetails();
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter correct data types! (Roll No = integer, Marks = float)");
        }
        sc.close();
    }
}
