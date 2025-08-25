#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insert(int val) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }
    newNode->data = val;
    newNode->next = NULL;
    if (head == NULL)
        head = newNode;
    else {
        struct Node *temp = head;
        while (temp->next != NULL)
            temp = temp->next;
        temp->next = newNode;
    }
    printf("Inserted %d\n", val);
}

void delete(int val) {
    if (head == NULL) {
        printf("List is Empty!\n");
        return;
    }
    struct Node *temp = head, *prev = NULL;
    while (temp != NULL && temp->data != val) {
        prev = temp;
        temp = temp->next;
    }
    if (temp == NULL) {
        printf("Value %d Not Found!\n", val);
        return;
    }
    if (prev == NULL)
        head = temp->next;
    else
        prev->next = temp->next;
    free(temp);
    printf("Deleted %d\n", val);
}

void modify(int oldVal, int newVal) {
    struct Node *temp = head;
    if (temp == NULL) {
        printf("List is Empty!\n");
        return;
    }
    while (temp != NULL && temp->data != oldVal)
        temp = temp->next;
    if (temp == NULL) {
        printf("Value %d Not Found!\n", oldVal);
        return;
    }
    temp->data = newVal;
    printf("Modified %d -> %d\n", oldVal, newVal);
}

void display() {
    if (head == NULL) {
        printf("List is Empty!\n");
        return;
    }
    struct Node *temp = head;
    printf("List: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int ch, val, newVal;
    while (1) {
        printf("\n1.Insert 2.Delete 3.Modify 4.Display 5.Exit: ");
        if (scanf("%d", &ch) != 1) {
            printf("Invalid Input!\n");
            exit(0);
        }
        if (ch == 1) {
            printf("Val: ");
            scanf("%d", &val);
            insert(val);
        } else if (ch == 2) {
            printf("Del Val: ");
            scanf("%d", &val);
            delete(val);
        } else if (ch == 3) {
            printf("Old: ");
            scanf("%d", &val);
            printf("New: ");
            scanf("%d", &newVal);
            modify(val, newVal);
        } else if (ch == 4) {
            display();
        } else if (ch == 5) {
            printf("Exiting...\n");
            break;
        } else {
            printf("Invalid Choice!\n");
        }
    }
    return 0;
}
