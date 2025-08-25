# electricity_bill.py

try:
    units = float(input("Enter electricity units consumed: "))

    if units < 0:
        raise ValueError("Units cannot be negative.")

    if units <= 100:
        rate = 3
    elif units <= 300:
        rate = 5
    elif units <= 500:
        rate = 7
    else:
        rate = 10

    total = units * rate

    print("\nElectricity Bill Summary")
    print("-" * 30)
    print(f"Units Consumed : {units:.1f}")
    print(f"Rate Applied   : ₹{rate} per unit")
    print(f"Total Bill     : ₹{total:.2f}")

except ValueError as ve:
    print("Error:", ve)
