#include <stdio.h>
#define SIZE 100

int dq[SIZE], front = -1, rear = -1;

void insert() {
    int val, ch;
    printf("1.Front 2.Rear: ");
    scanf("%d", &ch);
    printf("Value: ");
    scanf("%d", &val);

    if ((ch == 1 && front == 0) || (ch == 2 && rear == SIZE - 1)) {
        printf("Overflow\n");
        return;
    }

    if (front == -1) front = rear = 0;
    else if (ch == 1) front--;
    else if (ch == 2) rear++;

    if (ch == 1) dq[front] = val;
    else dq[rear] = val;
}

void delete() {
    int ch;
    printf("1.Front 2.Rear: ");
    scanf("%d", &ch);

    if (front == -1) {
        printf("Underflow\n");
        return;
    }

    if (ch == 1) {
        printf("Deleted: %d\n", dq[front++]);
    } else {
        printf("Deleted: %d\n", dq[rear--]);
    }

    if (front > rear) front = rear = -1;
}

void modify() {
    int pos, val;
    printf("Position (%d to %d): ", front, rear);
    scanf("%d", &pos);
    if (pos < front || pos > rear) {
        printf("Invalid Position\n");
        return;
    }
    printf("New Value: ");
    scanf("%d", &val);
    dq[pos] = val;
}

void display() {
    if (front == -1) {
        printf("Empty\n");
        return;
    }
    for (int i = front; i <= rear; i++) {
        printf("%d ", dq[i]);
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
