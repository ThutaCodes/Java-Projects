import java.io.Serializable;
//Bringing in the Serializable interface from the java.io package
//To convert into a stream of bytes, or data that can be easily stored, transmitted, or reconstructed.

public class Student implements Serializable {
//Declares a Java class named Student that implements the Serializable interface.

//Declaring private variables: name, ID, age, grade (within the student class).
    private String name; //variable of type String, likely storing the student's name
    private int ID; //an integer variable holding the student's identification number
    private int age; //an integer variable representing the student's age.
    private String grade; //a String variable that might store the student's grade level or academic standing.

    // Constructor for the Student class
    // Initializes a Student object with provided details
    public Student(String name, int ID, int age, String grade) {
        this.name = name; // Assigns the provided name to the name attribute
        this.ID = ID; // Assigns the provided ID to the ID attribute
        this.age = age; // Assigns the provided age to the age attribute
        this.grade = grade; // // Assigns the provided grade to the grade attribute
    }
    // Getter method to retrieve the student's name
    public String getName() {
        return name;
    }
    // Setter method to update the student's name
    public void setName(String name) {
        this.name = name;
    }
    // Getter method to retrieve the student's ID
    public int getID() {
        return ID;
    }
    // Setter method to update the student's ID
    public void setID(int ID) {
        this.ID = ID;
    }
    // Getter method to retrieve the student's age
    public int getAge() {
        return age;
    }
    // Setter method to update the student's age
    public void setAge(int age) {
        this.age = age;
    }
    // Getter method to retrieve the student's grade
    public String getGrade() {
        return grade;
    }
    // Setter method to update the student's grade
    public void setGrade(String grade) {
        this.grade = grade;
    }
}

