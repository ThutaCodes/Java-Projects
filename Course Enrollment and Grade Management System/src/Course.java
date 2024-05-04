import java.util.HashMap;

class Course {

    // Class attributes
    private String courseCode; // Stores the course code
    private String courseName; // Stores the course name
    private int maxCapacity; // Stores the maximum capacity of students allowed in the course
    private int enrolledStudents; // Stores the number of currently enrolled students
    private HashMap<Student, Integer> grades; // Maps students to their grades in this course
    private HashMap<Student, Integer> credits; // Maps students to their credit values for this course

    private static int totalEnrolledStudents = 0; // Stores the total number of enrolled students across all courses
    private int creditValue; // Stores the credit value of the course

    // Constructor
    public Course(String courseCode, String courseName, int maxCapacity, int creditValue) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.creditValue = creditValue;
        this.enrolledStudents = 0;
        this.grades = new HashMap<>(); // Initializes the map for storing grades
        this.credits = new HashMap<>(); // Initializes the map for storing credits
    }

    // Getters for class attributes
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Method to increment the count of enrolled students if the course capacity allows
    public void incrementEnrolledStudents() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            totalEnrolledStudents++;
        } else {
            System.out.println("Course capacity reached. Cannot enroll more students.");
        }
    }

    // Method to set the grade of a student in this course
    public void setGrade(Student student, int grade) {
        if (grades.containsKey(student)) {
            grades.put(student, grade);
        } else {
            System.out.println("Student not enrolled in this course.");
        }
    }

    // Method to enroll a student in this course with a specific credit value
    public void enrollStudent(Student student, int creditValue) {
        if (enrolledStudents < maxCapacity) {
            if (!grades.containsKey(student)) {
                grades.put(student, 0); // Sets the initial grade to 0 for the student
                credits.put(student, creditValue); // Assigns credit value to the student
                enrolledStudents++;
                totalEnrolledStudents++;
            } else {
                System.out.println("Student is already enrolled in this course.");
            }
        } else {
            System.out.println("Course capacity reached. Cannot enroll more students.");
        }
    }

    // Method to calculate the overall grade of a student in this course
    public int calculateOverallGrade(Student student) {
        int totalCredits = credits.getOrDefault(student, 0); // Retrieves the credit value of the student
        int grade = grades.getOrDefault(student, 0); // Retrieves the grade of the student

        // Calculates the overall grade based on credits and grade (weighted average)
        return totalCredits > 0 ? grade * totalCredits / totalCredits : 0;
    }
}
