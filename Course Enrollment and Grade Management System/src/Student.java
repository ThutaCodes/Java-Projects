import java.util.ArrayList;
import java.util.List;

// Class representing a Student
class Student {
    // Private attributes: name, ID, and a list of enrolled courses
    private String name;
    private int ID;
    private List<Course> enrolledCourses;

    // Constructor to initialize a Student object with a name and ID
    public Student(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.enrolledCourses = new ArrayList<>(); // Initializing the enrolledCourses list
    }

    // Getter method for the student's name
    public String getName() {
        return name;
    }

    // Getter method for the student's ID
    public int getID() {
        return ID;
    }

    // Getter method for the list of enrolled courses
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll a student in a course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course); // Add the course to the student's enrolled courses
        course.incrementEnrolledStudents(); // Increment the count of enrolled students in the course
    }

    // Method to set the grade for a course for the student
    public void setGradeForCourse(Course course, int grade) {
        // Loop through the enrolled courses to find the matching course
        for (Course enrolledCourse : enrolledCourses) {
            // Check if the enrolledCourse is equal to the provided course
            if (enrolledCourse.equals(course)) {
                enrolledCourse.setGrade(this, grade); // Set the grade for the student in that course
                return; // Exit the method after setting the grade
            }
        }
        // If the course is not found in the
    }
}