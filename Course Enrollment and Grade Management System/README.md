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

**_Source code of Student Class:_**

import java.util.ArrayList;  
import java.util.List;  
<br/>_// Class representing a Student  
_class Student {  
_// Private attributes: name, ID, and a list of enrolled courses  
_private String name;  
private int ID;  
private List&lt;Course&gt; enrolledCourses;  
<br/>_// Constructor to initialize a Student object with a name and ID  
_public Student(String name, int ID) {  
this.name = name;  
this.ID = ID;  
this.enrolledCourses = new ArrayList<>(); _// Initializing the enrolledCourses list  
_}  
<br/>_// Getter method for the student's name  
_public String getName() {  
return name;  
}  
<br/>_// Getter method for the student's ID  
_public int getID() {  
return ID;  
}  
<br/>_// Getter method for the list of enrolled courses  
_public List&lt;Course&gt; getEnrolledCourses() {  
return enrolledCourses;  
}  
<br/>_// Method to enroll a student in a course  
_public void enrollCourse(Course course) {  
enrolledCourses.add(course); _// Add the course to the student's enrolled courses  
_course.incrementEnrolledStudents(); _// Increment the count of enrolled students in the course  
_}  
<br/>_// Method to set the grade for a course for the student  
_public void setGradeForCourse(Course course, int grade) {  
_// Loop through the enrolled courses to find the matching course  
_for (Course enrolledCourse : enrolledCourses) {  
_// Check if the enrolledCourse is equal to the provided course  
_if (enrolledCourse.equals(course)) {  
enrolledCourse.setGrade(this, grade); _// Set the grade for the student in that course  
_return; _// Exit the method after setting the grade  
_}  
}  
_// If the course is not found in the  
_}  
}

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

**_Source code of Course Class:_**

import java.util.HashMap;  
<br/>class Course {  
<br/>_// Class attributes  
_private String courseCode; _// Stores the course code  
_private String courseName; _// Stores the course name  
_private int maxCapacity; _// Stores the maximum capacity of students allowed in the course  
_private int enrolledStudents; _// Stores the number of currently enrolled students  
_private HashMap&lt;Student, Integer&gt; grades; _// Maps students to their grades in this course  
_private HashMap&lt;Student, Integer&gt; credits; _// Maps students to their credit values for this course  
<br/>_private static int _totalEnrolledStudents_ \= 0; _// Stores the total number of enrolled students across all courses  
_private int creditValue; _// Stores the credit value of the course  
<br/>// Constructor  
_public Course(String courseCode, String courseName, int maxCapacity, int creditValue) {  
this.courseCode = courseCode;  
this.courseName = courseName;  
this.maxCapacity = maxCapacity;  
this.creditValue = creditValue;  
this.enrolledStudents = 0;  
this.grades = new HashMap<>(); _// Initializes the map for storing grades  
_this.credits = new HashMap<>(); _// Initializes the map for storing credits  
_}  
<br/>_// Getters for class attributes  
_public String getCourseCode() {  
return courseCode;  
}  
<br/>public String getCourseName() {  
return courseName;  
}  
<br/>public int getMaxCapacity() {  
return maxCapacity;  
}  
<br/>public int getEnrolledStudents() {  
return enrolledStudents;  
}  
<br/>public static int getTotalEnrolledStudents() {  
return _totalEnrolledStudents_;  
}  
<br/>_// Method to increment the count of enrolled students if the course capacity allows  
_public void incrementEnrolledStudents() {  
if (enrolledStudents < maxCapacity) {  
enrolledStudents++;  
_totalEnrolledStudents_++;  
} else {  
System._out_.println("Course capacity reached. Cannot enroll more students.");  
}  
}  
<br/>_// Method to set the grade of a student in this course  
_public void setGrade(Student student, int grade) {  
if (grades.containsKey(student)) {  
grades.put(student, grade);  
} else {  
System._out_.println("Student not enrolled in this course.");  
}  
}  
<br/>_// Method to enroll a student in this course with a specific credit value  
_public void enrollStudent(Student student, int creditValue) {  
if (enrolledStudents < maxCapacity) {  
if (!grades.containsKey(student)) {  
grades.put(student, 0); _// Sets the initial grade to 0 for the student  
_credits.put(student, creditValue); _// Assigns credit value to the student  
_enrolledStudents++;  
_totalEnrolledStudents_++;  
} else {  
System._out_.println("Student is already enrolled in this course.");  
}  
} else {  
System._out_.println("Course capacity reached. Cannot enroll more students.");  
}  
}  
<br/>_// Method to calculate the overall grade of a student in this course  
_public int calculateOverallGrade(Student student) {  
int totalCredits = credits.getOrDefault(student, 0); _// Retrieves the credit value of the student  
_int grade = grades.getOrDefault(student, 0); _// Retrieves the grade of the student  
<br/>// Calculates the overall grade based on credits and grade (weighted average)  
_return totalCredits > 0 ? grade \* totalCredits / totalCredits : 0;  
}  
}

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

