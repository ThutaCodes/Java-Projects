import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class representing the management system for courses and students
class CourseManagement {
    // List to store student objects
    private List<Student> studentList;

    // List to store course objects
    public static List<Course> courseList = new ArrayList<>(); // Initialization here

    // HashMap to store overall grades of students in different courses
    private HashMap<Student, HashMap<Course, Integer>> overallCourseGrades;

    // Constructor to initialize lists and map
    public CourseManagement() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        overallCourseGrades = new HashMap<>();
    }

    // Method to get the list of courses
    public static List<Course> getCourses() {
        return courseList;
    }


    // Method to assign a grade to a student for a specific course
    public void assignGrade(Student student, Course course, int grade) {
        if (courseList.contains(course)) {
            course.setGrade(student, grade);
            overallCourseGrades.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to calculate and display the overall grade of a student for each enrolled course
    public void calculateOverallGrade(Student student) {
        if (overallCourseGrades.containsKey(student)) {
            HashMap<Course, Integer> grades = overallCourseGrades.get(student);
            for (Course course : grades.keySet()) {
                int overallGrade = course.calculateOverallGrade(student);
                System.out.println("Overall grade for " + student.getName() + " in " + course.getCourseName() + ": " + overallGrade);
            }
        } else {
            System.out.println("No grades found for the student.");
        }
    }


    // Method to load course data from a text file


    private static final String COURSE_DATA_FILE = "C:/Users/User/IdeaProjects/Student Record Management System GUI/course_data.txt";

    // Updated method to load course data from file
    public static List<Course> loadCourseDataFromFile() {
        List<Course> courseList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(COURSE_DATA_FILE))) {
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
    public static void addCourse(String courseCode, String courseName, int maxCapacity, int creditValue) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity, creditValue);
        courseList.add(newCourse);

        // Write the updated course list to the file
        saveCourseDataToTextFile();
    }

    private static void saveCourseDataToTextFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(COURSE_DATA_FILE, true))) {
            for (Course course : courseList) {
                writer.println(
                        "Code: " + course.getCourseCode() + ", " +
                                "Name: " + course.getCourseName() + ", " +
                                "Capacity: " + course.getMaxCapacity() + ", " +
                                "Credit Value: " + course.getCreditValue()
                );
            }
            System.out.println("Course data saved to text file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Course> getCourseList() {
        return courseList;
    }
    public static boolean enrollStudent(Student student, Course course) {
        if (courseList.contains(course)) {
            if (course.enrollStudent(student)) {
                // Enroll the student in the course
                course.addStudent(student);
                System.out.println(student.getName() + " enrolled in " + course.getCourseName() + " successfully!");
            } else {
                System.out.println("Enrollment failed: Course is at full capacity.");
            }
        } else {
            System.out.println("Course not found.");
        }
        return false;
    }
}


