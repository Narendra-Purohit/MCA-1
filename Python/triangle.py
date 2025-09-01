rows = input("Enter number of rows: ")

if rows.isdigit():
    rows = int(rows)
    for i in range(rows):
        num = 1
        row = []
        for j in range(i + 1):
            row.append(num)
            num = num * (i - j) // (j + 1)
        print(" ".join([str(x) for x in row]))
else:
    print("Please enter a valid number only.")










"""
Start: num = 1

First iteration (j=0):
num = 1 * (0-0) // (0+1) = 4 

Next (j=1):
num = 4 * (1-1) // (1+1) = 6 

Next (j=2):
num = 6 * (2-2) // (2+1) = 4 

Next (j=3):
num = 4 * (3-3) // (3+1) = 1 

[1, 4, 6, 4, 1]."""
