**Generic Library Catalog**

**Introduction**

Presenting the latest iteration of our library catalog project, which incorporates a range of enhancements and functionalities designed to improve the overall user experience and data management capabilities. Inspired by our recent discussions on JDBC in last week’s lectures and the insights gained from our Databases 1 class, I have integrated PostgreSQL database functionality into the project to leverage its robust features for storing and managing library item data efficiently. This integration not only aligns with the objectives of our course but also reflects a proactive approach towards implementing industry-standard practices in real-world projects. Through the use of Java generics, modular design principles, and effective error handling techniques, the project ensures flexibility, code reusability, and graceful management of unexpected scenarios. Moreover, the inclusion of a user-friendly command-line interface empowers users to seamlessly interact with the catalog, enabling them to add, remove, and view library items with ease.

**Classes and Source Codes**

**_Main.java_**

This class serves as the entry point of the program. It establishes a connection to the PostgreSQL database, creates necessary tables if they don't exist, and then initializes instances of **LibraryCatalog** and **UserInterface** to interact with the database.

- **public static void main(String\[\] args)**: The main method of the program.
- **try (Connection connection = DriverManager.getConnection(...) { ... }**: Establishes a connection to the PostgreSQL database using JDBC. The connection is automatically closed at the end of the try block due to using the try-with-resources construct.
- **createTables(connection)**: Calls the **createTables** method to create the necessary tables in the database.
- **LibraryCatalog catalog = new LibraryCatalog(connection);**: Creates an instance of the **LibraryCatalog** class, passing the database connection as a parameter.
- **UserInterface ui = new UserInterface(catalog);**: Creates an instance of the **UserInterface** class, passing the **LibraryCatalog** instance as a parameter.
- **ui.start();**: Starts the user interface, allowing users to interact with the library catalog.
- **catch (SQLException e) { e.printStackTrace(); }**: Catches and prints any SQLException that occurs during the execution of the program.

**createTables Method:**

This method is responsible for creating the necessary tables (**books** and **dvds**) in the PostgreSQL database if they don't already exist.

- **private static void createTables(Connection connection) throws SQLException { ... }**: A private method that takes a Connection object as a parameter and may throw a SQLException.
- **String createBooksTableSQL = "CREATE TABLE IF NOT EXISTS books (...";**: Defines an SQL statement to create the **books** table if it doesn't exist already. The table has columns for **id** (serial), **title** (text), **author** (text), and **item_id** (int) with unique constraints on **item_id**.
- **String createDvdsTableSQL = "CREATE TABLE IF NOT EXISTS dvds (...";**: Defines an SQL statement to create the **dvds** table if it doesn't exist already. The table has columns for **id** (serial), **title** (text), **director** (text), and **item_id** (int) with unique constraints on **item_id**.
- **try (Statement statement = connection.createStatement()) { ... }**: Creates a Statement object to execute SQL queries. The try-with-resources construct ensures the Statement is automatically closed after use.
- **statement.execute(createBooksTableSQL);**: Executes the SQL statement to create the **books** table.
- **statement.execute(createDvdsTableSQL);**: Executes the SQL statement to create the **dvds** table.

Overall, the Main class establishes a database connection, creates necessary tables, and initiates user interaction through the **UserInterface** class.

**_LibraryItem.java_**

This class serves as a base class for library items such as books and DVDs. It provides common functionality and properties shared among different types of library items.

- **public abstract class LibraryItem implements Comparable&lt;LibraryItem&gt;**: Declares the class as abstract and implements the **Comparable** interface, allowing instances of **LibraryItem** to be compared based on their titles.
- **private String title;**: Declares a private field to store the title of the library item.
- **private int itemID;**: Declares a private field to store the unique identifier of the library item.
- **public LibraryItem(String title, int itemID) { ... }**: Constructor to initialize the **title** and **itemID** fields of the library item.
- **public String getTitle() { ... }**: Getter method to retrieve the title of the library item.
- **public int getItemID() { ... }**: Getter method to retrieve the item ID of the library item.
- **@Override public String toString() { ... }**: Overrides the **toString** method to provide a string representation of the library item, including its title and item ID.
- **@Override public int compareTo(LibraryItem other) { ... }**: Overrides the **compareTo** method from the **Comparable** interface to define the natural ordering of library items based on their titles. This allows instances of **LibraryItem** to be sorted in alphabetical order based on their titles.

Overall, the **LibraryItem** class encapsulates the common properties and behavior of library items and provides a foundation for implementing specific types of library items, such as books and DVDs. It also enables sorting of library items based on their titles.Top of Form

**_LibraryCatalog.java_**

The **LibraryCatalog** class facilitates the management of a library catalog stored in a database. It provides functionalities to add, remove, and view library items within the catalog. Below are the key aspects of this class:

- **Fields**:
  - **private Connection connection**: Represents the connection to the database, allowing the class to interact with it seamlessly.
- **Constructor**:
  - **public LibraryCatalog(Connection connection)**: Initializes a new instance of **LibraryCatalog** with the provided database connection.
- **Methods**:
  - **public void addItem(LibraryItem item, String tableName)**: Adds a new library item to the catalog table in the database. The method dynamically constructs SQL statements based on the type of item (Book or DVD) and inserts them into the appropriate table.
  - **private int getMaxItemId(String tableName)**: Retrieves the maximum item ID from the specified table in the database, ensuring the uniqueness of new item IDs.
  - **public void removeItem(int itemID, String tableName)**: Removes a library item from the catalog table in the database based on its item ID. The method handles dynamic SQL generation to accommodate different table structures for books and DVDs.
  - **public void viewCatalog(String tableName)**: Retrieves and displays all items from the specified table in the database. The method constructs SQL queries to fetch item details and presents them appropriately based on the item type.
- **Error Handling**:
  - SQL exceptions are caught and printed to the console for debugging purposes, ensuring robustness and reliability in database operations.

The **LibraryCatalog** class acts as a crucial component for managing library item data efficiently within a database-backed system. It dynamically handles SQL operations based on the item type and ensures seamless integration with external data sources. Through its methods, it enables administrators to add, remove, and view library items within the catalog with ease, contributing to streamlined catalog management processes.

**_DVD.java_**

The **DVD** class represents a DVD library item, extending the **LibraryItem** class to inherit common properties and behaviors. It includes additional information about the director of the DVD. Here's an overview of the class:

- **Fields**:
  - **private String director**: Represents the director of the DVD.
- **Constructor**:
  - **public DVD(String title, String director, int itemID)**: Initializes a new instance of **DVD** with the provided title, director, and item ID. It invokes the constructor of the superclass **LibraryItem** to set the title and item ID.
- **Methods**:
  - **public String getDirector()**: Retrieves the director of the DVD.
  - **@Override public String toString()**: Overrides the **toString()** method to provide a string representation of the DVD, including its title, director, and item ID.

The **DVD** class encapsulates the details specific to DVDs, such as the director, while leveraging the common functionalities provided by its superclass. It facilitates the representation and manipulation of DVD items within the library catalog system.

**_Book.java_**

The **Book** class represents a book library item, extending the **LibraryItem** class to inherit common properties and behaviors. It includes additional information about the author of the book. Here's an overview of the class:

- **Fields**:
  - **private final String author**: Represents the author of the book.
- **Constructor**:
  - **public Book(String title, String author, int itemID)**: Initializes a new instance of **Book** with the provided title, author, and item ID. It invokes the constructor of the superclass **LibraryItem** to set the title and item ID.
- **Methods**:
  - **public String getAuthor()**: Retrieves the author of the book.
  - **@Override public String toString()**: Overrides the **toString()** method to provide a string representation of the book, including its title, author, and item ID.

The **Book** class encapsulates the details specific to books, such as the author, while leveraging the common functionalities provided by its superclass. It facilitates the representation and manipulation of book items within the library catalog system.

**_UserInterface.java_**

The **UserInterface** class provides a command-line interface for interacting with the library catalog system. It enables users to perform various actions such as adding, removing, and viewing items in the catalog. Below is an explanation of the class:

- **Fields**:
  - **private LibraryCatalog catalog**: Represents the library catalog that the user interface interacts with.
  - **private Scanner scanner**: Scanner object used for receiving user input.
- **Constructor**:
  - **public UserInterface(LibraryCatalog catalog)**: Initializes a new instance of **UserInterface** with the specified library catalog.
- **Methods**:
  - **public void start()**: Starts the user interface loop, allowing users to perform actions on the library catalog. It continuously prompts the user for input until the user chooses to exit.
  - **private void addItem()**: Prompts the user to add a new item to the catalog. It asks for the type of item (book or DVD), title, author/director, and item ID, and then adds the item to the catalog using the appropriate method of the **LibraryCatalog** object.
  - **private void removeItem()**: Prompts the user to remove an item from the catalog. It asks for the type of item (book or DVD) and the item ID, and then removes the item from the catalog using the appropriate method of the **LibraryCatalog** object.
  - **private void viewCatalog()**: Displays the catalog of books and DVDs by invoking the **viewCatalog()** method of the **LibraryCatalog** object for each type of item.

The **UserInterface** class acts as an intermediary between the user and the library catalog system, providing a straightforward command-line interface for managing library items. It ensures user inputs are properly handled and delegated to the corresponding methods of the **LibraryCatalog** class for execution.

**Conclusion**

In conclusion, the provided Java application implements a flexible library catalog system using PostgreSQL for data storage. The system consists of several key components:

1. LibraryItem Class: An abstract class representing generic library items, extended by the Book and DVD classes to provide specific item types with additional attributes.
2. LibraryCatalog Class: Manages the interaction with the database, including adding, removing, and viewing items in the catalog. It utilizes JDBC to execute SQL queries and perform database operations.
3. UserInterface Class: Provides a command-line interface for users to interact with the library catalog. Users can add, remove, and view items through simple text-based commands.

The application emphasizes modularity, code reuse, and exception handling, employing generic classes and methods for flexibility and reusability. It adheres to best practices in code structure, style, and readability, ensuring a logical flow and easy understanding of the implemented functionalities. Overall, the system offers a robust solution for managing library collections efficiently and effectively.
