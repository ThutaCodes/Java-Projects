// Import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Class responsible for the administrator interface
public class AdministratorInterface {
    // GUI components and variables declaration
    private static JFrame frame; // Main window
    private static JPanel mainPanel; // Main panel to hold components
    private static StudentManagement studentManagement; // Class handling student data
    private static GridBagConstraints gbc; // Used for GridBagLayout positioning
    private static List<Course> coursesList;
    private static List<Student> studentsList = new ArrayList<>();
    private static List<Student> studentList;

    // Create a list of students and courses
    List<Student> students = Student.getStudents();
    List<Course> courses = CourseManagement.getCourses();

    // Main method
    public static void main(String[] args) {
        // Initialize the main window
        frame = new JFrame("Student Record Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for the main panel

        // Components for the main menu
        String[] choices = {"Select an option", "Add New Student", "Update Student Information", "View Student Details", "Delete a student", "Add a New Course", "Enroll a Student to a Course", "Assign a Grade to a Student"};
        JComboBox<String> choiceBox = new JComboBox<>(choices); // Dropdown for options
        JButton submitButton = new JButton("Submit"); // Button to submit selection
        JTextArea outputArea = new JTextArea(15, 40); // Area to display output
        JScrollPane scrollPane = new JScrollPane(outputArea); // Scrollable area for output

        // Initialize GridBag constraints
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Add components to the main panel
        mainPanel.add(choiceBox, gbc);

        gbc.gridy = 1;
        mainPanel.add(submitButton, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // Add the main panel to the frame and display it
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Initialize the StudentManagement object and load student data
        studentManagement = new StudentManagement();
        studentManagement.loadStudentDataFromFile();



        // ActionListener for the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected choice index
                int choice = choiceBox.getSelectedIndex();

                // Switch case based on the selected choice
                switch (choice) {
                    case 1:
                        // Add New Student
                        JPanel addStudentPanel = new JPanel();
                        JLabel nameLabel = new JLabel("Enter student name:");
                        JTextField nameField = new JTextField(15);
                        JLabel idLabel = new JLabel("Enter student ID:");
                        JTextField idField = new JTextField(5);
                        JLabel ageLabel = new JLabel("Enter student age:");
                        JTextField ageField = new JTextField(3);
                        JLabel gradeLabel = new JLabel("Enter student grade:");
                        JTextField gradeField = new JTextField(5);
                        JButton addStudentButton = new JButton("Add Student");

                        addStudentPanel.add(nameLabel);
                        addStudentPanel.add(nameField);
                        addStudentPanel.add(idLabel);
                        addStudentPanel.add(idField);
                        addStudentPanel.add(ageLabel);
                        addStudentPanel.add(ageField);
                        addStudentPanel.add(gradeLabel);
                        addStudentPanel.add(gradeField);
                        addStudentPanel.add(addStudentButton);

                        addStudentPanel.setLayout(new GridBagLayout());

                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing between components


                        addStudentPanel.add(nameLabel, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(nameField, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(idLabel, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(idField, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(ageLabel, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(ageField, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(gradeLabel, gbc);

                        gbc.gridy++;
                        addStudentPanel.add(gradeField, gbc);

                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.CENTER; // Set the anchor to center for the button
                        addStudentPanel.add(addStudentButton, gbc);
                        addStudentButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Get input from text fields
                                String name = nameField.getText();
                                int id = Integer.parseInt(idField.getText());
                                int age = Integer.parseInt(ageField.getText());
                                String grade = gradeField.getText();

                                // Create a new Student object with input values
                                Student newStudent = new Student(name, id, age, grade);
                                // Logic to add the new student to the system using studentManagement.addStudent(newStudent);
                                boolean addedSuccessfully = studentManagement.addStudent(newStudent);

                                // Update GUI or display message indicating successful addition or error using a JOptionPane
                                if (addedSuccessfully) {
                                    JOptionPane.showMessageDialog(frame, "New student added: " + newStudent.getName() + " (ID: " + newStudent.getID() + ")");
                                    // Save student data to the file after adding a new student
                                    List<Student> studentList = StudentManagement.getAllStudents(); // Retrieve the updated student list
                                    StudentManagement.saveStudentDataToTextFile(studentList);
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Student ID already exists. Please choose a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                        JButton backButton = new JButton("Back");
                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.PAGE_END; // Align the button to the bottom
                        addStudentPanel.add(backButton, gbc);

                        backButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Clear the current panel components
                                addStudentPanel.removeAll();
                                // Re-add the main menu components to the main panel
                                frame.getContentPane().removeAll();
                                frame.add(mainPanel);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });
                        frame.getContentPane().removeAll();
                        frame.add(addStudentPanel);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    case 2:
                        // Update Student Information panel
                        JPanel updateStudentPanel = new JPanel();
                        JLabel updateLabel = new JLabel("Enter student ID to update:");
                        JTextField updateIDField = new JTextField(5);
                        updateIDField.setPreferredSize(new Dimension(100, updateIDField.getPreferredSize().height)); // Adjust width
                        JButton updateButton = new JButton("Update Information");
                        JTextArea updateOutputArea = new JTextArea(10, 30);

                        updateStudentPanel.add(updateLabel);
                        updateStudentPanel.add(updateIDField);
                        updateStudentPanel.add(updateButton);
                        updateStudentPanel.add(new JScrollPane(updateOutputArea));

                        updateStudentPanel.setLayout(new GridBagLayout());
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.insets = new Insets(10, 10, 10, 10); // Adjust insets for spacing

                        updateStudentPanel.add(updateLabel, gbc);

                        gbc.gridy++;
                        updateStudentPanel.add(updateIDField, gbc);

                        gbc.gridy++;
                        updateStudentPanel.add(updateButton, gbc);

                        gbc.gridy++;
                        gbc.fill = GridBagConstraints.BOTH; // Allow the text area to expand
                        gbc.weightx = 1.0;
                        gbc.weighty = 0.5;

                        JScrollPane scrollPane = new JScrollPane(updateOutputArea);
                        scrollPane.setPreferredSize(new Dimension(300, 100));
                        updateStudentPanel.add(scrollPane, gbc);

                        updateButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int updateID;
                                try {
                                    updateID = Integer.parseInt(updateIDField.getText());
                                } catch (NumberFormatException ex) {
                                    updateOutputArea.append("Please enter a valid student ID.\n");
                                    return;
                                }

                                Student studentToUpdate = studentManagement.findStudentByID(updateID);
                                if (studentToUpdate != null) {
                                    // Display current information
                                    updateOutputArea.setText("Student found. Current information:\n");
                                    updateOutputArea.append("Name: " + studentToUpdate.getName() + "\n");
                                    updateOutputArea.append("ID: " + studentToUpdate.getID() + "\n");
                                    updateOutputArea.append("Age: " + studentToUpdate.getAge() + "\n");
                                    updateOutputArea.append("Grade: " + studentToUpdate.getGrade() + "\n");

                                    // Prompt user for information to update
                                    String[] options = {"Name", "Age", "Grade", "Cancel"};
                                    String updateChoice = (String) JOptionPane.showInputDialog(
                                            null,
                                            "What would you like to update?",
                                            "Update Student",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            options,
                                            options[0]);

                                    if (updateChoice != null && !updateChoice.equals("Cancel")) {
                                        String newValue = JOptionPane.showInputDialog("Enter the new " + updateChoice.toLowerCase() + ":");
                                        if (newValue != null && !newValue.isEmpty()) {
                                            switch (updateChoice) {
                                                case "Name":
                                                    studentManagement.updateStudent(updateID, newValue, studentToUpdate.getAge(), studentToUpdate.getGrade());
                                                    break;
                                                case "Age":
                                                    int newAge = Integer.parseInt(newValue);
                                                    studentManagement.updateStudent(updateID, studentToUpdate.getName(), newAge, studentToUpdate.getGrade());
                                                    break;
                                                case "Grade":
                                                    studentManagement.updateStudent(updateID, studentToUpdate.getName(), studentToUpdate.getAge(), newValue);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            updateOutputArea.append(updateChoice + " updated successfully.\n");
                                        } else {
                                            updateOutputArea.append("Invalid " + updateChoice.toLowerCase() + ". Update canceled.\n");
                                        }
                                    } else {
                                        updateOutputArea.append("Update canceled.\n");
                                    }
                                } else {
                                    updateOutputArea.append("Student with ID " + updateID + " not found.\n");
                                }
                            }
                        });

                        JButton backButtonUpdate = new JButton("Back");
                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.PAGE_END;
                        updateStudentPanel.add(backButtonUpdate, gbc);
                        backButtonUpdate.setPreferredSize(new Dimension(80, 30)); // Adjust width and height as needed

                        backButtonUpdate.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                // Code to go back to the main menu
                                frame.getContentPane().removeAll();
                                frame.add(mainPanel);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });


                        frame.getContentPane().removeAll();
                        frame.add(updateStudentPanel);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    case 3:
                        // View Student Details
                        JPanel viewStudentPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.insets = new Insets(10, 10, 10, 10); // Adjust insets for spacing

                        JLabel viewLabel = new JLabel("Enter student ID to view details:");
                        JTextField viewIDField = new JTextField(5);
                        JButton viewButton = new JButton("View Details");
                        JTextArea viewOutputArea = new JTextArea(5, 20);

                        viewStudentPanel.add(viewLabel, gbc);

                        gbc.gridy++;
                        viewStudentPanel.add(viewIDField, gbc);

                        gbc.gridy++;
                        viewStudentPanel.add(viewButton, gbc);

                        gbc.gridy++;
                        gbc.fill = GridBagConstraints.BOTH;
                        gbc.weightx = 1.0;
                        gbc.weighty = 0.5;
                        viewStudentPanel.add(new JScrollPane(viewOutputArea), gbc);

                        viewButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int viewID;
                                try {
                                    viewID = Integer.parseInt(viewIDField.getText());
                                } catch (NumberFormatException ex) {
                                    viewOutputArea.append("Please enter a valid student ID.\n");
                                    return;
                                }

                                // Retrieve student details based on ID
                                Student foundStudent = studentManagement.findStudentByID(viewID);
                                if (foundStudent != null) {
                                    // Display details of the found student
                                    viewOutputArea.setText("Student Details:\n");
                                    viewOutputArea.append("Name: " + foundStudent.getName() + "\n");
                                    viewOutputArea.append("ID: " + foundStudent.getID() + "\n");
                                    viewOutputArea.append("Age: " + foundStudent.getAge() + "\n");
                                    viewOutputArea.append("Grade: " + foundStudent.getGrade() + "\n");
                                } else {
                                    viewOutputArea.append("Student with ID " + viewID + " not found.\n");
                                }
                            }
                        });

                        JButton backButtonView = new JButton("Back");
                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.PAGE_END;
                        viewStudentPanel.add(backButtonView, gbc);

                        backButtonView.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.getContentPane().removeAll(); // Clear current content
                                frame.add(mainPanel); // Add the main menu panel
                                frame.revalidate(); // Refresh the frame
                                frame.repaint();
                            }
                        });

                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(viewStudentPanel); // Add the viewStudentPanel to the content pane
                        frame.revalidate();
                        frame.repaint();
                        break;
                    case 4:
                        // Delete a student from the system
                        JPanel deleteStudentPanel = new JPanel();
                        JLabel deleteLabel = new JLabel("Enter student IDs to delete (comma-separated if more than one):");
                        JTextField deleteIDField = new JTextField(20);
                        JButton deleteButton = new JButton("Delete Students");
                        JTextArea deleteOutputArea = new JTextArea(10, 30);

                        deleteStudentPanel.add(deleteLabel);
                        deleteStudentPanel.add(deleteIDField);
                        deleteStudentPanel.add(deleteButton);
                        deleteStudentPanel.add(new JScrollPane(deleteOutputArea));

                        deleteButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String[] idsArray = deleteIDField.getText().split(",");
                                ArrayList<Integer> studentIDs = new ArrayList<>();

                                for (String studentID : idsArray) {
                                    try {
                                        int id = Integer.parseInt(studentID.trim());
                                        studentIDs.add(id);
                                    } catch (NumberFormatException ex) {
                                        deleteOutputArea.append("Invalid student ID: " + studentID.trim() + "\n");
                                    }
                                }

                                studentManagement.removeStudentsByID(studentIDs);

                                deleteOutputArea.append("Students' Data Deleted Successfully!\n");
                            }
                        });

                        deleteStudentPanel.setLayout(new GridBagLayout());
                        GridBagConstraints gbcDelete = new GridBagConstraints();
                        gbcDelete.gridx = 0;
                        gbcDelete.gridy = 0;
                        gbcDelete.anchor = GridBagConstraints.CENTER;
                        gbcDelete.insets = new Insets(10, 10, 10, 10); // Adjust insets for spacing

                        deleteStudentPanel.add(deleteLabel, gbcDelete);

                        gbcDelete.gridy++;
                        deleteStudentPanel.add(deleteIDField, gbcDelete);

                        gbcDelete.gridy++;
                        deleteStudentPanel.add(deleteButton, gbcDelete);

                        gbcDelete.gridy++;
                        gbcDelete.fill = GridBagConstraints.BOTH; // Allow the text area to expand
                        gbcDelete.weightx = 1.0;
                        gbcDelete.weighty = 1.0;
                        deleteStudentPanel.add(new JScrollPane(deleteOutputArea), gbcDelete);


                        JButton backButtonDelete = new JButton("Back");
                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.PAGE_END;
                        deleteStudentPanel.add(backButtonDelete, gbc);

                        backButtonDelete.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.getContentPane().removeAll(); // Clear current content
                                frame.add(mainPanel); // Add the main menu panel
                                frame.revalidate(); // Refresh the frame
                                frame.repaint();
                            }
                        });

                        frame.getContentPane().removeAll();
                        frame.add(deleteStudentPanel);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    case 5:
                    JPanel addNewCoursePanel = new JPanel();
                    JLabel courseCodeLabel = new JLabel("Enter course code:");
                    JTextField courseCodeField = new JTextField(10);
                    JLabel courseNameLabel = new JLabel("Enter course name:");
                    JTextField courseNameField = new JTextField(15);
                    JLabel courseCapacityLabel = new JLabel("Enter maximum capacity:");
                    JTextField courseCapacityField = new JTextField(5);
                    JLabel creditValueLabel = new JLabel("Enter credit value:");
                    JTextField creditValueField = new JTextField(5);
                    JButton addCourseButton = new JButton("Add Course");

                    addNewCoursePanel.setLayout(new GridBagLayout());
                    GridBagConstraints gbcCourse = new GridBagConstraints();
                    gbcCourse.gridx = 0;
                    gbcCourse.gridy = 0;
                    gbcCourse.insets = new Insets(5, 5, 5, 5); // Add some spacing between components

                    addNewCoursePanel.add(courseCodeLabel, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(courseCodeField, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(courseNameLabel, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(courseNameField, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(courseCapacityLabel, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(courseCapacityField, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(creditValueLabel, gbcCourse);
                    gbcCourse.gridy++;
                    addNewCoursePanel.add(creditValueField, gbcCourse);
                    gbcCourse.gridy++;
                    gbcCourse.anchor = GridBagConstraints.CENTER; // Set the anchor to center for the button
                    addNewCoursePanel.add(addCourseButton, gbcCourse);

                    addCourseButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Get input from text fields
                            String code = courseCodeField.getText();
                            String name = courseNameField.getText();
                            int capacity = Integer.parseInt(courseCapacityField.getText());
                            int creditValue = Integer.parseInt(creditValueField.getText());

                            // Add the course to the system using courseManagement.addCourse
                            CourseManagement.addCourse(code, name, capacity, creditValue);
                            addCourseButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    // Get input from text fields
                                    String code = courseCodeField.getText();
                                    String name = courseNameField.getText();
                                    int capacity = Integer.parseInt(courseCapacityField.getText());
                                    int creditValue = Integer.parseInt(creditValueField.getText());

                                    // Add the course to the system using courseManagement.addCourse
                                    CourseManagement.addCourse(code, name, capacity, creditValue);

                                    // Display success message
                                    JOptionPane.showMessageDialog(frame, "Course added successfully: " + name + " (" + code + ") to the course data file.");
                                }
                            });
                            // Display success message
                            JOptionPane.showMessageDialog(frame, "Course added successfully: " + name + " (" + code + ")");
                        }
                    });

                    JButton backCourseButton = new JButton("Back");
                    gbcCourse.gridy++;
                    gbcCourse.anchor = GridBagConstraints.PAGE_END; // Align the button to the bottom
                    addNewCoursePanel.add(backCourseButton, gbcCourse);

                    backCourseButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Clear the current panel components
                            addNewCoursePanel.removeAll();
                            // Re-add the main menu components to the main panel
                            frame.getContentPane().removeAll();
                            frame.add(mainPanel);
                            frame.revalidate();
                            frame.repaint();
                        }
                    });

                    frame.getContentPane().removeAll();
                    frame.add(addNewCoursePanel);
                    frame.revalidate();
                    frame.repaint();
                    break;

                    case 6:
                        outputArea.setText(""); // Clear previous output

                        JFrame enrollFrame = new JFrame("Enroll Student");
                        JPanel enrollPanel = new JPanel(new GridLayout(4, 2));

                        JTextField studentNameField = new JTextField();
                        JTextField studentIDField = new JTextField();
                        courseCodeField = new JTextField();
                        enrollPanel.add(new JLabel("Student Name:"));
                        enrollPanel.add(studentNameField);
                        enrollPanel.add(new JLabel("Student ID:"));
                        enrollPanel.add(studentIDField);
                        enrollPanel.add(new JLabel("Course Code:"));
                        enrollPanel.add(courseCodeField);

                        JButton enrollButton = new JButton("Enroll");
                        enrollPanel.add(enrollButton);

                        enrollButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String studentName = studentNameField.getText();
                                int studentID = Integer.parseInt(studentIDField.getText());
                                String courseCode = courseCodeField.getText();
                                JTextField courseNameField = new JTextField();
                                String courseName = courseNameField.getText();
                                List<Student> studentList = new ArrayList<>();
                                // Assuming you have a method to enroll a student in a course
                                boolean enrollmentSuccess = enrollStudentInCourse(studentName, studentID, courseCode, courseName);

                                if (enrollmentSuccess) {
                                    String message = "Successfully Enrolled " + studentName + " in " + courseCode + " - " + courseName;
                                    JOptionPane.showMessageDialog(null, message, "Enrollment Successful", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Enrollment failed. Please check the details.", "Enrollment Failed", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                            private boolean enrollStudentInCourse(String studentName, int studentID, String courseCode, String courseName) {
                                Student student = Student.getStudentByName(studentList, studentName);
                                Course course = Course.findCourse(courseCode);

                                if (student != null && student.getID() == studentID && course != null) {
                                    return CourseManagement.enrollStudent(student, course); // Assuming enrollStudent returns a boolean
                                }

                                return false; // Enrollment failed
                            }
                        });



                        enrollFrame.add(enrollPanel);
                        enrollFrame.pack();
                        enrollFrame.setLocationRelativeTo(null);
                        enrollFrame.setVisible(true);
                        break;





                    case 7:
                        // Assign Grade
                        JPanel assignGradePanel = new JPanel();
                        JLabel nameLabel7 = new JLabel("Enter student name:");
                        JTextField nameField7 = new JTextField(15);
                        JLabel idLabel7 = new JLabel("Enter student ID:");
                        JTextField idField7 = new JTextField(5);
                        JLabel courseLabel7 = new JLabel("Enter course code:");
                        JTextField courseField7 = new JTextField(5);
                        JLabel gradeLabel7 = new JLabel("Enter grade:");
                        JTextField gradeField7 = new JTextField(5);
                        JButton assignGradeButton = new JButton("Assign Grade");

                        assignGradePanel.add(nameLabel7);
                        assignGradePanel.add(nameField7);
                        assignGradePanel.add(idLabel7);
                        assignGradePanel.add(idField7);
                        assignGradePanel.add(courseLabel7);
                        assignGradePanel.add(courseField7);
                        assignGradePanel.add(gradeLabel7);
                        assignGradePanel.add(gradeField7);
                        assignGradePanel.add(assignGradeButton);

                        assignGradePanel.setLayout(new GridBagLayout());
                        gbc = new GridBagConstraints();
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing between components
                        assignGradePanel.add(nameLabel7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(nameField7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(idLabel7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(idField7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(courseLabel7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(courseField7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(gradeLabel7, gbc);

                        gbc.gridy++;
                        assignGradePanel.add(gradeField7, gbc);

                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.CENTER; // Set the anchor to center for the button
                        assignGradePanel.add(assignGradeButton, gbc);


                        assignGradeButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String studentName = nameField7.getText();
                                int studentID = Integer.parseInt(idField7.getText());
                                String courseCode = courseField7.getText();
                                int grade = Integer.parseInt(gradeField7.getText());

                                Student student = Student.getStudentByName(studentList, studentName);
                                Course course = Course.findCourse(courseCode);

                                if (student != null && course != null) {
                                    course.setGrade(student, grade);
                                    JOptionPane.showMessageDialog(frame, "Grade assigned to " + student.getName() + " for " + course.getCourseName() + " successfully!");
                                    Course.saveStudentDataToTextFile(studentList); // Save updated student data including grades
                                    nameField7.setText(""); // Clear text fields
                                    idField7.setText("");
                                    courseField7.setText("");
                                    gradeField7.setText("");

                                    // Resetting the panel or updating labels
                                    JLabel successLabel = new JLabel("Grade assigned successfully!");
                                    successLabel.setForeground(Color.GREEN);

                                    JPanel updatedPanel = new JPanel();
                                    updatedPanel.add(successLabel);

                                    frame.getContentPane().removeAll();
                                    frame.add(updatedPanel);
                                    frame.revalidate();
                                    frame.repaint();
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Student or course not found.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                StudentManagement studentManager = new StudentManagement();
                                CourseManagement courseManager = new CourseManagement();
                                studentManager.loadStudentDataFromFile();
                                courseManager.loadCourseDataFromFile();

                                // Load student and course data from files
                                studentManager = new StudentManagement();
                                courseManager = new CourseManagement();
                                studentManager.loadStudentDataFromFile(); // Load student data from file
                                courseManager.loadCourseDataFromFile();   // Load course data from file

                                List<Student> studentList = studentManager.getStudentList();
                                List<Course> courseList = courseManager.getCourseList();
                            }
                        });
                        JButton backButton7 = new JButton("Back");
                        gbc.gridy++;
                        gbc.anchor = GridBagConstraints.PAGE_END; // Align the button to the bottom
                        assignGradePanel.add(backButton7, gbc);

                        backButton7.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Clear the current panel components
                                assignGradePanel.removeAll();
                                // Re-add the main menu components to the main panel
                                frame.getContentPane().removeAll();
                                frame.add(mainPanel);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });

                        frame.getContentPane().removeAll();
                        frame.add(assignGradePanel);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    default:
                        outputArea.append("Invalid choice. Please enter a valid option.\n");
                }
            }
        });
        JButton exitButton = new JButton("Exit");
        gbc.gridy++;
        mainPanel.add(exitButton, gbc);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the GUI window
            }
        });
    }
}