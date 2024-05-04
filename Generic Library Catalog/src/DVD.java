/**
 * The DVD class represents a DVD library item, extending the LibraryItem class.
 * It contains additional information about the director of the DVD.
 */
public class DVD extends LibraryItem {
    private String director; // Director of the DVD

    /**
     * Constructs a new DVD with the specified title, director, and item ID.
     * @param title The title of the DVD.
     * @param director The director of the DVD.
     * @param itemID The item ID of the DVD.
     */
    public DVD(String title, String director, int itemID) {
        super(title, itemID); // Call the constructor of the superclass (LibraryItem)
        this.director = director;
    }

    /**
     * Retrieves the director of the DVD.
     * @return The director of the DVD.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Returns a string representation of the DVD.
     * @return A string representation containing the title, director, and item ID of the DVD.
     */
    @Override
    public String toString() {
        return "DVD{" +
                "title='" + getTitle() + '\'' +
                ", director='" + director + '\'' +
                ", itemID=" + getItemID() +
                '}';
    }
}
