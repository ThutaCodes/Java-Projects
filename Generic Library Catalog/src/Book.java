/**
 * The Book class represents a book library item, extending the LibraryItem class.
 * It contains additional information about the author of the book.
 */
public class Book extends LibraryItem {
    private final String author; // Author of the book

    /**
     * Constructs a new Book with the specified title, author, and item ID.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param itemID The item ID of the book.
     */
    public Book(String title, String author, int itemID) {
        super(title, itemID); // Call the constructor of the superclass (LibraryItem)
        this.author = author;
    }

    /**
     * Retrieves the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns a string representation of the Book.
     * @return A string representation containing the title, author, and item ID of the book.
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", itemID=" + getItemID() +
                '}';
    }
}
