import java.util.Scanner;

/**
 * The UserInterface class provides a command-line interface for interacting with the library catalog.
 */
public class UserInterface {
    private LibraryCatalog catalog; // The library catalog
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new UserInterface with the specified library catalog.
     * @param catalog The library catalog to interact with.
     */
    public UserInterface(LibraryCatalog catalog) {
        this.catalog = catalog;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the user interface loop, allowing users to perform actions on the library catalog.
     */
    public void start() {
        while (true) {
            System.out.println("Enter the action (Add/Remove/View/Exit):");
            String action = scanner.nextLine().trim();

            if (action.equalsIgnoreCase("exit")) {
                break;
            }

            switch (action.toLowerCase()) {
                case "add":
                    addItem();
                    break;
                case "remove":
                    removeItem();
                    break;
                case "view":
                    viewCatalog();
                    break;
                default:
                    System.out.println("Invalid action. Please enter 'Add', 'Remove', 'View', or 'Exit'.");
            }
        }
        scanner.close();
    }

    /**
     * Prompts the user to add a new item to the catalog.
     */
    private void addItem() {
        System.out.println("Enter the type of item (Book/DVD):");
        String itemType = scanner.nextLine().trim();

        System.out.println("Enter the title:");
        String title = scanner.nextLine().trim();

        String authorDirector;
        if (itemType.equalsIgnoreCase("book")) {
            System.out.println("Enter the author:");
        } else if (itemType.equalsIgnoreCase("dvd")) {
            System.out.println("Enter the director:");
        } else {
            System.out.println("Unsupported item type.");
            return;
        }
        authorDirector = scanner.nextLine().trim();

        System.out.println("Enter the item ID:");
        int itemID = Integer.parseInt(scanner.nextLine().trim());

        if (itemType.equalsIgnoreCase("book")) {
            catalog.addItem(new Book(title, authorDirector, itemID), "books");
        } else if (itemType.equalsIgnoreCase("dvd")) {
            catalog.addItem(new DVD(title, authorDirector, itemID), "dvds");
        }
    }

    /**
     * Prompts the user to remove an item from the catalog.
     */
    private void removeItem() {
        System.out.println("Enter the type of item to remove (Book/DVD):");
        String itemType = scanner.nextLine().trim();

        System.out.println("Enter the item ID:");
        int itemID = Integer.parseInt(scanner.nextLine().trim());

        if (itemType.equalsIgnoreCase("book")) {
            catalog.removeItem(itemID, "books");
        } else if (itemType.equalsIgnoreCase("dvd")) {
            catalog.removeItem(itemID, "dvds");
        }
    }

    /**
     * Displays the catalog of books and DVDs.
     */
    private void viewCatalog() {
        System.out.println("Books Catalog:");
        catalog.viewCatalog("books");

        System.out.println("DVDs Catalog:");
        catalog.viewCatalog("dvds");
    }
}
