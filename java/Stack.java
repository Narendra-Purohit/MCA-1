
/* 8.Create a class named Stack with the following specifications:
•Constructors:
>Define constructors to initialize the stack (e.g., default constructor, constructor to specify the stack's size).
•Methods:
1.public void push(int value) Adds an integer value to the stack.
2.public int pop() Removes and returns the top value from the stack.
3.public void traverse() Traverses and prints all the elements in the stack.*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Stack {
    private int[] stackarray;
    private int top;
    private int capacity;

    public Stack() {
        capacity = 10;
        stackarray = new int[capacity];
        top = -1;
    }

    public Stack(int size) {
        capacity = size;
        stackarray = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack is overflow, can't push " + value);
        } else {
            stackarray[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is underflow");
            return -1;
        } else {
            return stackarray[top--];
        }
    }

    public void traverse() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; --i)
                System.out.println(stackarray[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        int size = sc.nextInt();
        Stack s = new Stack(size);

        int choice = 0;
        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Traverse");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int val = sc.nextInt(); 
                        s.push(val);
                        break;
                    case 2:
                        int popped = s.pop();
                        if (popped != -1) {
                            System.out.println("Popped: " + popped);
                        }
                        break;
                    case 3:
                        s.traverse();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Error: Only integer values allowed!");
                sc.nextLine(); 
            }
        } while (choice != 4);

        sc.close();
    }
}
