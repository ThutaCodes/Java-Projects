import java.util.Scanner; // To read input from various sources like files,or strings
import java.util.ArrayList;
/*Importing Arraylist from 'java.util' package. This will allow to perform operations such as
adding, removing, and accessing elements within a resizable array-like structure
 */

public class AdministratorInterface { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Creates a Scanner object named scanner to read input from the console (System.in)
        StudentManagement studentManagement = new StudentManagement();
        //Instantiating StudentManagement object named studentManagement, within a class handling student-related functionalities.
        int choice; //Defines an integer variable choice to hold user input.
        studentManagement.loadStudentDataFromFile();
        /*Invokes the loadStudentDataFromFile method from the studentManagement object,to load student
        data from the file when the program starts.*/

        //Registering a shutdown hook:
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            studentManagement.saveStudentDataToFile();
        }));
        do {
            System.out.println("Student Record Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Delete a student from the system");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // This will read user's input and assigns it in 'choice' variable.

            switch (choice) {
                // Adding a new student
                case 1:
                    System.out.println("Enter student name:");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();// Read student name
                    System.out.println("Enter student ID:");
                    int id = scanner.nextInt(); // Read student ID
                    System.out.println("Enter student age:");
                    int age = scanner.nextInt(); // Read student age
                    System.out.println("Enter student grade:");
                    scanner.nextLine(); // Consume the newline character
                    String grade = scanner.nextLine(); // Read student grade
                    Student newStudent = new Student(name, id, age, grade);
                    studentManagement.addStudent(newStudent);//// Create a new Student object with the provided parameters
                    studentManagement.saveStudentDataToTextFile(); // Save data to text file
                    break; //Exiting the case
                case 2:
                    // Updating student information
                    System.out.println("Enter student ID to update:");
                    int updateID = scanner.nextInt(); // Read the ID to update
                    Student studentToUpdate = studentManagement.findStudentByID(updateID);
                    if (studentToUpdate != null) { // Check if student exists
                        // If the student is found, display current information
                        System.out.println("Student found. Current information:");
                        System.out.println("Name: " + studentToUpdate.getName());
                        System.out.println("ID: " + studentToUpdate.getID());
                        System.out.println("Age: " + studentToUpdate.getAge());
                        System.out.println("Grade: " + studentToUpdate.getGrade());
                        // Prompt user for the information to update
                        System.out.println("What would you like to update?");
                        System.out. println("1. Name");
                        System.out.println("2. Age");
                        System.out.println("3. Grade");
                        System.out.println("4. Cancel");
                        System.out.print("Enter your choice: ");
                        int updateChoice = scanner.nextInt(); // Read user's choice
                        scanner.nextLine(); // Consume the newline character

                        switch (updateChoice) {
                            case 1: // Update student name
                                System.out.println("Enter new student name:");
                                String newName = scanner.nextLine(); // Read new name
                                // Update name
                                studentManagement.updateStudent(updateID, newName, studentToUpdate.getAge(), studentToUpdate.getGrade());
                                System.out.println("Name updated successfully.");
                                break;
                            case 2: // Update student age
                                System.out.println("Enter new student age:");
                                int newAge = scanner.nextInt(); // Read new age
                                scanner.nextLine(); // Consume the newline character
                                // Update age
                                studentManagement.updateStudent(updateID, studentToUpdate.getName(), newAge, studentToUpdate.getGrade());
                                System.out.println("Age updated successfully.");
                                break;
                            case 3:
                                System.out.println("Enter new student grade:");
                                String newGrade = scanner.nextLine(); //Read new grade
                                // Update grade
                                studentManagement.updateStudent(updateID, studentToUpdate.getName(), studentToUpdate.getAge(), newGrade);
                                System.out.println("Grade updated successfully.");
                                break;
                            case 4: // Cancel update operation
                                System.out.println("Update canceled.");
                                break;
                            default: // Handle invalid choice
                                System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Student with ID " + updateID + " not found."); //This will inform if the student is not in the system.
                    }
                    break;// Exiting case 2
                case 3: // User selected option to view student details
                    System.out.println("Enter student ID to view details:");
                    int viewID = scanner.nextInt(); // Read the student ID to view details
                    Student foundStudent = studentManagement.findStudentByID(viewID); // Find the student by ID
                    if (foundStudent != null) { // Check if student exists
                        // Display details of the found student
                        System.out.println("Student Details:");
                        System.out.println("Name: " + foundStudent.getName());
                        System.out.println("ID: " + foundStudent.getID());
                        System.out.println("Age: " + foundStudent.getAge());
                        System.out.println("Grade: " + foundStudent.getGrade());
                    } else {
                        //Displays if the student with the input ID is not found.
                        System.out.println("Student with ID " + viewID + " not found.");
                    }
                    break; // Exiting case 3
                case 4: // User selected option to delete a student or multiple students
                    System.out.println("Enter student IDs to delete (comma-separated):");
                    //Informing user that commas are necessary in deleting several students at the same time.
                    scanner.nextLine(); // Consume the newline character
                    String idInput = scanner.nextLine();// Read user input for student IDs
                    String[] idsArray = idInput.split(",");// Split input by comma to get individual IDsv
                    ArrayList<Integer> studentIDs = new ArrayList<>();// Create a list to store student IDs

                    // Loop through the array of IDs, parse and add them to the studentIDs list
                    for (String studentID : idsArray) {
                        // Parsing each ID and add to the list
                        studentIDs.add(Integer.parseInt(studentID.trim()));
                    }

                    studentManagement.removeStudentsByID(studentIDs);//method to remove students by their IDs
                    System.out.println("Student's Data Deleted Successfully!");//Inform deletion is successful
                    break;//Exiting case 4
                case 5:// Exiting the system
                    System.out.println("Exiting...");//Display exiting message
                    break;//Exiting case 5
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    // Informing the user about an invalid choice if the entered option is not recognized
            }
        } while (choice != 5); // Continue looping as long as the user's choice is not equal to 5 (exit)
    }
}
