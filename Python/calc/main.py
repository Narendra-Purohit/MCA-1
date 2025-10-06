from calculator import factorial, power, logarithm, square


n = int(input("Enter number for factorial: "))
print("Factorial:", factorial(n))

base = float(input("Enter base: "))
exp = int(input("Enter exponent: "))
print("Power:", power(base, exp))

val = float(input("Enter value for log: "))
base_input = input("Enter base (leave blank for natural log): ").strip()
if base_input == "":
    print("Log:", logarithm(val))
else:
    print("Log:", logarithm(val, float(base_input)))

x = float(input("Enter number to square: "))
print("Square:", square(x))

