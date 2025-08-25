#include <stdio.h>
#define SIZE 100

int q[SIZE], front = -1, rear = -1;

void insert(int val) {
    if (rear == SIZE - 1) printf("Overflow\n");
    else {
        if (front == -1) front = 0;
        q[++rear] = val;
    }
}

void delete() {
    if (front == -1 || front > rear) printf("Underflow\n");
    else {
        printf("Deleted: %d\n", q[front++]);
        if (front > rear) front = rear = -1;
    }
}

void modify(int pos, int val) {
    if (pos < front || pos > rear) printf("Invalid Position\n");
    else q[pos] = val;
}

void display() {
    if (front == -1) printf("Empty\n");
    else {
        for (int i = front; i <= rear; i++) printf("%d ", q[i]);
        printf("\n");
    }
}

int main() {
    int c, v, p;
    while (1) {
        printf("1.Insert 2.Delete 3.Modify 4.Display 5.Exit: ");
        scanf("%d", &c);
        if (c == 1) {
            printf("Value: "); scanf("%d", &v); insert(v);
        } else if (c == 2) delete();
        else if (c == 3) {
            printf("Position: "); scanf("%d", &p);
            printf("New Value: "); scanf("%d", &v);
            modify(p, v);
        } else if (c == 4) display();
        else if (c == 5) break;
        else printf("Invalid\n");
    }
    return 0;
}
