#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Student {
    int roll;
    char name[50];
    float marks;
    struct Student *next, *prev;
};

struct Student *head = NULL;

int getInt() {
    int x;
    while (scanf("%d", &x) != 1) {
        printf("Invalid input! Enter number: ");
        while(getchar()!='\n');
    }
    return x;
}

float getFloat() {
    float x;
    while (scanf("%f", &x) != 1) {
        printf("Invalid input! Enter marks: ");
        while(getchar()!='\n');
    }
    return x;
}

void insert() {
    struct Student *newNode = (struct Student*)malloc(sizeof(struct Student));
    printf("Enter Roll: "); newNode->roll = getInt();
    printf("Enter Name: "); scanf("%s", newNode->name);
    printf("Enter Marks: "); newNode->marks = getFloat();

    if(head==NULL) {
        head = newNode;
        head->next = head->prev = head;
    } else {
        struct Student *last = head->prev;
        last->next = newNode;
        newNode->prev = last;
        newNode->next = head;
        head->prev = newNode;
    }
    printf("Inserted!\n");
}

void display() {
    if(head==NULL) { printf("List Empty!\n"); return; }
    struct Student *temp = head;
    printf("\n--- Student List ---\n");
    do {
        printf("Roll: %d | Name: %s | Marks: %.2f\n", temp->roll, temp->name, temp->marks);
        temp = temp->next;
    } while(temp != head);
}

void delete() {
    if(head==NULL) { printf("List Empty!\n"); return; }
    printf("Enter Roll to delete: ");
    int r = getInt();
    struct Student *temp = head;
    do {
        if(temp->roll == r) {
            if(temp->next == temp) head=NULL;
            else {
                temp->prev->next = temp->next;
                temp->next->prev = temp->prev;
                if(temp==head) head=temp->next;
            }
            free(temp);
            printf("Deleted!\n");
            return;
        }
        temp = temp->next;
    } while(temp != head);
    printf("Not Found!\n");
}

void modify() {
    if(head==NULL) { printf("List Empty!\n"); return; }
    printf("Enter Roll to modify: ");
    int r = getInt();
    struct Student *temp = head;
    do {
        if(temp->roll == r) {
            printf("Enter new Name: "); scanf("%s", temp->name);
            printf("Enter new Marks: "); temp->marks = getFloat();
            printf("Modified!\n");
            return;
        }
        temp = temp->next;
    } while(temp != head);
    printf("Not Found!\n");
}

int main() {
    int ch;
    while(1) {
        printf("\n1.Insert 2.Delete 3.Modify 4.Display 5.Exit\nEnter choice: ");
        ch = getInt();
        switch(ch) {
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
