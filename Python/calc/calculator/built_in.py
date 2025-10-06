import math

def factorial(n):
    """Recursive factorial"""
    if n < 0:
        raise ValueError("Factorial is not defined for negative numbers")
    if n in (0, 1):
        return 1
    return n * factorial(n - 1)

def power(base, exponent=2):
    """Recursive power function with default exponent 2"""
    if exponent == 0:
        return 1
    elif exponent < 0:
        return 1 / power(base, -exponent)
    else:
        return base * power(base, exponent - 1)

def logarithm(value, base=math.e):
    """Logarithm with default base e"""
    if value <= 0:
        raise ValueError("Logarithm undefined for zero or negative values")
    if base <= 0 or base == 1:
        raise ValueError("Invalid base for logarithm")
    return math.log(value, base)

def sin(x):
    return math.sin(x)

def cos(x):
    return math.cos(x)

def tan(x):
    return math.tan(x)
