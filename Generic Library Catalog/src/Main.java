import java.sql.*;

/**
 * The Main class serves as the entry point for the library catalog application.
 * It establishes a connection to the database, creates necessary tables if they don't exist,
 * and initializes the library catalog and user interface.
 */
public class Main {

    /**
     * The main method of the application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/library", // JDBC URL for PostgreSQL database
                "postgres", // Database username
                "1312")) { // Database password

            createTables(connection); // Create necessary tables if they don't exist

            LibraryCatalog catalog = new LibraryCatalog(connection); // Initialize the library catalog
            UserInterface ui = new UserInterface(catalog); // Initialize the user interface
            ui.start(); // Start the user interface

        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if a SQL exception occurs
        }
    }

    /**
     * Method to create necessary tables in the database if they don't exist.
     * @param connection The database connection.
     * @throws SQLException If a SQL exception occurs.
     */
    private static void createTables(Connection connection) throws SQLException {
        // SQL statements to create books and DVDs tables
        String createBooksTableSQL = "CREATE TABLE IF NOT EXISTS books (" +
                "id SERIAL PRIMARY KEY," +
                "title TEXT," +
                "author TEXT," +
                "item_id INT UNIQUE)";
        String createDvdsTableSQL = "CREATE TABLE IF NOT EXISTS dvds (" +
                "id SERIAL PRIMARY KEY," +
                "title TEXT," +
                "director TEXT," +
                "item_id INT UNIQUE)";

        try (Statement statement = connection.createStatement()) {
            // Execute SQL statements to create tables
            statement.execute(createBooksTableSQL);
            statement.execute(createDvdsTableSQL);
        }
    }
}
