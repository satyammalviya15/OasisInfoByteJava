import java.util.*;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class Library {
    Map<String, Book> bookCollection = new HashMap<>();

    public void addBook(Book book) {
        bookCollection.put(book.title, book);
    }

    public Book searchBook(String title) {
        return bookCollection.get(title);
    }

    public void checkoutBook(String title) {
        Book book = searchBook(title);
        if(book != null && book.isAvailable) {
            book.isAvailable = false;
            System.out.println("You have successfully checked out " + title);
        } else {
            System.out.println("Sorry, this book is not available");
        }
    }
}

public class librarymanagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        String title;
        String author;

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Add a book");
            System.out.println("2: Search for a book");
            System.out.println("3: Checkout a book");
            System.out.println("4: Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter title:");
                    title = scanner.next();
                    System.out.println("Enter author:");
                    author = scanner.next();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.println("Enter title:");
                    title = scanner.next();
                    Book book = library.searchBook(title);
                    if(book != null) {
                        System.out.println("Book found:");
                        System.out.println("Title: " + book.title);
                        System.out.println("Author: " + book.author);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter title:");
                    title = scanner.next();
                    library.checkoutBook(title);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
