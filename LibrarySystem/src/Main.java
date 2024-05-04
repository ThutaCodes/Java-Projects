import java.util.*;
/*This line imports the entire java.util package, which contains utility classes like ArrayList, HashMap*/
class Book { //This line begins the declaration of a class named Book
    private final String author, title;
    /*This line declares a private attribute named author and title of type String within the Book class.
    'private' implies that the Book class has a private variable to store the quantity of books available.*/
    private int quantity;
    /*This line declares a private attribute named quantity of type int within the Book class.
    'private' implies that the Book class has a private variable to store the quantity of books available.*/
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
/* The above code snippet
This code snippet shows a constructor for the Book class that takes three parameters:
title, author, and quantity. Inside the constructor,
it initializes the title, author, and quantity attributes of the Book object using the values passed
as arguments to the constructor.*/
    public String getTitle() {
        return title;
    }
    //returns the title of the book.
    public String getAuthor() {
        return author;
    }
    // return the author of the book
    public int getQuantity() {
        return quantity;
    }
    //returns the quantity of the book available.
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //sets the quantity of the book to the value passed as an argument.
}

class LibrarySystem { //Initiates the class 'LibrarySystem'
    private final Map<String, Book> library; // declaring a private attribute named library of type Map<String, Book>

    public LibrarySystem() { //Means it is under the class 'LibrarySystem'
        library = new HashMap<>();//Initializing the attribute 'library'. HashMap is just like a storage where books will be stored, in this case.
    }

    public void addBook(String title, String author, int quantity) {
        /*The above addBook method in the LibrarySystem class allows you to add a book to the library.
        It takes three parameters: the title of the book, the author of the book,
        and quantities, the number of copies to add.*/
        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            existingBook.setQuantity(existingBook.getQuantity() + quantity);
            System.out.println("Quantity updated for book: " + title);
        /*The above if statement checks whether a book with a given title exists in a library.
        If it does, it retrieves the existing book and updates its quantity by adding the provided quantity.
        Finally, it prints a message confirming the quantity update for that book.*/
        } else {
            Book newBook = new Book(title, author, quantity);
            library.put(title, newBook);
            System.out.println("Book added to the library: " + title);
        }
        /*The else statement will execute when the title of the book is not found in the library.
        Then, it will create a new book under the given name.
        Finally, it prints a message confirming the book update.*/
    }

    public void borrowBook(String title, int quantity) { // The method 'borrowBook' is initialized, with the parameters: title and quantity
        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            int availableQuantity = existingBook.getQuantity();
            if (availableQuantity >= quantity) {
                existingBook.setQuantity(availableQuantity - quantity);
                System.out.println("Successfully borrowed " + quantity + " book(s) of " + title);
        /*The above portion of code checks if the library contains a book with the given title.
        If it does, it retrieves the existing book and then checks if the available quantity of
        that book is sufficient to fulfill the requested quantity.
        If there are enough books available, it reduces the available quantity
        by the borrowed amount and prints a success message indicating the successful borrowing of the specified quantity of the book.*/
            } else {
                System.out.println("Insufficient quantity of " + title + " available to borrow.");
                /*if the book is found in the library but the available quantity is not sufficient to fulfill the requested quantity,
                it prints this*/
            }
        } else {
            System.out.println("Book not found in the library.");
            /*If the book is not found in the library at all, it prints a message stating that the book is not found in the library.*/
        }

    }

    public void returnBook(String title, int quantity) {
        if (library.containsKey(title)) {
            Book existingBook = library.get(title);
            existingBook.setQuantity(existingBook.getQuantity() + quantity);
            System.out.println("Successfully returned " + quantity + " book(s) of " + title);
        } else {
            System.out.println("Book not found in the library.");
        }
        /*The above portion of if-else statement checks if the library contains a book with the specified title.
     If it does, it retrieves the existing book and increases its quantity by the provided quantity.
     Then it prints a success message indicating the successful return of the specified quantity of the book.
     If the book is not found in the library, it prints the else statement*/
    }

    public void displayMenu() {
        System.out.println("\nLibrary System Menu");//displays options for different actions a user can take:
        System.out.println("1. Add Books");//allows the user to add books to the library
        System.out.println("2. Borrow Books");//enables borrowing books from the library
        System.out.println("3. Return Books");//returns the book to the library
        System.out.println("4. Exit");//exiting the system
    }


    public static void main(String[] args) {//Initializing 'main' method
        LibrarySystem librarySystem = new LibrarySystem();//'main' method initializes the 'LibrarySystem.'
        Scanner scanner = new Scanner(System.in);//Initializing 'scanner' to take the input from the user

        int choice;//This is a declaration of an integer variable named 'choice'
        do {
            librarySystem.displayMenu();//prompts the user for input
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a valid number.");//displays an error message and prompts for valid input
                scanner.next();
        /*The above do while loop prompts the user for input
        and checks if the input is an integer using scanner.hasNextInt().
        If the input is not an integer,
        it displays an error message and prompts for valid input again.*/
            }
            choice = scanner.nextInt();//Assigning 'scanner.nextInt' to choice
            scanner.nextLine();//this consumes the newline character left after entering the integer

            switch (choice) { //Initiating switch statement, checking the value of 'choice'
                /*Case 1 functions to add the book into the library.*/
                case 1:
                    System.out.print("Enter book title: ");//Prompting user the title of the book
                    String title = scanner.nextLine().toLowerCase();//Initiating scanner. Accepting both letter cases.
                    System.out.print("Enter author: ");//Prompting user the author of the book
                    String author = scanner.nextLine();//Initiating scanner
                    System.out.print("Enter quantity: ");//Prompting user the quantity of the book
                    int quantity = scanner.nextInt();//Initiating scanner
                    librarySystem.addBook(title, author, quantity);
                    /* calls the addBook method of the librarySystem object,
                    passing in the title, author, and quantity variables as arguments.*/
                    break;//Exiting case 1
                /*Case 2 functions to borrow the book from the library.*/
                case 2:
                    System.out.print("Enter book title to borrow: ");//Prompting user the title of the book
                    String borrowTitle = scanner.nextLine();//Initiating scanner
                    System.out.print("Enter quantity to borrow: ");//Prompting user the quantity of the book
                    int borrowQuantity = scanner.nextInt();//Initiating scanner
                    librarySystem.borrowBook(borrowTitle, borrowQuantity);
                    /*Executes the borrowing function with the provided borrowTitle and borrowQuantity  as arguments.*/
                    break;//Exiting case 2
                /*Case 3 functions to return the book to the library.*/
                case 3:
                    System.out.print("Enter book title to return: ");//Prompting user the title of the book
                    String returnTitle = scanner.nextLine();//Initiating scanner
                    System.out.print("Enter quantity to return: ");//Prompting user the quantity of the book
                    int returnQuantity = scanner.nextInt();//Initiating scanner
                    librarySystem.returnBook(returnTitle, returnQuantity);
                    /*Runs the returning function with the provided borrowTitle and borrowQuantity as arguments.*/
                    break;//Exiting case 3
                /*Case 4 functions to exit from the library system.*/
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");//Printing this if the user chose to exit the library system
                    break;//Exiting case 4
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                /*The above default block will be triggered when the user input does not fulfill none of the above switch cases.*/
            }
        } while (choice != 4);//This will execute repeatedly as long as the value of the variable 'choice' is not equal to 4.

        scanner.close();//Closing the scanner
    }
}

