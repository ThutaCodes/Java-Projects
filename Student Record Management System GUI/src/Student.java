import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Combined class representing a Student
public class Student implements Serializable {

    private String name; // Student's name
    private int ID; // Student's ID
    private int age; // Student's age
    private String grade; // Student's grade
    private List<Course> courses; // Courses the student is enrolled in
    private Map<Course, Integer> courseGrades; // Map to store course grades for the student

    private List<Student> studentList;
    // Constructor to initialize a Student object with provided values
    // Updated constructor to accept all parameters
    public Student(String name, int ID, int age, String grade) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.grade = grade;
        this.courses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    public static Student getStudentByName(List<Student> studentList, String studentName) {
        for (Student student : studentList) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null; // Return null if no student with the given name is found
    }


    // Getter method to retrieve the student's name
    public String getName() {
        return name;
    }

    // Setter method to set the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the student's ID
    public int getID() {
        return ID;
    }

    // Setter method to set the student's ID
    public void setID(int ID) {
        this.ID = ID;
    }

    // Getter method to retrieve the student's age
    public int getAge() {
        return age;
    }

    // Setter method to set the student's age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
    }

    // Setter method to set the student's grade
    public void setGrade(String grade) {
        if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Invalid grade. Grade must be A, B, C, D, or F.");
        }
    }

    // Getter method to retrieve the student's grade
    public String getGrade() {
        return grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        } else {
            throw new IllegalArgumentException("Student is already enrolled in this course.");
        }
    }

    // Method to remove a course from a student's schedule
    public void removeFromCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        } else {
            throw new IllegalArgumentException("Student is not enrolled in this course.");
        }
    }

    public Map<Course, Integer> getCourseGrades() {
        return new HashMap<>(courseGrades);
    }

    // Method to assign a grade for a course
    public void assignGradeForCourse(Course course, int grade) {
        courseGrades.put(course, grade);
    }

    // Method to retrieve grade for a course
    public int getGradeForCourse(Course course) {
        return courseGrades.getOrDefault(course, -1); // Default to -1 if no grade is assigned
    }


    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/IdeaProjects/Student Record Management System GUI/student_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    String name = data[0];
                    int id = Integer.parseInt(data[1].replaceAll("[^0-9]", ""));
                    int age = Integer.parseInt(data[2]);
                    String grade = data[3];
                    students.add(new Student(name, id, age, grade));
                } else {
                    // Handle incorrect format or incomplete data
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            // Handle file IO exception
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle number format exception
            e.printStackTrace();
        }

        return students;
    }

    // Method to extract numeric values from strings that might contain labels
    private static int extractNumericValue(String data) {
        // Split by space and take the last part which contains the number
        String[] parts = data.split("\\s+");
        return Integer.parseInt(parts[parts.length - 1]);
    }
}
