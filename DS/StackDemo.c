#include <stdio.h>  

#define MAX 10

int stack[MAX], top = -1;

void push(int v) {
    if (top == MAX - 1)
        puts("Overflow");
    else 

        stack[++top] = v;
}

int pop() {
    if (top == -1) {
        puts("Underflow");
        return -1;
    }
    return stack[top--];
}

void display() {
    if (top == -1)
        puts("Empty");
    else {
        for (int i = top; i >= 0; i--)
            printf("%d ", stack[i]);
        puts("");  
    }
}

int main() {
    int c, v;
    for (;;) {
        printf("1.Push 2.Pop 3.Display 4.Exit: ");
        scanf("%d", &c);
        
        if (c == 1) {
            printf("Enter value to push: ");
            scanf("%d", &v);
            push(v);
        }
        else if (c == 2) {
            int val = pop();
            if (val != -1)
                printf("Popped: %d\n", val);
        }
        else if (c == 3) {
            display();
        }
        else if (c == 4) {
            break;
        }
        else {
            puts("Invalid");
        }
    }
    return 0;
