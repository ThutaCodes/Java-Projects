**Student Record Management System**

I have built a Student Record Management System in Java for a university. The system enables administrators to effectively manage student records, including adding new students, updating student information, and viewing student details. Moreover, I added additionally features where the administrators can delete a student information, or many students’ information at the same time. I also created a data-base-like _‘.txt’_ file where the information is stored even if the program is being terminated.

This document consists of two sections- Section (1), elaborating on codes, and Section (2) explaining on how the program works.

**Section (1)**

In section (1), each line of code and code snippets are elaborated.

To begin with, this program consists of four classes: _Main.java, Student.java, StudentManagement.java_ and _AdministratorInterface.java_. I will walk through to each of these classes, elaborating on what each line of code/snippet does.

**_Class: Student.java_**

The line **import java.io.Serializable;** is an import statement in Java. It brings in the **Serializable** interface from the **java.io** package. The **Serializable** interface is a marker interface in Java used to indicate that a class can be serialized, meaning its objects can be converted into a stream of bytes, or data that can be easily stored, transmitted, or reconstructed.

This line declares a Java class named **Student** that implements the **Serializable** interface. This means the **Student** class can be serialized, allowing instances of this class to be converted into a stream of bytes for storage. This is used here to save the data to ‘_.txt_’ file.

Within the **Student** class, there are private attributes that encapsulate essential student information. These attributes include **name**, a string holding the student's name; **ID**, an integer serving as the unique identification number; **age**, an integer denoting the student’s age; and **grade**, a string capturing the student's academic grade or standing. These attributes play a crucial role in storing individual student details within the program.

This section defines a constructor method for the **Student** class. It takes in four parameters: **name**, **ID**, **age**, and **grade**, corresponding to the student's name, ID number, age, and grade, respectively. Within the constructor, the values passed as arguments are assigned to the respective attributes of the **Student** object using the **this** keyword. This constructor allows for the creation of a **Student** object with specific attribute values at the time of instantiation.

These lines depict getter and setter methods for the private attributes of the **Student** class. This encapsulates access to the class’s attributes, allowing controlled modification and retrieval of the **Student** object’s internal state.

**_Class: StudentManagement.java_**

The StudentManagement class comprises 8 major methods, which will be detailed more below.

1. addStudent
2. isStudentIdExists
3. updateStudent
4. findStudentByID
5. saveStudentDataToFile
6. loadStudentDataFromFile
7. removeStudentsByID
8. saveStudentDataToTextFile

These methods are responsible for various functionalities within the StudentManagement class, such as adding and updating student information, retrieving students by ID, loading and saving student data to files, and removing students based on their IDs.

This line import **java.io** package that allows access to various input and output functionalities. The wildcard **\*** notation indicates that all classes within the **java.io** package are imported, granting access to file handling, input and output streams, serialization, and more.

The line **import java.util.ArrayList;** is an import statement. It specifically imports the **ArrayList** class from the **java.util** package. This class is a part of the collection framework and provides dynamic array-like functionality which allow for the creation of resizable arrays that facilitates in operations like adding, removing, and accessing elements.

This line signifies the beginning of the **StudentManagement** class. This class specifically manages operations related to students, such as handling student records, information retrieval, or administrative tasks within a university setting.

This line defines a private attribute **studentList** within the **StudentManagement** class. It represents an **ArrayList** capable of storing objects of the **Student** class. This list is intended to manage and store instances of **Student** objects within the **StudentManagement** class.Top of Form

This line introduces a private integer variable **totalStudents** within the **StudentManagement** class. It's intended to maintain a count representing the total number of student records or instances stored in the **studentList** attribute of the **StudentManagement** class.

This constructor initializes the **studentList** attribute as a new **ArrayList** object, capable of storing **Student** objects. Additionally, it sets the **totalStudents** count to zero when a **StudentManagement** object is created.

1. **_addStudent_**

The **addStudent** method, part of the **StudentManagement** class, adds a provided **Student** object to the **studentList**, simultaneously incrementing the **totalStudents** count by one to track the number of students. Following the addition of a student, **saveStudentDataToFile()** is triggered to persistently storing the updated student data in the file, ensuring the information remains accessible beyond the program's execution.

1. **_isStudentIdExists_**

This method iterates through the **studentList** and compares each student's ID with the provided **id**. If it finds a student with the same ID, it returns **true**, indicating that the ID already exists. If the loop completes without finding a matching ID, it returns **false**, indicating that the ID does not exist.