**_Source code of CourseManagement Class:_**

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
<br/>_// Class representing the management system for courses and students  
_class CourseManagement {  
_// List to store student objects  
_private List&lt;Student&gt; studentList;  
_// List to store course objects  
_private List&lt;Course&gt; courseList;  
_// HashMap to store overall grades of students in different courses  
_private HashMap&lt;Student, HashMap<Course, Integer&gt;> overallCourseGrades;  
<br/>_// Constructor to initialize lists and map  
_public CourseManagement() {  
studentList = new ArrayList<>();  
courseList = new ArrayList<>();  
overallCourseGrades = new HashMap<>();  
}  
<br/>_// Method to get the list of courses  
_public List&lt;Course&gt; getCourses() {  
return courseList;  
}  
<br/>_// Method to add a new course to the course list  
_public void addCourse(String courseCode, String courseName, int maxCapacity, int creditValue) {  
Course newCourse = new Course(courseCode, courseName, maxCapacity, creditValue);  
courseList.add(newCourse);  
}  
<br/>_// Method to enroll a student in a course  
_public void enrollStudent(Student student, Course course) {  
if (courseList.contains(course)) {  
student.enrollCourse(course);  
} else {  
System._out_.println("Course not found.");  
}  
}  
<br/>_// Method to assign a grade to a student for a specific course  
_public void assignGrade(Student student, Course course, int grade) {  
if (courseList.contains(course)) {  
course.setGrade(student, grade);  
overallCourseGrades.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);  
} else {  
System._out_.println("Course not found.");  
}  
}  
<br/>_// Method to calculate and display the overall grade of a student for each enrolled course  
_public void calculateOverallGrade(Student student) {  
if (overallCourseGrades.containsKey(student)) {  
HashMap&lt;Course, Integer&gt; grades = overallCourseGrades.get(student);  
for (Course course : grades.keySet()) {  
int overallGrade = course.calculateOverallGrade(student);  
System._out_.println("Overall grade for " + student.getName() + " in " + course.getCourseName() + ": " + overallGrade);  
}  
} else {  
System._out_.println("No grades found for the student.");  
}  
}  
}

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

**_Source code of AdministratorInterface Class:_**

