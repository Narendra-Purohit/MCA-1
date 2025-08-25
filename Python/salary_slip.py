'''Employee Salary Slip Generator
Create a program that accepts an employee's name (string), ID (integer), basic salary (float), and bonus percentage (float).
Calculate the total salary using numeric operations and print a formatted salary slip using string formatting techniques. '''

try:
    name = input("Enter Employee Name: ")
    emp_id = input("Enter Employee Id: ")
    basic_salary = float(input("Enter Basic Salary: "))
    bonus_percent = float(input("Enter Bonus Percent: "))

    bonus_amount = (bonus_percent / 100) * basic_salary
    total_salary = basic_salary + bonus_amount

    print("\n" + "="*30)
    print("      Employee Salary Slip     ")
    print("="*30)
    print(f"Employee Name   : {name}")
    print(f"Employee ID     : {emp_id}")
    print(f"Basic Salary    : {basic_salary:.2f}")
    print(f"Bonus ({bonus_percent}%) : {bonus_amount:.2f}")
    print("-"*30)
    print(f"Total Salary    : {total_salary:.2f}")
    print("-"*30 )

except ValueError:
    print("\n Invalid input! Please enter numbers for Salary and Bonus Percent.")

except Exception as e:
    print("\n Something went wrong:", e)
