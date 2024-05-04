import java.io.*;
import java.util.*;


public class EmployeeProcessing {
    private static final List<Employee> employeeList = new ArrayList<>(); // Initialize the ArrayList
    private static final Map<String, String> departmentAbbreviations = new HashMap<>(); // Map to hold department abbreviations

    public static void main(String[] args) {
        loadDataFromFile(); // Load existing data from file
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        addEmployee(scanner);
                        break;
                    case 2:
                        filterEmployeesByAge(scanner);
                        break;
                    case 3:
                        calculateAverageSalary();
                        break;
                    case 4:
                        displayEmployeesInSalaryRange(scanner);
                        break;
                    case 5:
                        displayEmployeesByDepartment(scanner);
                        break;
                    case 6:
                        exit = exitProgram(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
                if (!exit) {
                    saveDataToFile(); // Save the updated list to the file
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer for your choice.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
    // Other require methods
    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add new employee information");
        System.out.println("2. Filter employees by age");
        System.out.println("3. Calculate average salary");
        System.out.println("4. Employees in Salary Range");
        System.out.println("5. Display employees by department");
        System.out.println("6. Exit");
    }
    private static void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {
            for (Employee employee : employeeList) {
                String data = employee.getName() + "," + employee.getAge() + "," +
                        employee.getDepartment() + "," + employee.getSalary();

                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    private static void loadDataFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Assuming data is comma-separated
                if (data.length == 4) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());

                    Employee employee = new Employee(name, age, department, salary);
                    employeeList.add(employee);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    private static void displayEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employees:");
            for (Employee emp : employees) {
                System.out.println(emp.getName() + " - Age: " + emp.getAge() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getSalary());
            }
        }
    }
    static {
        // Populate department abbreviations
        departmentAbbreviations.put("Finance", "FIN");
        departmentAbbreviations.put("Marketing", "MRKT");
        departmentAbbreviations.put("Operations Management", "OPS");
        departmentAbbreviations.put("Human Resources", "HR");
        departmentAbbreviations.put("IT", "IT");
    }

    // Case 1
    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("Choose department:");
        departmentAbbreviations.forEach((department, abbreviation) ->
                System.out.println(abbreviation + " - " + department));

        String departmentAbbreviation = scanner.nextLine().toUpperCase();
        String department = departmentAbbreviations.entrySet().stream()
                .filter(entry -> entry.getValue().equals(departmentAbbreviation))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (department == null) {
            System.out.println("Invalid department abbreviation!");
            return;
        }

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(name, age, department, salary);
        employeeList.add(newEmployee);

        // Inform the user about the successful assignment
        System.out.println(name + " has been successfully assigned to the " + department + " department.");
    }
    // Case 2
    private static void filterEmployeesByAge(Scanner scanner) {
        System.out.print("Enter the age threshold to filter employees: ");
        int ageThreshold = scanner.nextInt();
        List<Employee> filteredEmployees = employeeList.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .toList();

        displayEmployees(filteredEmployees);
    }
    // Case 3
    private static void calculateAverageSalary() {
        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN); // Set a default value for an empty list

        if (Double.isNaN(averageSalary)) {
            System.out.println("No employees available to calculate average salary.");
        } else {
            System.out.println("Average Salary of all Employees: " + averageSalary);
        }
    }
    // Case 4
    private static void displayEmployeesInSalaryRange(Scanner scanner) {
        System.out.print("Enter minimum salary: ");
        double minSalary = scanner.nextDouble();

        System.out.print("Enter maximum salary: ");
        double maxSalary = scanner.nextDouble();

        List<Employee> filteredEmployees = employeeList.stream()
                .filter(emp -> emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary)
                .toList();

        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found within the salary range.");
        } else {
            System.out.println("Employees within the salary range:");
            displayEmployees(filteredEmployees);
        }
    }
    // Case 5
    private static List<Employee> filterEmployeesByDepartment(String department) {
        return employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    private static void displayEmployeesByDepartment(Scanner scanner) {
        System.out.println("Choose department:");
        departmentAbbreviations.forEach((department, abbreviation) ->
                System.out.println(abbreviation + " - " + department));

        String departmentInput = scanner.nextLine().trim();
        String department = departmentAbbreviations.entrySet().stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase(departmentInput))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (department == null) {
            System.out.println("Invalid department abbreviation!");
        } else {
            List<Employee> employeesInDepartment = filterEmployeesByDepartment(department);
            displayEmployees(employeesInDepartment);
        }
    }

    // Exit
    private static boolean exitProgram(Scanner scanner) {
        System.out.println("Are you sure you want to exit? (Y/N)");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("y")) {
            System.out.println("Exiting the program...");
            return true;
        } else if (response.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input! Please enter 'Y' or 'N'.");
            return false;
        }
    }
}
