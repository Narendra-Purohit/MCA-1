courses = {
    "DS102": {"details": ("DS102", "Dr. Mehta"), "students": set()},
    "PY103": {"details": ("PY103", "Dr.Ajay Parikh"), "students": set()},
    "DBMS104": {"details": ("DBMS104", "Dr.Dhirenbhai"), "students": set()}
}
course_map = {
    "DS102": "DS102",
    "PY103": "PY103",
    "DBMS104": "DBMS104"
}

def add_student(user_code, student_name):
    try:
        if not student_name.isalpha():
            raise ValueError("Student name must only contain letters.")
        if user_code not in course_map:
            raise KeyError("Invalid course code.")
        
        course_code = course_map[user_code]  

        if student_name in courses[course_code]["students"]:
            print(f"'{student_name}' is already enrolled in {user_code}")
        else:
            courses[course_code]["students"].add(student_name)
            print(f"Added '{student_name}' to {user_code}")
    except ValueError as ve:
        print("Error:", ve)
    except KeyError as ke:
        print("Error:", ke)

def display_courses():
    for code, data in courses.items():
        print(f"Course: {data['details']}")
        print(f"Students: {data['students']}\n")

while True:
    try:
        print("\n1. Add Student")
        print("2. Display Courses")
        print("3. Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            course = input("Enter Course Code (DS102/PY103/DBMS104): ").strip().upper()
            name = input("Enter Student Name: ").strip().title()
            add_student(course, name)
        elif choice == 2:
            display_courses()
        elif choice == 3:
            print("Exiting...")
            break
        else:
            print("Invalid choice, please try again.")
    except ValueError:
        print("Please enter a valid number (1-3).")
