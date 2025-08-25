#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};
struct Node *head = NULL;

int getInt() {
    int val; char ch;
    if (scanf("%d", &val) != 1) {
        while ((ch = getchar()) != '\n' && ch != EOF);
        printf("Invalid input! Only integers allowed.\n");
        return -99999;
    }
    return val;
}

void insert() {
    printf("Enter value: ");
    int val = getInt(); if (val == -99999) return;
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    if (head == NULL) {
        head = newNode; newNode->next = head;
    } else {
        struct Node *temp = head;
        while (temp->next != head) temp = temp->next;
        temp->next = newNode; newNode->next = head;
    }
    printf("Inserted %d\n", val);
}

void delete() {
    if (head == NULL) { printf("List empty!\n"); return; }
    printf("Enter value to delete: ");
    int val = getInt(); if (val == -99999) return;
    struct Node *temp = head, *prev = NULL;
    if (head->data == val) {
        struct Node *last = head;
        while (last->next != head) last = last->next;
        if (head->next == head) { free(head); head = NULL; }
        else { last->next = head->next; free(head); head = last->next; }
        printf("Deleted %d\n", val); return;
    }
    do {
        prev = temp; temp = temp->next;
        if (temp->data == val) {
            prev->next = temp->next; free(temp);
            printf("Deleted %d\n", val); return;
        }
    } while (temp != head);
    printf("Value not found!\n");
}

void modify() {
    if (head == NULL) { printf("List empty!\n"); return; }
    printf("Enter value to modify: ");
    int oldVal = getInt(); if (oldVal == -99999) return;
    printf("Enter new value: ");
    int newVal = getInt(); if (newVal == -99999) return;
    struct Node *temp = head;
    do {
        if (temp->data == oldVal) { temp->data = newVal;
            printf("Modified %d -> %d\n", oldVal, newVal); return; }
        temp = temp->next;
    } while (temp != head);
    printf("Value not found!\n");
}

void display() {
    if (head == NULL) { printf("List empty!\n"); return; }
    struct Node *temp = head;
    printf("List: ");
    do { printf("%d ", temp->data); temp = temp->next; } while (temp != head);
    printf("\n");
}

int main() {
    int choice;
    while (1) {
        printf("\n1.Insert 2.Delete 3.Modify 4.Display 5.Exit: ");
        choice = getInt(); if (choice == -99999) continue;
        switch (choice) {
            case 1: insert(); break;
            case 2: delete(); break;
            case 3: modify(); break;
            case 4: display(); break;
            case 5: exit(0);
            default: printf("Invalid choice!\n");
        }
    }
    return 0;
}
