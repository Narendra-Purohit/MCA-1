/* 8.Create a class named Stack with the following specifications:
•Constructors:
>Define constructors to initialize the stack (e.g., default constructor, constructor to specify the stack's size).
•Methods:
1.public void push(int value) Adds an integer value to the stack.
2.public int pop() Removes and returns the top value from the stack.
3.public void traverse() Traverses and prints all the elements in the stack.*/

public class Stack {
    private int[] stackarray;
    private int top;
    private int capacity;


    public Stack(){
        capacity = 10;
        stackarray = new int[capacity];
        top = -1;
    }
    public Stack(int size){
        capacity = size;
        stackarray = new int[capacity];
        top = -1;

    }
    public void push(int value){
        if(top==capacity-1){
            System.out.println("stack is overflow cant push"+value);
        }else{
            stackarray[++top]=value;
            System.out.println(value + " pushed to stack");

        }

    }
    public int pop(){
        if (top == -1){
            System.out.println("stack is underflow");
            return -1;
        }else{
           return stackarray[top--];
        }

    }
    public void traverse(){
        if (top == -1){
            System.out.println("Stack is empty");
        }else{
            for(int i = top; i >= 0;--i)
            System.err.println("in stack element "+stackarray[i]);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(10);
        s.push(30);
        s.push(20);
        s.push(40);
        s.push(50);
        s.push(60);
        s.traverse();

        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        s.traverse();

        
    }
    
} 

