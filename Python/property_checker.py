'''Number Property Checker and Comparator
Write a program that accepts two integers from the user.
Perform and display the results of the following:
=> Assignment and arithmetic operations (=, +=, +, -, *, /)
=> Comparison (==, !=, >, <)
=> Bitwise operations (&, |, ^)
=> Membership test (check if numbers  are n a predefined
list) (in, not in)
=> Identity test (check if both variables reference the same
object) (is, is not)'''

try:
    a = int(input("Enter first number (a): "))
    b = int(input("Enter second number (b): "))

    num_list = [10, 20, 30, 40, 50]

    print("\n=== Assignment and Arithmetic Operations ===")
    x = a
    print("x = a →", x)
    x += b
    print("x += b →", x)
    print("a + b =", a + b)
    print("a - b =", a - b)
    print("a * b =", a * b)

    try:
        print("a / b =", a / b)
    except ZeroDivisionError:
        print("a / b =  Undefined (division by zero)")

    print("\n=== Comparison Operations ===")
    print("a == b →", a == b)
    print("a != b →", a != b)
    print("a > b  →", a > b)
    print("a < b  →", a < b)

    print("\n=== Logical Operations ===")
    print("a > 0 and b > 0 →", a > 0 and b > 0)
    print("a > 0 or b > 0 →", a > 0 or b > 0)
    print("not(a > 0) →", not (a > 0))

    print("\n=== Bitwise Operations ===")
    print("a & b →", a & b)
    print("a | b →", a | b)
    print("a ^ b →", a ^ b)

    print("\n=== Membership Test ===")
    print("a in num_list →", a in num_list)
    print("b not in num_list →", b not in num_list)

    print("\n=== Identity Test ===")
    print("a is b →", a is b)
    print("a is not b →", a is not b)

except ValueError:
    print("Invalid input! Please enter only integers.")
