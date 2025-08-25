#include <stdio.h>
#define SIZE 5

int cq[SIZE], front = -1, rear = -1;

void insert() {
    int val;
    if ((front == 0 && rear == SIZE - 1) || (rear + 1) % SIZE == front) {
        printf("Overflow\n");
        return;
    }
    printf("Value: ");
    scanf("%d", &val);
    if (front == -1) front = rear = 0;
    else rear = (rear + 1) % SIZE;
    cq[rear] = val;
}

void delete() {
    if (front == -1) {
        printf("Underflow\n");
        return;
    }
    printf("Deleted: %d\n", cq[front]);
    if (front == rear) front = rear = -1;
    else front = (front + 1) % SIZE;
}

void modify() {
    int pos, val, count = 0, i = front;
    if (front == -1) {
        printf("Empty\n");
        return;
    }
    printf("Position (1 to %d): ", (rear >= front) ? rear - front + 1 : SIZE - front + rear + 1);
    scanf("%d", &pos);
    if (pos <= 0) { printf("Invalid Position\n"); return; }
    while (count < pos - 1) { i = (i + 1) % SIZE; count++; if (i == (rear + 1) % SIZE) { printf("Invalid\n"); return; } }
    printf("New Value: "); scanf("%d", &val);
    cq[i] = val;
}

void display() {
    if (front == -1) {
        printf("Empty\n");
        return;
    }
    int i = front;
    while (1) {
        printf("%d ", cq[i]);
        if (i == rear) break;
        i = (i + 1) % SIZE;
    }
    printf("\n");
}

int main() {
    int ch;
    while (1) {
        printf("\n1.Insert 2.Delete 3.Modify 4.Display 5.Exit: ");
        scanf("%d", &ch);
        if (ch == 1) insert();
        else if (ch == 2) delete();
        else if (ch == 3) modify();
        else if (ch == 4) display();
        else if (ch == 5) break;
        else printf("Invalid Choice\n");
    }
    return 0;
}
