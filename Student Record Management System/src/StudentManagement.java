import java.io.*; // Importing the entire java.io package to access file handling, input and output streams, serialization, and more.
import java.util.ArrayList;
/*Importing Arraylist from 'java.util' package. This will allow to perform operations such as
adding, removing, and accessing elements within a resizable array-like structure
 */

public class StudentManagement { // Declaration of the StudentManagement class
    private ArrayList<Student> studentList; // Private attribute to hold a list of Student objects
    private int totalStudents; // Private variable to store the total number of students

    // Constructor for the StudentManagement class
    public StudentManagement() {
        this.studentList = new ArrayList<>(); // Initializes studentList as a new ArrayList
        this.totalStudents = 0; // Initializes totalStudents count to zero
    }

    // Method to add a student to the studentList
    public void addStudent(Student student) {
        if (!isStudentIdExists(student.getID())) {
            studentList.add(student); // Adds the student to the list
            totalStudents++; // Increments the totalStudents count
            saveStudentDataToTextFile(); // Save data after addition
        } else {
            System.out.println("Student ID already exists. Please choose a different ID.");
        }
    }
    // Method to check if a student ID already exists in the studentList
    private boolean isStudentIdExists(int id) {
        for (Student student : studentList) {
            if (student.getID() == id) {
                return true; // Returns true if the ID already exists
            }
        }
        return false; // Returns false if the ID does not exist
    }

    // Method to update student details based on ID
    public void updateStudent(int ID, String newName, int newAge, String newGrade) {
        for (Student student : studentList) { // Iterates through the studentList
            if (student.getID() == ID) { // Checks if the student's ID matches the provided ID
                // Updates the student's name, age and grade
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                break; // Stops the loop after update
            }
        }
    }

    // Method to find a student based on their ID
    public Student findStudentByID(int ID) {
        for (Student student : studentList) { // Iterates through the studentList
            if (student.getID() == ID) { // Checks if the student's ID matches the provided ID
                return student; // Returns the student if found
            }
        }
        return null; // Returns null if the student with the provided ID is not found
    }

    // Method to save student data to a file
    public void saveStudentDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student_data.ser"))) {
            outputStream.writeObject(studentList);  // Writes the studentList to the file
            System.out.println("Student data saved to file."); // Display confirmation message
        } catch (IOException e) {
            e.printStackTrace(); // Handles any IOException that might occur during file writing
        }
    }

    @SuppressWarnings("unchecked") //To suppress unchecked warnings at a method, class, or variable level
    // Method to load student data from a file
    public void loadStudentDataFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student_data.ser"))) {
            studentList = (ArrayList<Student>) inputStream.readObject(); // Reads and casts the serialized object back to an ArrayList of Students
            totalStudents = studentList.size();  // Updates the totalStudents count based on the loaded data
            System.out.println("Student data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Handles any IOException or ClassNotFoundException that might occur during file reading
        }
    }
    // Method to remove students by their IDs
    public void removeStudentsByID(ArrayList<Integer> studentIDs) {
        ArrayList<Student> studentsToRemove = new ArrayList<>(); // Creates a new ArrayList to store students to be removed
        for (int id : studentIDs) { // Iterates through the provided list of student IDs
            Student student = findStudentByID(id); // Finds the student based on the ID
            if (student != null) { // Checks if the student exists
                studentsToRemove.add(student); // Adds the student to the list of students to be removed
            }
        }
        studentList.removeAll(studentsToRemove); // Removes all students in studentsToRemove from studentList
        saveStudentDataToTextFile(); // Save data after removal
    }
    // Method to save student data to a text file
    public void saveStudentDataToTextFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("student_data.txt"))) {
            for (Student student : studentList) { // Iterates through the studentList
                writer.println(
                        "Name: " + student.getName() + ", " + "ID: " + student.getID() + ", " + "Age: " + student.getAge() + ", " + "Grade: " + student.getGrade()
                ); // This will be the format of the information you will see in .txt file.
            }

            System.out.println("Student data saved to text file.");  // Displays a message confirming successful data is stored:
        } catch (IOException e) { // Handles any IOException that might occur during file writing
            e.printStackTrace();
        }
    }
}