The **addStudent** method uses this helper method to check if the provided student ID already exists before adding a new student to the system. This helps ensure that the system only contains unique student IDs.

2. **_updateStudent_**

The **updateStudent** method in the **StudentManagement** class iterates through the **studentList** to locate a student based on their ID. Upon finding the matching ID, the method modifies the student's attributes—name, age, and grade—according to the provided new values. This mechanism ensures targeted updates for specific students within the list, allowing for the adjustment of individual student details without affecting others in the management system.

3. **_findStudentByID_**

<br/>The **findStudentByID** method in the **StudentManagement** class iterates through the **studentList**, comparing each student's ID with the provided ID. When a matching ID is encountered, the method returns the respective **Student** object. If no student with the provided ID is found after examining the entire list, the method returns **null** to indicate the absence of a matching student within the system. This method efficiently retrieves specific student details based on their unique identification number, facilitating targeted access to individual student records within the management system.

4. **_saveStudentDataToFile_**  
    The **saveStudentDataToFile** method, part of the **StudentManagement** class in Java, manages the serialization and storage of student data into a file named ‘student_data.ser’. Within a try-with-resources block, it utilizes an **ObjectOutputStream** connected to a **FileOutputStream** to write the **studentList**, containing **Student** objects, into the designated file. Upon successful serialization, it prints a confirmation message indicating the successful saving of student data. In the event of any input/output exception during the file writing process, it handles the exception by printing the stack trace. This method ensures the persistent storage of student records in a serialized format for future access and retrieval.
5. **_loadStudentDataFromFile_**

The notation **@SuppressWarnings(‘unchecked’)** is an annotation in Java used to instruct the compiler to suppress specific types of warnings.

The method **loadStudentDataFromFile()** is responsible for loading previously serialized student data. Within a try-with-resources block, it uses an **ObjectInputStream** connected to a **FileInputStream** to read serialized data from the file. It then casts the retrieved object back to an **ArrayList** of **Student** objects and updates the **totalStudents** count based on the number of students loaded. A confirmation message is printed upon successful data loading. In case of any input/output exception or class not found exception during the file reading process, the method handles the exceptions by printing the stack trace.

6. **_removeStudentsByID_**

The **removeStudentsByID** method, present within the **StudentManagement** class in Java, serves to eliminate students from the system based on their provided IDs. It commences by creating a new **ArrayList**, **studentsToRemove**, designated to accumulate **Student** objects that correspond to the given IDs. Iterating through the provided list of student IDs, the method employs the **findStudentByID** function to locate and verify the existence of each student. If a student with a matching ID is found, it adds that student to the **studentsToRemove** list. Subsequently, it utilizes the **removeAll** method to eliminate all students contained in **studentsToRemove** from the primary **studentList**. Finally, after this removal process, it triggers the **saveStudentDataToTextFile()** function to persistently update the student data in a text file. This method offers an effective means to selectively remove specific students from the system by their unique identification numbers.

7. **_saveStudentDataToTextFile_**

The **saveStudentDataToTextFile** method in the **StudentManagement** class writes each student's details—name, ID, age, and grade—from the **studentList** to a text file named ‘student_data.txt’. Using a **PrintWriter** connected to a **FileWriter**, it formats and writes each student's information line by line. Upon successful writing, it confirms the data saving with a message. If any issues arise during the file writing process, it handles potential input/output exceptions. This method ensures the persistent storage of student records in a readable text format for easy reference.

**_Class: AdministratorInterface.java_**

This class comprises several parts, including input reading using **Scanner**, managing student data through the **StudentManagement** class, and a user interface handled by the **main** method. As an unsual aspect, I used a shutdown hook to save student data when the program ends, ensuring data are not lost.  
This class is used for obtaining user input from various sources like files or consoles.

As I have mentioned this above, this class is the Collection Framework of java which we can use to manipulate the data.

This code initializes the **AdministratorInterface**, starting with a **main** method. It creates a **Scanner** to capture user input, initializes a **StudentManagement** instance to handle student data, and declares an integer variable for user choices. It loads existing student data from a file using **loadStudentDataFromFile()** upon program start. Additionally, it sets up a shutdown hook using **addShutdownHook** to ensure that the **saveStudentDataToFile()** method is executed to store data before program termination, ensuring data persistence across sessions.

The code displays a menu with various options for managing student records, presenting choices from 1 to 5. Each option corresponds to different functionalities within the Student Record Management System, such as adding a new student, updating student information, viewing student details, deleting a student, or exiting the system. It prompts the user to enter their choice. The program reads the user's input using **scanner.nextInt()** and assigns the entered value to the **choice** variable.

