**Student Record Management System GUI**

I crafted the Student Record Management System—a Java-based GUI application designed to streamline administrative tasks related to student records, course enrollment, and grading. This comprehensive documentation serves as a guide which outlines the intuitive interface, event handling mechanisms, and dynamic updates employed in the system. With detailed explanations and examples, this documentation equips users with the knowledge to efficiently utilize and navigate the Student Management System.

The class attributes store essential information about the student, such as their name, ID, age, grade, enrolled courses, and course grades.

The constructor initializes a Student object with the provided name, ID, age, and grade, and also initializes the courses list and courseGrades map.

The class provides getter and setter methods for name, ID, age, and grade. It also includes methods to enroll a student in a course, remove a student from a course, assign a grade for a specific course, retrieve the grade for a specific course, and get a student by name from a list of students.

The class can read data from a file (student_data.txt) to populate and return a list of Student objects. It also includes methods to handle exceptions, such as checking for valid grades and handling file input/output exceptions when reading student data from a file.

Overall, this class seems to efficiently handle student-related data and behavior, providing methods to interact with and manipulate this data within a software system. This encapsulation of functionalities related to students and their management within the system makes the Student class a crucial component of the system.

The class attributes store essential information about the course, such as its **code, name, maximum capacity, enrolled students, grades, credits, and credit value.** The class also maintains a total count of enrolled students across all courses.

The constructor initializes a Course object with the provided attributes and initializes maps for grades and credits.

The class provides getter methods for retrieving attributes. It also includes methods to **increment the count of enrolled students, set the grade of a student, enroll a student with a specific credit value, calculate the overall grade of a student, and find a course by its code.**

The class can load course data from a file and create a list of **Course objects**. It can retrieve the grade for a specific course, assign a grade to a course, save student data to a text file, and add a student to the course.

Overall, this class seems to efficiently handle the enrollment process, grade assignments, and calculations related to course and student interactions. It also manages file I/O operations to load and save course data and student information. This encapsulation of functionalities related to courses and their management within the system makes the Course class a crucial component of the system.

The "StudentManagement" class is the backbone of a Student Record Management System in Java. It utilizes file handling from the **java.io** package to read from and write to a text file for persistent data storage. This class manages a list of **Student** objects stored in an **ArrayList**, allowing operations like adding, updating, finding, and removing students based on their unique IDs.

The **addStudent** method adds a new student to the list while ensuring the uniqueness of their ID. **updateStudent** modifies existing student details based on ID, and **removeStudentsByID** removes students by their IDs.

The class integrates file handling methods **loadStudentDataFromFile** and **saveStudentDataToTextFile** to respectively load student data from a text file during initialization and persist any changes made to the student list back to the same file. The file path is specified by **FILE_PATH**.

Additionally, the class provides methods like **findStudentByID** to search for a student by ID, **getStudentList** to retrieve the entire student list, and **getAllStudents** to return a copy of all students.

Overall, this software component offers comprehensive functionalities for managing student records efficiently, utilizing file storage for data persistence and various methods for manipulation and retrieval of student data.

The **CourseManagement** class forms the crux of a comprehensive system designed to handle courses and students. It contains essential data structures: **studentList** and **courseList**, representing the collection of students and courses, respectively. The architecture includes a **HashMap** called **overallCourseGrades**, dedicated to managing and tracking student grades across multiple courses.

Upon initialization, the class sets up empty containers for students, courses, and a structure for grade tracking. The method **getCourses** allows access to the existing list of courses, enabling retrieval functionality.

Functionality-wise, this class offers several key methods:

- **assignGrade** enables the assignment of grades to students for specific courses. It ensures course existence, assigns grades, and updates the overall grade records accordingly.
- **calculateOverallGrade** computes and presents the overall grades of a student across all enrolled courses. It retrieves and displays the overall grade per course for the specified student.
- **loadCourseDataFromFile** is responsible for reading course data from a designated text file (**COURSE_DATA_FILE**). It parses each line, generates **Course** objects, and populates the **courseList** with these entries.
- **addCourse** incorporates functionality to append a new course to the **courseList** and simultaneously update the file storing course information. This method creates a new **Course** object and records its details in the text file.
- **saveCourseDataToTextFile** writes the entire **courseList** to a text file, ensuring persistent storage of course data. It formats each course's details and appends this information to the file.
- **enrollStudent** enables the enrollment of a student in a specific course. This method verifies the course's availability and capacity, enrolling the student if conditions are met.

In essence, this class offers an array of functionalities for managing courses and students efficiently, including grade assignments, overall grade calculations, persistent data handling through file operations, and enrollment management.

Administrator Interface for a Student Record Management System. Here's an overview:

- **Libraries and Imports:** Import necessary Java libraries for GUI components and functionality.
- **Class Overview:** The **AdministratorInterface** class contains components and functionality for the administrator's interface.
- **Main Method:** Sets up the main window, creates a panel (**mainPanel**) with dropdown (**choiceBox**), button (**submitButton**), and text area (**outputArea**) to display output. It initializes the GUI components, sets layout using **GridBagLayout**, and adds them to the frame.
- **Data Initialization:** Initializes lists of students and courses.
- **Main Functionality:** An action listener for the **submitButton** triggers actions based on the selected choice from the dropdown using a **switch** statement. This part is intended to handle different functionalities for adding new students, updating student information, or viewing student details. However, the individual cases are yet to be implemented.

The code structure lays the foundation for the administrator interface, allowing the selection of various options from a dropdown and handling their functionality. It lacks the implementation details for each option, which should be written within the **switch** cases based on the selected choice.

Further code sections fill in within each **case** to define the actions for adding new students, updating student information, or viewing student details.

**case 1: Add New Student**

- **Panel Setup:** Creates a panel (**addStudentPanel**) with components to input new student details, including name, ID, age, and grade. It also contains a button to add the student.
- **Layout and UI Setup:** Utilizes **GridBagLayout** for arranging the components within the panel, ensuring proper positioning and spacing via **GridBagConstraints**.
- **Adding a Student:** The **addStudentButton** action listener reads the input data from the text fields, creates a new **Student** object, and attempts to add it to the system using **studentManagement.addStudent(newStudent)**.
- **Success/Error Handling:** If the addition is successful, it displays a success message using a **JOptionPane** and saves the updated student list to a file. In case of a pre-existing student ID, it alerts the user to choose a different ID.
- **Back Button:** Provides functionality to navigate back to the main menu by removing the current panel components and re-adding the main menu components.

This case adds an interactive feature allowing the system user to input new student details and seamlessly incorporate them into the student management system. It ensures smooth user interaction and feedback for successful or failed student additions.

**case 2: Update Student Information**

- **Panel Setup:** Creates a panel (**updateStudentPanel**) containing components to update student information. It includes a label to prompt for the student ID, a text field for ID input, a button to trigger the update, and a text area to display the output.
- **Layout and UI Setup:** Utilizes **GridBagLayout** to arrange the components, setting constraints (**gbc**) for their placement within the panel.
- **Update Process:** The **updateButton** action listener reads the student ID, fetches the student details, and displays the current information in the **updateOutputArea**.
- **User Interaction:** Provides options to update the student's name, age, or grade via a dialog prompt. It handles user input to update the specific field using the **studentManagement.updateStudent** method.
- **Back Button:** Allows the user to navigate back to the main menu.

**case 3: View Student Details**

- **Panel Setup:** Creates a panel (**viewStudentPanel**) to view student details, including components for ID input, a button to view details, and a text area to display the output.
- **Layout and UI Setup:** Utilizes **GridBagLayout** for proper component placement within the panel, setting constraints (**gbc**) accordingly.
- **View Process:** The **viewButton** action listener reads the entered student ID, retrieves details, and displays them in the **viewOutputArea**.
- **Back Button:** Allows navigation back to the main menu.

Both cases operate similarly in terms of panel setup, layout management, handling user input, displaying output, and providing a way to return to the main menu. These functionalities enhance the system's interactivity, allowing administrators or users to update and view student information seamlessly through a graphical interface.

**case 4: Delete Student Information**

This part deals with deleting students from the system. It creates a JPanel (**deleteStudentPanel**) containing components to input student IDs and delete them from the system.

- It includes a label (**deleteLabel**) and a text field (**deleteIDField**) to input student IDs for deletion.
- Provides a button (**deleteButton**) to trigger the deletion process.
- The ActionListener for the delete button extracts the entered IDs, removes students corresponding to those IDs from the system via **studentManagement.removeStudentsByID(studentIDs)**, and updates the GUI accordingly.

The functionality includes error handling for invalid IDs and displays a message indicating the successful deletion of students' data.

**case 5: Add a New Course**

This segment handles the addition of a new course to the system through a graphical user interface (GUI). It sets up a panel (**addNewCoursePanel**) containing various components to input details about a new course:

- **JLabel** and **JTextField** pairs for Course Code, Course Name, Maximum Capacity, and Credit Value.
- A **JButton** labeled "Add Course" to trigger the addition process.

The layout of the **addNewCoursePanel** is managed using **GridBagLayout** to arrange the components in a grid-like fashion, specifying the constraints for each component's placement within the panel.

The **addActionListener** for the "Add Course" button collects input data from the text fields, converts appropriate fields to their respective data types, and then utilizes the **CourseManagement** class to add the course to the system using the method **CourseManagement.addCourse(code, name, capacity, creditValue)**.