import java.util.Scanner;  
class AdministratorInterface {  
private Scanner scanner; _// Scanner object to handle user input  
_private CourseManagement courseManagement; _// Object to manage courses and student enrollments  
<br/>// Constructor initializes the scanner and course management system  
_public AdministratorInterface() {  
scanner = new Scanner(System._in_);  
courseManagement = new CourseManagement();  
}  
<br/>_// Method to start the administrator interface  
_public void startInterface() {  
boolean exit = false;  
<br/>_// Loop to display menu and handle user input until the user chooses to exit  
_while (!exit) {  
displayMenu(); _// Display options  
_int choice = scanner.nextInt(); _// Get user choice  
_scanner.nextLine(); _// Consume newline  
<br/>_switch (choice) {  
case 1:  
addNewCourse();  
break;  
case 2:  
enrollStudent();  
break;  
case 3:  
assignGrade();  
break;  
case 4:  
calculateOverallGrade();  
break;  
case 5:  
exit = true;  
break;  
default:  
System._out_.println("Invalid choice. Please select a valid option.");  
}  
}  
scanner.close(); _// Close the scanner after use  
_}  
<br/>_// Display menu options  
_private void displayMenu() {  
System._out_.println("\\n\*\*\*\*\* Administrator Interface \*\*\*\*\*");  
System._out_.println("1. Add a new course");  
System._out_.println("2. Enroll a student");  
System._out_.println("3. Assign grade to a student");  
System._out_.println("4. Calculate overall course grade for a student");  
System._out_.println("5. Exit");  
System._out_.print("Enter your choice: ");  
}  
<br/>_// Method to add a new course  
_private void addNewCourse() {  
System._out_.println("\\nAdding a new course...");  
_// Gather course details from user input  
_System._out_.print("Enter course code: ");  
String code = scanner.nextLine();  
System._out_.print("Enter course name: ");  
String name = scanner.nextLine();  
System._out_.print("Enter maximum capacity: ");  
int capacity = scanner.nextInt();  
System._out_.print("Enter credit value: ");  
int creditValue = scanner.nextInt();  
_// Add the course to the course management system  
_courseManagement.addCourse(code, name, capacity, creditValue);  
System._out_.println("Course added successfully!");  
}  
<br/>_// Method to enroll a student in a course  
_private void enrollStudent() {  
_// Gather student details and course code from user input  
_System._out_.println("\\nEnrolling a student...");  
System._out_.print("Enter student name: ");  
String studentName = scanner.nextLine();  
System._out_.print("Enter student ID: ");  
int studentID = scanner.nextInt();  
scanner.nextLine(); _// Consume newline  
<br/>_Student student = new Student(studentName, studentID);  
<br/>System._out_.print("Enter course code to enroll the student: ");  
String courseCode = scanner.nextLine();  
Course course = findCourse(courseCode);  
<br/>if (course != null) {  
courseManagement.enrollStudent(student, course);  
System._out_.println(student.getName() + " enrolled in " + course.getCourseName() + " successfully!");  
} else {  
System._out_.println("Course not found.");  
}  
}  
<br/>_// Method to assign a grade to a student for a specific course  
_private void assignGrade() {  
System._out_.println("\\nAssigning grade to a student...");  
System._out_.print("Enter student name: ");  
String studentName = scanner.nextLine();  
System._out_.print("Enter student ID: ");  
int studentID = scanner.nextInt();  
scanner.nextLine(); _// Consume newline  
<br/>_Student student = new Student(studentName, studentID);  
<br/>System._out_.print("Enter course code to assign grade: ");  
String courseCode = scanner.nextLine();  
Course course = findCourse(courseCode);  
<br/>if (course != null) {  
System._out_.print("Enter grade for the student: ");  
int grade = scanner.nextInt();  
courseManagement.assignGrade(student, course, grade);  
System._out_.println("Grade assigned to " + student.getName() + " for " + course.getCourseName() + " successfully!");  
} else {  
System._out_.println("Course not found.");  
}  
}  
<br/>_// Method to calculate the overall course grade for a student  
_private void calculateOverallGrade() {  
System._out_.println("\\nCalculating overall course grade for a student...");  
System._out_.print("Enter student name: ");  
String studentName = scanner.nextLine();  
System._out_.print("Enter student ID: ");  
int studentID = scanner.nextInt();  
scanner.nextLine(); _// Consume newline  
<br/>_Student student = new Student(studentName, studentID);  
<br/>courseManagement.calculateOverallGrade(student);  
}  
<br/>_// Method to find a course by its code  
_private Course findCourse(String code) {  
for (Course course : courseManagement.getCourses()) {  
if (course.getCourseCode().equals(code)) {  
return course;  
}  
}  
return null;  
}  
}

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

**_Source code of Main Class:_**

_// This is the main class of the program  
_public class Main {  
_// This is the main method where the program execution begins  
_public static void main(String\[\] args) {  
_// Create an instance of AdministratorInterface class named adminInterface  
_AdministratorInterface adminInterface = new AdministratorInterface();  
<br/>_// Call the startInterface() method of the adminInterface object to begin the program  
_adminInterface.startInterface();  
}  
}

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
