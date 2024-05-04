import java.sql.*;

/**
 * The LibraryCatalog class represents a catalog of library items stored in a database.
 * It provides methods to add, remove, and view items in the catalog.
 */
public class LibraryCatalog {
    private Connection connection; // Connection to the database

    /**
     * Constructs a new LibraryCatalog with the specified database connection.
     * @param connection The connection to the database.
     */
    public LibraryCatalog(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adds a new library item to the catalog table in the database.
     * @param item The library item to add.
     * @param tableName The name of the table in which to add the item.
     */
    public void addItem(LibraryItem item, String tableName) {
        String sql;
        // Determine the SQL statement based on the type of item (Book or DVD)
        if (item instanceof Book) {
            sql = "INSERT INTO " + tableName + " (title, author, item_id) VALUES (?, ?, ?)";
        } else if (item instanceof DVD) {
            sql = "INSERT INTO " + tableName + " (title, director, item_id) VALUES (?, ?, ?)";
        } else {
            System.out.println("Unsupported item type.");
            return;
        }

        try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
            // Get the maximum item_id from the table
            int maxItemId = getMaxItemId(tableName);

            // Generate a new unique item_id
            int newItemId = maxItemId + 1;

            // Insert the item with the new unique item_id
            insertStatement.setString(1, item.getTitle());
            if (item instanceof Book) {
                insertStatement.setString(2, ((Book) item).getAuthor());
            } else if (item instanceof DVD) {
                insertStatement.setString(2, ((DVD) item).getDirector());
            }
            insertStatement.setInt(3, newItemId);
            insertStatement.executeUpdate();
            System.out.println("Item added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the maximum item ID from the specified table in the database.
     * @param tableName The name of the table.
     * @return The maximum item ID.
     * @throws SQLException If a SQL exception occurs.
     */
    private int getMaxItemId(String tableName) throws SQLException {
        String maxItemIdQuery = "SELECT MAX(item_id) FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(maxItemIdQuery)) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    /**
     * Removes a library item from the catalog table in the database based on its item ID.
     * @param itemID The item ID of the item to remove.
     * @param tableName The name of the table from which to remove the item.
     */
    public void removeItem(int itemID, String tableName) {
        String columnName;
        // Determine the column name based on the table name
        if (tableName.equals("books")) {
            columnName = "item_id";
        } else if (tableName.equals("dvds")) {
            columnName = "item_id";
        } else {
            System.out.println("Unsupported table name.");
            return;
        }

        String sql = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, itemID);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Item removed successfully.");
            } else {
                System.out.println("Item not found in the catalog.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves and displays all items from the specified table in the database.
     * @param tableName The name of the table to view.
     */
    public void viewCatalog(String tableName) {
        String sql = "SELECT * FROM " + tableName;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Current Catalog:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int itemID = resultSet.getInt("item_id");

                if (tableName.equals("books")) {
                    String author = resultSet.getString("author");
                    System.out.println("Book{" +
                            "id=" + id +
                            ", title='" + title + '\'' +
                            ", author='" + author + '\'' +
                            ", itemID=" + itemID +
                            '}');
                } else if (tableName.equals("dvds")) {
                    String director = resultSet.getString("director");
                    System.out.println("DVD{" +
                            "id=" + id +
                            ", title='" + title + '\'' +
                            ", director='" + director + '\'' +
                            ", itemID=" + itemID +
                            '}');
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
