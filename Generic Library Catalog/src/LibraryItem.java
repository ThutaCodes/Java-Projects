public abstract class LibraryItem implements Comparable<LibraryItem> {
    private String title; // Title of the library item
    private int itemID; // ID of the library item

    /**
     * Constructs a new LibraryItem with the specified title and item ID.
     * @param title The title of the library item.
     * @param itemID The item ID of the library item.
     */
    public LibraryItem(String title, int itemID) {
        this.title = title;
        this.itemID = itemID;
    }

    /**
     * Retrieves the title of the library item.
     * @return The title of the library item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the item ID of the library item.
     * @return The item ID of the library item.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Returns a string representation of the LibraryItem.
     * @return A string representation containing the title and item ID of the library item.
     */
    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + title + '\'' +
                ", itemID=" + itemID +
                '}';
    }

    /**
     * Compares this library item with another library item based on their titles.
     * @param other The library item to compare to.
     * @return A negative integer, zero, or a positive integer as this library item
     *         is less than, equal to, or greater than the specified library item.
     */
    @Override
    public int compareTo(LibraryItem other) {
        return this.title.compareTo(other.title);
    }
}
