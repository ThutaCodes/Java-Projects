**Course Enrollment and Grade Management System**

**Introduction**

I have built a Course Enrollment and Grade Management System using Java for a university. The goal is to enable students to enroll in courses, assign grades, and calculate overall course grades. To achieve this, I leveragedstatic methods and variables to efficiently manage enrollment and grades across multiple instances of the Student and Course classes. Additionally, the project will showcase how object state can be manipulated and behavior defined through instance methods.

**Student class:**  
This Java code defines a **Course** class that manages information about a course, including its code, name, maximum capacity, enrolled students, their grades, and credits. Let's break down the main components and functionalities:

**Class Attributes:**

- **courseCode**, **courseName**: Strings representing the code and name of the course.
- **maxCapacity**: Integer indicating the maximum number of students allowed in the course.
- **enrolledStudents**: Integer tracking the current number of enrolled students.
- **grades**: A HashMap mapping **Student** objects to their respective grades in this course.
- **credits**: A HashMap mapping **Student** objects to their respective credit values for this course.
- **totalEnrolledStudents**: A static variable keeping track of the total number of enrolled students across all courses.
- **creditValue**: Integer storing the credit value of the course.

**Constructor:**

- Initializes the **Course** object with provided **courseCode**, **courseName**, **maxCapacity**, and **creditValue**.
- Initializes **grades** and **credits** HashMaps.

**Getters:**

- Methods to retrieve information about the course, such as **getCourseCode()**, **getCourseName()**, **getMaxCapacity()**, **getEnrolledStudents()**, and **getTotalEnrolledStudents()**.

**Methods:**

- **incrementEnrolledStudents()**: Increments the count of enrolled students if the course capacity allows.
- **setGrade(Student student, int grade)**: Sets the grade of a specific student in this course if the student is enrolled.
- **enrollStudent(Student student, int creditValue)**: Enrolls a student in the course with a specific credit value if the course has capacity and the student is not already enrolled.
- **calculateOverallGrade(Student student)**: Calculates the overall grade of a student in this course based on their individual grades and credit values.

Enrolling a student updates the enrolled count and total enrolled count if the course has capacity and the student is not already enrolled. The overall grade calculation considers both the grade and credit value for a weighted average.

**Course Class:**

This Java code defines a **Course** class that represents an academic course and manages student enrollment, grades, and credits for that course. Let's break down the main components and functionalities:

**Attributes:**

- **courseCode**, **courseName**: Strings storing the course code and name respectively.
- **maxCapacity**: Integer representing the maximum number of students allowed in the course.
- **enrolledStudents**: Integer tracking the current number of enrolled students in the course.
- **grades**: **HashMap** mapping **Student** objects to their grades in this course.
- **credits**: **HashMap** mapping **Student** objects to their credit values for this course.
- **totalEnrolledStudents**: Static integer tracking the total number of enrolled students across all courses.
- **creditValue**: Integer storing the credit value of the course.

**Constructor:**

- Initializes the course attributes including code, name, maximum capacity, and credit value. Also initializes the HashMaps for storing grades and credits.

**Getters:**

- Methods to retrieve course attributes.

**Methods:**

- **incrementEnrolledStudents**: Increments the count of enrolled students if the course capacity allows.
- **setGrade**: Sets the grade of a specific student in this course.
- **enrollStudent**: Enrolls a student in the course with a specified credit value if there is space available.
- **calculateOverallGrade**: Calculates the overall grade of a student in this course based on their grades and credit values.

This code serves as a foundation for managing courses and student enrollments within an academic system.

**CourseManagement Class**

This code serves as the backbone for managing courses, students, and their grades within the system. Let's break down the main components and functionalities:

**Attributes:**

- **studentList**: Holds a list of **Student** objects.
- **courseList**: Holds a list of **Course** objects.
- **overallCourseGrades**: Maps each student to a map of courses and their respective grades.

**Methods:**