**Case 1: Student Information:**

The **switch** statement uses the value stored in the **choice** variable to determine the course of action based on the user's selection. When the user selects option 1, the program prompts for the student's name, ID, age, and grade using **scanner.nextLine()** and **scanner.nextInt()** methods to capture user input. It creates a new **Student** object based on the provided information. The **addStudent()** method from the **studentManagement** instance is called to add the new student to the system. After adding the student, the system saves the updated data to a text file using **saveStudentDataToTextFile()**. This code segment handles the scenario where the user selects option 1 to add a new student to the Student Record Management System by collecting the necessary information and updating the system accordingly.

**Case 2: Update Student Information:**

The user selects option 2 from the menu to update a student's details. The system prompts the user to input the student ID to be updated. It searches for the student using the entered ID through **findStudentByID** from **studentManagement**. If the student is found (**studentToUpdate != null**): Displays the current information of the located student: name, ID, age, and grade. Prompts the user to choose which detail they want to update (name, age, grade, or cancel).

**_Nested cases statements for Update Choices_**

Based on the user's choice:

If the user selects 1 (Name), they are prompted to input a new name, updating the student's name via **updateStudent** in **studentManagement**. If the choice is 2 (Age), the user inputs a new age, updating the student's age. For choice 3 (Grade), the user inputs a new grade, updating the student's grade. If the user chooses 4 (Cancel), the update operation is aborted. An invalid choice displays an error message. ‘**scanner.nextLine()’** is used after **nextInt()** to consume the newline character left in the buffer, allowing proper input reading when using **nextLine()** later. This section offers users the flexibility to select the attribute they want to update for a specific student and facilitates the modification of that attribute accordingly.

This else-statement, continue from the if-statement (may find at the beginning of the case) will proceed to inform the user if the student, or the ID is not in the system.

**Case 3: View Student’s Detail**

This section of code handles the user's choice to view details of a specific student. It prompts the user to enter the ID of the student they want to view. After receiving the input, it uses **findStudentByID** from **studentManagement** to locate the student based on the provided ID. If the student is found (**foundStudent != null**), it displays the student's name, ID, age, and grade. If the student with the given ID is not found, it notifies the user accordingly. This functionality allows users to retrieve and view specific details of students stored in the system based on their IDs.

**Case 4: Deleting Student’s Information from the data-base**

This section of code is responsible for handling the user's choice to delete one or multiple students from the system. It prompts the user to enter student IDs separated by commas. After reading the input, it splits the string into an array (**idsArray**) using the comma as a delimiter. Subsequently, it iterates through each ID in the **idsArray**, parsing each string ID into an integer and adding it to the **studentIDs** list. Finally, it calls the **removeStudentsByID()** method from **studentManagement**, passing the list of student IDs to remove those specific students from the system. Once done, it displays a success message indicating the successful deletion of student data. This functionality allows users to remove multiple students by providing their IDs, offering flexibility in managing student records.

**Case 5: Exiting the program and Default**

This part of the code is responsible for handling the user's choice to exit the system. When the user selects option 5 from the menu, it displays an "Exiting..." message and breaks out of the switch statement. If the user enters any choice other than 1 to 5, it informs them about the invalid choice, prompting them to enter a valid option.

The **do-while loop** specifies that the loop should continue executing as long as the value of the variable **choice** is not equal to 5. This will keep the programming running within these loops unless the user choose to exit the program.

**_Class: Main.java_**

**Main** class contains a **main** method that calls the **main** method of the **AdministratorInterface** class. Within the **main** method, it invokes the **main** method of the **AdministratorInterface** class using **AdministratorInterface.main(args)**. This delegation redirects the program flow to the **AdministratorInterface** class, which likely contains the primary functionality and user interface of the application.

This class plays in the final role in constructing this application, which is why I place this in the last part of section (1).

**Section (2)**

In section (2), I will strive to cover the functions and features of this application.

**Purpose of this program**  
The Student Record Management System is designed to efficiently manage student information for educational institutions. It streamlines the process of recording, updating, viewing, and deleting student details, ensuring a streamlined and organized approach to handling student records within a university or educational setting.

**Main Menu:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/4c394f57-5008-49f8-bfde-59ff79d5658e)

The program is displaying the main menu for the Student Record Management System, offering various options for managing student data. You're prompted to enter a choice from 1 to 5 to perform specific actions within the system.

