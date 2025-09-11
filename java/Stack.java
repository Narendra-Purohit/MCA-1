
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
