import java.io.*;
import java.util.*;
import java.util.List;
class Course {

    // Class attributes
    private String courseCode; // Stores the course code
    private String courseName; // Stores the course name
    private int maxCapacity; // Stores the maximum capacity of students allowed in the course
    private int enrolledStudents; // Stores the number of currently enrolled students
    private HashMap<Student, Integer> grades; // Maps students to their grades in this course
    private HashMap<Student, Integer> credits; // Maps students to their credit values for this course

    private Map<Course, Integer> courseGrades;
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

    public int getCreditValue() {
        return creditValue;
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
    public static Course findCourse(String code) {
        List<Course> courses = loadCourseDataFromFile(); // Assuming loadCourseDataFromFile() returns a list of courses
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null; // Course not found
    }

    public static List<Course> loadCourseDataFromFile() {
        List<Course> courseList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/IdeaProjects/Student Record Management System GUI/course_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    String code = data[0].substring(data[0].indexOf(": ") + 2);
                    String name = data[1].substring(data[1].indexOf(": ") + 2);
                    int maxCapacity = Integer.parseInt(data[2].substring(data[2].indexOf(": ") + 2));
                    int creditValue = Integer.parseInt(data[3].substring(data[3].indexOf(": ") + 2));
                    Course course = new Course(code, name, maxCapacity, creditValue);
                    courseList.add(course);
                }
            }
            System.out.println("Course data loaded from file.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return courseList;
    }
    // Method to get the grade for a specific course
    public int getGradeForCourse(Course course) {
        return courseGrades.getOrDefault(course, 0); // Default to 0 if no grade is assigned
    }

    public void assignGrade(Course course, int grade) {
        courseGrades.put(course, grade);
    }
    public static void saveStudentDataToTextFile(List<Student> studentList) {
        String filePath = "C:/Users/User/IdeaProjects/Student Record Management System GUI/StudentsGrade.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Student student : studentList) {
                writer.println("Name: " + student.getName() + ", ID: " + student.getID() + ", Age: " + student.getAge());

                Map<Course, Integer> courseGrades = student.getCourseGrades();

                if (courseGrades != null && !courseGrades.isEmpty()) {
                    writer.println("Course Grades:");
                    for (Map.Entry<Course, Integer> entry : courseGrades.entrySet()) {
                        Course course = entry.getKey();
                        int grade = entry.getValue();
                        writer.println("   Course: " + course.getCourseCode() + ", Grade: " + grade);
                    }
                }
                writer.println();
            }
            System.out.println("Student data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean enrollStudent(Student student) {
        if (enrolledStudents < maxCapacity) {
            if (!grades.containsKey(student)) {
                grades.put(student, 0); // Sets the initial grade to 0 for the student
                credits.put(student, creditValue); // Assigns credit value to the student
                enrolledStudents++;
                totalEnrolledStudents++;
                return true; // Enrollment successful
            } else {
                System.out.println("Student is already enrolled in this course.");
                return false; // Enrollment failed: Student already enrolled
            }
        } else {
            System.out.println("Course capacity reached. Cannot enroll more students.");
            return false; // Enrollment failed: Course at full capacity
        }
    }

    public void addStudent(Student student) {
    }
}



