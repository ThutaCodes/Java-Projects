import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*; // Importing the entire java.io package to access file handling, input and output streams, serialization, and more.
import java.util.ArrayList;
import java.util.List;
/*Importing Arraylist from 'java.util' package. This will allow to perform operations such as
adding, removing, and accessing elements within a resizable array-like structure
 */

public class StudentManagement { // Declaration of the StudentManagement class
    private ArrayList<Student> studentList; // Private attribute to hold a list of Student objects
    private int totalStudents; // Private variable to store the total number of students
    private static List<Student> students;

    private static String FILE_PATH = "C:/Users/User/IdeaProjects/Student Record Management System GUI/student_data.txt";
    // Constructor for the StudentManagement class
    public StudentManagement() {
        this.studentList = new ArrayList<>(); // Initializes studentList as a new ArrayList
        this.totalStudents = 0; // Initializes totalStudents count to zero
    }

    public static void saveStudentDataToTextFile(List<Student> studentList) {
    }
    // Method to add a student to the studentList
    public boolean addStudent(Student student) {
        if (!isStudentIdExists(student.getID())) {
            studentList.add(student);
            totalStudents++;
            saveStudentDataToTextFile(); // Save data after addition
            return true;
        } else {
            System.out.println("Student ID already exists. Please choose a different ID.");
            return false;
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
        for (Student student : studentList) {
            if (student.getID() == ID) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                saveStudentDataToTextFile(); // Save the updated data to the text file
                break;
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

    @SuppressWarnings("unchecked")

    public void loadStudentDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    String name = data[0].substring(data[0].indexOf(": ") + 2);
                    int id = Integer.parseInt(data[1].substring(data[1].indexOf(": ") + 2));
                    int age = Integer.parseInt(data[2].substring(data[2].indexOf(": ") + 2));
                    String grade = data[3].substring(data[3].indexOf(": ") + 2);

                    // Create Student objects with all parameters
                    Student student = new Student(name, id, age, grade);

                    // Ensure studentList is initialized and add students to it
                    if (this.studentList == null) {
                        this.studentList = new ArrayList<>(); // Initialize if not already initialized
                    }
                    this.studentList.add(student);
                }
            }
            System.out.println("Student data loaded from file.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
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
    private void saveStudentDataToTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : studentList) {
                String studentData = String.format(
                        "Name: %s, ID: %s, Age: %d, Grade: %s%n",
                        student.getName(), student.getID(), student.getAge(), student.getGrade()
                );
                writer.write(studentData);
            }
            System.out.println("Student data saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public static List<Student> getAllStudents() {
        if (students != null) {
            return new ArrayList<>(students); // Return a copy of the students list
        } else {
            // If students list is null, handle the situation accordingly
            return new ArrayList<>(); // Return an empty list or handle as appropriate
        }
    }


}


