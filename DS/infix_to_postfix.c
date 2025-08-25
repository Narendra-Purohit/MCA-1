#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define SIZE 100

char stack[SIZE];
int top = -1;

void push(char ch) {
    if (top < SIZE - 1)
        stack[++top] = ch;
    else
        printf("Stack Overflow\n");
}

char pop() {
    if (top >= 0)
        return stack[top--];
    else {
        printf("Stack Underflow\n");
        return '#'; 
    }
}

char peek() {
    return (top >= 0) ? stack[top] : '#';
}

int isEmpty() {
    return top == -1;
}

int precedence(char op) {
    switch (op) {
        case '^': return 3;
        case '*': case '/': return 2;
        case '+': case '-': return 1;
        default: return 0;
    }
}

void infixToPostfix(char *infix, char *postfix) {
    int i = 0, j = 0;
    char ch;

    while ((ch = infix[i++]) != '\0') {
        if (isalnum(ch)) {
            postfix[j++] = ch;
        } else if (ch == '(') {
            push(ch);
        } else if (ch == ')') {
            while (!isEmpty() && peek() != '(')
                postfix[j++] = pop();
            if (!isEmpty()) pop(); // discard '('
        } else {
            while (!isEmpty() && precedence(peek()) >= precedence(ch))
                postfix[j++] = pop();
            push(ch);
        }
    }

    while (!isEmpty())
        postfix[j++] = pop();

    postfix[j] = '\0';
}

int main() {
    char infix[SIZE], postfix[SIZE];

    printf(" Enter infix expression (no spaces): ");
    scanf("%s", infix);

    infixToPostfix(infix, postfix);

    printf(" Postfix expression: %s\n", postfix);

    return 0;
}