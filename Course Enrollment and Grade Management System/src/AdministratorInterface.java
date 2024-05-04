import java.util.Scanner;
class AdministratorInterface {
    private Scanner scanner; // Scanner object to handle user input
    private CourseManagement courseManagement; // Object to manage courses and student enrollments

    // Constructor initializes the scanner and course management system
    public AdministratorInterface() {
        scanner = new Scanner(System.in);
        courseManagement = new CourseManagement();
    }

    // Method to start the administrator interface
    public void startInterface() {
        boolean exit = false;

        // Loop to display menu and handle user input until the user chooses to exit
        while (!exit) {
            displayMenu(); // Display options
            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close(); // Close the scanner after use
    }

    // Display menu options
    private void displayMenu() {
        System.out.println("\n***** Administrator Interface *****");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student");
        System.out.println("3. Assign grade to a student");
        System.out.println("4. Calculate overall course grade for a student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new course
    private void addNewCourse() {
        System.out.println("\nAdding a new course...");
        // Gather course details from user input
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter credit value: ");
        int creditValue = scanner.nextInt();
        // Add the course to the course management system
        courseManagement.addCourse(code, name, capacity, creditValue);
        System.out.println("Course added successfully!");
    }

    // Method to enroll a student in a course
    private void enrollStudent() {
        // Gather student details and course code from user input
        System.out.println("\nEnrolling a student...");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = new Student(studentName, studentID);

        System.out.print("Enter course code to enroll the student: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);

        if (course != null) {
            courseManagement.enrollStudent(student, course);
            System.out.println(student.getName() + " enrolled in " + course.getCourseName() + " successfully!");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to assign a grade to a student for a specific course
    private void assignGrade() {
        System.out.println("\nAssigning grade to a student...");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = new Student(studentName, studentID);

        System.out.print("Enter course code to assign grade: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);

        if (course != null) {
            System.out.print("Enter grade for the student: ");
            int grade = scanner.nextInt();
            courseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned to " + student.getName() + " for " + course.getCourseName() + " successfully!");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to calculate the overall course grade for a student
    private void calculateOverallGrade() {
        System.out.println("\nCalculating overall course grade for a student...");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = new Student(studentName, studentID);

        courseManagement.calculateOverallGrade(student);
    }

    // Method to find a course by its code
    private Course findCourse(String code) {
        for (Course course : courseManagement.getCourses()) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
}