- **CourseManagement()**: Constructor initializing the lists and map.
- **getCourses()**: Retrieves the list of courses.
- **addCourse()**: Adds a new course to the course list.
- **enrollStudent()**: Enrolls a student in a course if the course exists in the course list.
- **assignGrade()**: Assigns a grade to a student for a specific course and updates the overall grades map.
- **calculateOverallGrade()**: Calculates and displays the overall grade of a student for each enrolled course.

This code provides functionalities to manage courses, enroll students, assign grades, and calculate overall grades for students within their enrolled courses, offering a foundational structure for an educational institution's management system.

**CourseManagement Class**

This Java code defines a **CourseManagement** class that manages courses, students, and their grades within a university or educational system. Let's break down the main components and functionalities:

**Lists and Maps:**

- - **studentList**: Holds instances of the **Student** class.
    - **courseList**: Stores instances of the **Course** class.
    - **overallCourseGrades**: A **HashMap** that maps students to a **HashMap** of courses and corresponding grades.

**Constructor:**

- - Initializes **studentList**, **courseList**, and **overallCourseGrades** as empty collections upon creating an instance of **CourseManagement**.

**Methods:**

- - **getCourses()**: Returns the list of courses.
    - **addCourse()**: Adds a new course to the **courseList**.
    - **enrollStudent()**: Enrolls a student in a specific course if the course exists in the **courseList**.
    - **assignGrade()**: Assigns a grade to a student for a specific course if the course exists in the **courseList**. It also updates the **overallCourseGrades** map.
    - **calculateOverallGrade()**: Calculates and displays the overall grade of a student for each enrolled course by retrieving the grades from the **overallCourseGrades** map.

This setup enables the management of courses, students, and their grades within the **CourseManagement** system, allowing operations like enrollment, grading, and overall grade calculation for each student in their enrolled courses.

**AdministratorInterface Class:**  
This Java code defines an **AdministratorInterface** class that serves as an interface for an administrator to manage courses, enroll students, assign grades, and calculate overall course grades for students. Let's break down the main components and functionalities:

**Instance Variables**:

- **scanner**: A **Scanner** object is used to handle user input.
- **courseManagement**: An instance of **CourseManagement** class (not provided in the code snippet) manages courses and student enrollments.

**Constructor**:

- Initializes the **Scanner** object and the **courseManagement** object.

**Methods**:

- **startInterface()**: Begins the administrator interface. It displays a menu of options and handles user input using a loop until the user chooses to exit.
- **displayMenu()**: Displays the available options in the interface.
- **addNewCourse()**: Allows the administrator to add a new course by gathering course details from user input and using the **courseManagement** object to add the course.
- **enrollStudent()**: Enables enrollment of a student in a course by gathering student details and the course code from user input and utilizing the **courseManagement** object to enroll the student.
- **assignGrade()**: Allows the administrator to assign a grade to a student for a specific course by taking inputs and using the **courseManagement** object to assign the grade.
- **calculateOverallGrade()**: Calculates the overall course grade for a specific student by taking inputs and using the **courseManagement** object to perform the calculation.
- **findCourse(String code)**: Searches for a course based on its code within the list of courses managed by the **courseManagement** object.

**Usage**:

- The administrator interacts with this interface by choosing options (1 to 5) to perform specific actions like adding a course, enrolling a student, assigning grades, calculating overall grades, or exiting the interface.

This code assumes the existence of **CourseManagement**, **Course**, and **Student** classes, as well as their respective methods (e.g., **addCourse**, **enrollStudent**, **assignGrade**, **calculateOverallGrade**) which are not provided in the snippet but are referenced in the **AdministratorInterface** class. These classes and methods would handle functionalities related to managing courses, students, and grading.

**Main Class:**

This **Main** class with a **main** method initializes an instance of the **AdministratorInterface** class and calls its **startInterface** method to kickstart the program's execution. Let's break down the main components and functionalities:

**Main Class**:

- The **Main** class is declared as **public**, which means it can be accessed from other classes.
- It contains a single method named **main**, which serves as the entry point for the Java application. This method takes an array of strings (**String\[\] args**) as input parameters.

**main Method**:

- The **main** method is marked as **public**, **static**, and **void**.
- **public** indicates that this method can be accessed from outside the class.
- **static** denotes that this method belongs to the class itself rather than any particular instance of the class.
- **void** signifies that the method does not return any value.

This code initializes an instance of an **AdministratorInterface** class and begins the program's execution by calling the **startInterface()** method. The specific functionalities and operations related to the interface or administrative tasks are expected to be implemented within the **AdministratorInterface** class, which is not explicitly defined in the given code snippet.

**Output Breakdowns:**
![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/ff6386ba-30c8-4965-aa9b-866d571f2c0b)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/f3fc3bdb-f347-4b08-b3f5-e48d72f612c0)

The outputs depict interactions with an "Administrator Interface" where a user, assumed to be an administrator, is interacting with a menu-driven system to perform various tasks related to managing courses, students, and grades.

Let's break down the outputs step by step:

**Menu Display**:

- The interface starts by displaying a menu with several options, numbered from 1 to 5, allowing the administrator to perform different tasks.
- The displayed options are:
  - Add a new course
  - Enroll a student
  - Assign grade to a student
  - Calculate overall course grade for a student
  - Exit

**Task Selection**:

- The user is prompted to enter their choice by selecting a number corresponding to the desired action.
- In the first output block, the administrator selects option 1: "Add a new course."

**Adding a New Course**:

- The system processes the choice and initiates the action associated with adding a new course.
- The administrator is prompted to input details about the new course, such as the course code, name, maximum capacity, and credit value.
- For example, in this case:
  - Course code: CS1101
  - Course name: Programming Fundamentals
  - Maximum capacity: 1 (assumed as an example value)
  - Credit value: 3 (assumed as an example value)
- After the administrator provides these details, the system confirms that the course has been added successfully.

**Continued Interaction**:

- The menu is displayed again after the first task is completed.
- The administrator is prompted to select another action.
- In the second output block, the administrator selects option 2: "Enroll a student."

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/7e1b72c5-22df-4937-a702-5be5645b3638)

**Enrolling a Student**:

- Following the administrator's choice, the system processes the action related to enrolling a student in a course.
- The administrator is prompted to input details about the student, such as their name and ID, and then specify the course code for enrollment.
- For instance:
  - Student name: Thuta Tun
  - Student ID: 1312
  - Course code to enroll: CS1101 (which was added in the previous step)
- The system confirms the successful enrollment of the student, Thuta Tun, in the course "Programming Fundamentals."


**Enrolling a Student**:

- Following the selection, the interface informs the user that it's enrolling a student.
- It prompts for specific information:
  - "Enter student name:" expects the user to input the name of the student. In this case, the name entered is "Eaint Hmue."
  - "Enter student ID:" expects the user to input the ID of the student. The ID entered is "1111."
  - "Enter course code to enroll the student:" requires the user to input the course code for the student's enrollment. The code entered is "CS1101."

**Error Message**:

The output then displays an error message: "Course capacity reached. Cannot enroll more students." This message suggests that the enrollment process failed because the capacity for the course with the code "CS1101" has been reached. Therefore, no more students can be enrolled in this particular course.

**Explanation**:

The system provides feedback to the administrator, indicating that the attempt to enroll the student "Eaint Hmue" with ID "1111" in the course "CS1101" was unsuccessful due to the course being at maximum capacity. This output signifies the interaction flow within the administrator interface, guiding the user through the enrollment process and informing them of any issues encountered, such as the course reaching its maximum student capacity in this scenario.

**Conclusion**

The program is an administrator interface designed to manage courses, student enrollment, and grading. It offers several functionalities:

1. **_Add New Course_**_: Allows administrators to add new courses to the system._
2. **_Enroll a Student_**_: Enables enrollment of students into specific courses._
3. **_Assign Grade to a Student_**_: Facilitates the grading process for enrolled students in respective courses._
4. **_Calculate Overall Course Grade for a Student_**_: Potentially computes the overall grade for a student within a course._
5. **_Exit_**_: Allows exiting the program._
