**Reading Data and Storing in a Collection**

This project is centered on the effective management and processing of employee data in a business setting. The goal is to utilize the strengths of Java, particularly the Function interface and streams, to manage a dataset filled with essential employee details. The main task is to flawlessly read this dataset from a file and systematically store this data into an appropriate collection. This section of the documentation explores the complexities of this procedure, emphasizing the careful steps taken to guarantee precise data retrieval, organization, and storage within the software. By following the principles of efficient data management and using Java’s powerful features, this documentation clarifies the process of reading and storing employee data, thereby setting a solid groundwork for future operations and analyses.

The system comprises with two classes- **EmployeeProcessing Class** & **Employee Class.**

- **Class Variables**:
  - **employeeList**: Holds a list of **Employee** objects.
  - **departmentAbbreviations**: Maps department names to their abbreviations.
- **Main Method**:
  - Runs the program's main functionality within a loop that displays a menu of options for interacting with the employee data.

**Methods**

- **loadDataFromFile**: Reads employee data from a file and populates the **employeeList**.
- **displayMenu**: Prints a menu with options for various operations.
- **saveDataToFile**: Writes the updated **employeeList** data back to a file.
- **displayEmployees**: Displays employee information in a formatted manner.
- Other methods like **addEmployee**, **filterEmployeesByAge**, **calculateAverageSalary**, **displayEmployeesInSalaryRange**, **filterEmployeesByDepartment**, **displayEmployeesByDepartment**, and **exitProgram** handle specific functionalities based on user input.

**Functionalities Explained:**

1. **Adding Employees** (**addEmployee**):
    - Allows the user to add new employee details like name, department, age, and salary.
2. **Filtering Employees by Age** (**filterEmployeesByAge**):
    - Filters employees based on an age threshold entered by the user.
3. **Calculating Average Salary** (**calculateAverageSalary**):
    - Calculates and displays the average salary of all employees.
4. **Displaying Employees within a Salary Range** (**displayEmployeesInSalaryRange**):
    - Shows employees within a specified salary range.
5. **Displaying Employees by Department** (**displayEmployeesByDepartment**):
    - Enables the user to view employees belonging to a specific department.
6. **Exiting the Program** (**exitProgram**):
    - Prompts the user for confirmation before exiting the program.

**Additional Information:**

- **Data Storage**: Employees are stored in memory (**employeeList**) and also saved to a file (**employees.txt**) for persistence.
- **Input Handling**:
  - The program uses **Scanner** to handle user input and perform operations accordingly.
- **Department Abbreviations**:
  - Abbreviations for departments are predefined to ensure consistency in user input.

This setup ensures modularity and encapsulation by segregating functionalities into separate methods, making the code easier to understand and maintain. It provides a robust system for managing employee data with various operations available through the menu.Top of Form

**Employee** class with attributes such as name, age, department, and salary, along with getter and setter methods for each attribute. Let's break down the code:

- **Attributes:** The class contains four private attributes: **name**, **age**, **department**, and **salary**, representing an employee's personal information.
- **Constructor:** The class has a constructor **Employee()** that initializes an **Employee** object with the provided values for **name**, **age**, **department**, and **salary**.
- **Getters and Setters:** For each attribute, there are getter methods (**getName()**, **getAge()**, **getDepartment()**, **getSalary()**) to retrieve the values and setter methods (**setName()**, **setAge()**, **setDepartment()**, **setSalary()**) to set or modify the attribute values.

This **Employee** class encapsulates the basic information and behavior related to an employee within a company. It follows the principle of encapsulation by keeping the attributes private and providing public methods to access and modify them, promoting data integrity and security. Hence, this class serves as a blueprint for creating **Employee** objects, allowing the storage and management of employee data within the program.

**Additional Features in My Program:**

1. **Department Abbreviations:**
    - Utilizes a map to store department abbreviations and allows users to choose departments using these abbreviations.
    - Enhances user experience by providing a shorthand method for selecting departments.
2. **Department Filtering:**
    - Allows users to display employees by department, in addition to the specified requirements.
    - Enables users to filter and display employees based on their departments, beyond the primary functionalities.
3. **Salary Filtering:**

- Allows users to specify a salary range and filters employees based on this range.
- Enhances the program's capability by enabling users to view employees within a specific salary bracket, providing additional insight into employee salary distribution.

These additional features enhance the functionality of my program by providing a more user-friendly interface for department selection and offering the capability to filter and display employees by department, contributing to a richer user experience beyond the initially specified requirements.

**Outputs**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/03bf55d4-2d40-476a-a6a6-27681b7cc3ff)

This output is a menu-driven program for managing employee data. Here's a breakdown of what each option might do:

1. **Add new employee information:** This option could prompt the user to input details about a new employee, such as name, age, department, and salary, and then add this information to the dataset.
2. **Filter employees by age:** This option likely allows you to filter the existing employee dataset based on an age threshold. For example, if you input a specific age, the program will display only employees above that age.
3. **Calculate average salary:** This option should calculate and display the average salary of all employees in the dataset.
4. **Employees in Salary Range:** This might prompt you to input a salary range and then display the employees whose salaries fall within that specified range.
5. **Display employees by department:** This option could organize and display the employees based on their departments, showing a list of employees in each department.
6. **Exit:** This option allows you to exit or terminate the program.

Various aspects of the application, including:

- Adding new employee information
- Filtering employees by age
- Calculating the average salary
- Displaying employees within a specific salary range
- Organizing and displaying employees by department

