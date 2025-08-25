/* 7.Create a class named Circle with the following:
1.
Private Variables:
=> x (int) — x-coordinate of the center of the circle
=>y (int) — y-coordinate of the center of the circle
=>r (double) — radius of the circle
2.Constructors:
=>Define all possible constructors to initialize the circle’s properties (e.g., default constructor, parameterized constructor).
3.Methods:
=>public double area ()
   ▪Calculates and returns the area of the circle.
=>public double circumference () */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle {
    private int x;
    private int y;
    private double r;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.r = 1.0;
    }

    public Circle(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must be positive!");
        }
        this.x = 0;
        this.y = 0;
        this.r = r;
    }

    public Circle(int x, int y, double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must be positive!");
        }
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }

    public double circumference() {
        return 2 * Math.PI * r;
    }

    public void display() {
        System.out.println("Center = (" + x + ", " + y + ")");
        System.out.println("Radius = " + r);
        System.out.println("Area = " + area());
        System.out.println("Circumference = " + circumference());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c = null;

        while (c == null) {
            try {
                System.out.print("Enter x-coordinate: ");
                int x = sc.nextInt();

                System.out.print("Enter y-coordinate: ");
                int y = sc.nextInt();

                System.out.print("Enter radius: ");
                double r = sc.nextDouble();

                c = new Circle(x, y, r);
            } catch (InputMismatchException e) {
                System.out.println("Exception: Please enter numbers only!");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.println("\n=== Circle Details ===");
        c.display();
        sc.close();
    }
}
