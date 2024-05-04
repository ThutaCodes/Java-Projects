import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class representing the management system for courses and students
class CourseManagement {
    // List to store student objects
    private List<Student> studentList;
    // List to store course objects
    private List<Course> courseList;
    // HashMap to store overall grades of students in different courses
    private HashMap<Student, HashMap<Course, Integer>> overallCourseGrades;

    // Constructor to initialize lists and map
    public CourseManagement() {
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        overallCourseGrades = new HashMap<>();
    }

    // Method to get the list of courses
    public List<Course> getCourses() {
        return courseList;
    }

    // Method to add a new course to the course list
    public void addCourse(String courseCode, String courseName, int maxCapacity, int creditValue) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity, creditValue);
        courseList.add(newCourse);
    }

    // Method to enroll a student in a course
    public void enrollStudent(Student student, Course course) {
        if (courseList.contains(course)) {
            student.enrollCourse(course);
        } else {
            System.out.println("Course not found.");
        }
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
}