- Option 1 allows you to add a new student.
- Option 2 is for updating student information.
- Option 3 lets you view details of a specific student.
- Option 4 allows you to delete one or multiple students from the system.
- Option 5 is for exiting the program.

You can enter the number corresponding to the action you want to perform within the Student Record Management System.

1. **Add New Student:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/e3c5c885-2c68-43b1-bc5d-4137d51c2685)

As the user has successfully added a new student named ‘Thuta Tun’ with ID 13122005, age 17, and a grade of A\* into the system. The data was also saved to a text file, as indicated by the confirmation message.

Now, the user is presented with the main menu again and prompted to enter a choice (1 to 5) to perform further actions within the Student Record Management System.

Now, it is stored in the ‘student_data’ file.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/057ebb7a-fd23-460d-b98e-07e14f8740a5)

2. **Updating Student Information:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/4e8d513a-ad18-458d-a69c-f9924cc69f64)

As option 2 is being selected it will identify the student information of the provided student ID (13122005) in the system to locate the corresponding student.

The system has successfully identified the student (Thuta Tun) based on the provided ID and displayed their current information, including name, ID, age, and grade.

Now, you're prompted to choose an option from 1 to 4:

- Option 1 allows you to update the student's name.
- Option 2 enables the modification of the student's age.
- Option 3 offers the possibility to update the student's grade.
- Option 4 allows you to cancel the update process.

Here, only one option will be demonstrated:

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/90d4e57c-5553-4d6c-bdb1-cb9ba0dc4d88)

Option 3 to update the student’s grade is being chosen. After inputting the new grade (A\*\*), the system successfully processed the update and confirmed the successful modification of the grade.

Then, you will with the main menu again.

This will also be updated on the data-base file.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/7d5cb487-0181-4d2b-a4c5-261aac887961)

3. **View Student Details:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/17d71aaf-b4dc-445a-aa7f-455e450f6392)

Here, option 3 is being chosen to view student details and provided the student ID (13122005) to access the specific student's information.

The system successfully retrieved and displayed the details for the student with ID 13122005:

- Name: Thuta Tun
- ID: 13122005
- Age: 17
- Grade: A\*\*

Then, you will be presented back to the main menu.

**_Note:_** _Now, I will register three more students into the system for the demonstration for the deleting feature._

4. **Delete a Student:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/a0186285-5cce-4eb6-8323-89e644ee189a)

I now have four students registered into the system.

I will remove one student, first.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/6baa45db-9b56-40ed-abf1-370ff5d36b06)

As you can see, the student associated to ID: 121314 is no longer in the system.

Let’s try performing multiple the deletion of multiple students at the same time.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/01d1838b-f8dd-4b89-b56c-2eec5a36fbb6)

Selected option 4 to delete students from the system and provided a list of student IDs (111222333, 786786786, 13122005) for deletion.

The system successfully processed the deletion of the specified students and confirmed the removal by displaying the message “Student's Data Deleted Successfully!”

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/89986a42-4425-44cd-a37f-45dc893e09e9)

Additionally, the student data was saved to a text file after the deletion process.

**Error Handling**

**_Invalid Input Handling:_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/b0a4bba2-250b-4e0e-994a-231f9efc5f5b)

There was an attempt to input option 6, which isn't among the valid options (1 to 5) provided in the Student Record Management System's main menu. The system recognized this as an invalid choice and displayed a message: “Invalid choice. Please enter a valid option.”

**_ID Uniqueness Check:_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/d3461711-9f3a-4639-b92d-2c7e4c814014)

The system correctly detects that the entered student ID (**13122005**) already exists and prompts the user with the message: “Student ID already exists. Please choose a different ID.” This prevents the addition of a new student with a duplicate ID, ensuring that each student ID in the system remains unique. It prompts the user to choose a different ID when attempting to add a student with an ID that's already in use.

**_Student Not Found:_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/e85ff85e-cecb-43b2-83bc-2c33785881ae)

The program is handling the scenario where a user tries to view the details of a student with an ID that doesn't exist in the system. The error message displayed—“Student with ID 1312 not found”—informs the user that the student with the specified ID (**1312**) was not found in the system. This provides informative feedback to the user, indicating that the requested student record doesn't exist in the database.

**Exit:**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/6e5e93a5-1d50-4c95-a9fb-39fd99d769f2)

When the user chooses to exit the Student Record Management System. The program displays the message "Exiting..." to indicate that the system is being exited. Additionally, it confirms that the student data has been saved to the file before exiting, ensuring that any modifications made during the session are stored in the file (**student_data.txt** or a similar file name).

So, this is the end of documentation.