Upon successful addition, it displays a message using **JOptionPane** confirming the addition of the course. There seems to be a repetitive addition of the action listener for the same button within its action, which may be unnecessary repetition.

Lastly, there's a "Back" button (**backCourseButton**) that, when clicked, removes the current panel components and navigates back to the main menu panel.

The code then manipulates the main frame by clearing its contents, adding the **addNewCoursePanel**, and refreshing the frame to reflect the changes.

This **case** essentially encapsulates the GUI and functionality for adding new courses to the system, ensuring an interactive and user-friendly experience for the administrator or user managing the system.

**case 6: Enroll a Student**

This case handles the enrollment of a student in a course through the graphical user interface (GUI). It creates a new JFrame titled "Enroll Student" and sets up a JPanel (**enrollPanel**) using a GridLayout with 4 rows and 2 columns to organize components.

- It creates text fields (**studentNameField**, **studentIDField**, **courseCodeField**) to input student details (name, ID) and the course code.
- Adds labels and corresponding text fields to **enrollPanel**.
- Configures an "Enroll" button (**enrollButton**) that triggers the enrollment process when clicked.
- The ActionListener for the "Enroll" button retrieves inputs, attempts to enroll the student in the specified course, and provides a success or failure message via JOptionPane.

**case 7: Assign Grade**

This case manages the assignment of grades to students for specific courses through the GUI. It creates a JPanel (**assignGradePanel**) to input student details (name, ID), course code, and the grade to be assigned.

- Sets up text fields (**nameField7**, **idField7**, **courseField7**, **gradeField7**) and corresponding labels for user input.
- Adds these components to **assignGradePanel** using GridBagConstraints to arrange them in a grid layout.
- Configures an "Assign Grade" button (**assignGradeButton**) triggering the process of assigning the grade when clicked.
- The ActionListener retrieves inputs, assigns the grade to the student for the specified course, updates the GUI accordingly, and saves the updated data to a file.

Both cases manage user interactions through the GUI, capturing input data, performing validation, interacting with the backend (assumed by the presence of methods like **enrollStudentInCourse** and **assignGradeToStudent**), and updating the GUI to reflect changes or provide feedback using JOptionPane or by modifying the panel components.

**Output Screenshots:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/ae75f995-f137-4b31-8ec9-6a187d3deedd)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/f35a5f01-2463-4d67-a532-ba76cb7138fe)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/b139a3f2-5703-4568-9a0b-27c2e9583ec5)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/8656284b-ff9a-479f-8dee-39a5edb21aa3)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/4920f266-1189-4b8d-b3d5-2c0cccb04d3f)

**_Go Back to the Main Menu using Back Button…_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/1c93619c-384c-4dd3-9e1d-5154bfc82926)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/9f606578-952d-4d7f-9478-1278775172dd)

**_Go Back to the Main Menu using Back Button…_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/3995c7b0-cb4a-410e-98bd-5a3dcda4b4f5)

**_Update new student information…_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/120e2bfc-513b-4530-9f45-20e754136b68)

**_Update Name, Age and Grade …_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/a643cfd0-5f7f-483f-a712-ff51d1f73b9b)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/e0fa0281-92ea-4cc1-adec-2401868fab4a)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/eeb95f58-47ff-4953-b9c2-5782bc32f100)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/b791b0ef-1cb6-48a5-891c-a155fd97bb3d)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/9e794915-e489-44c7-9873-f77243fa864a)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/35199c91-109a-4d4c-8915-89e39a0e3a05)


**_Going back to View Student Detail…_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/d14d59f7-10cf-494d-b3c4-406ccaf1149f)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/ab3ea93a-20ff-4086-b3e1-5cba00c6b76e)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/3b0badc5-123d-4b36-9ded-31d2c3d874b0)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/c5bc99be-1139-4548-a5a7-88d5649c4fdd)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/77524f27-a1cb-4a83-8361-de077094cabf)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/b892c89a-2dad-49b6-9ff4-3d2e88c56ef7)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/a06d713c-4857-4272-82d5-f245ead215ef)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/ce1bb90b-99b3-4eaf-a27b-4743231a51f2)


![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/cc3591f3-689c-44fd-abec-ed01419cfd06)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/2e9b9b0d-2192-42a2-85d7-22d94b01375f)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/ca9d207d-91c3-401a-90cc-49f120074e7c)

**Conclusion  
**The Student Record Management System, introduced earlier this week, has been meticulously detailed in this documentation. Its Java-based GUI, geared toward simplifying administrative tasks surrounding student records, course enrollment, and grading, is comprehensively outlined. Through a thorough exploration of the intuitive interface, event handling mechanisms, and dynamic updates incorporated within the system, this guide equips users with the necessary knowledge for efficient navigation and utilization of the Student Management System. **Top of Form**
