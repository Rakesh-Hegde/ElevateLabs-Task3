import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Sample Data
        lib.addBook(new Book(1, "Java Basics", "John Doe"));
        lib.addBook(new Book(2, "OOP Concepts", "Jane Smith"));
        lib.addUser(new User(1, "Alice"));
        lib.addUser(new User(2, "Bob"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Book");
            System.out.println("6. Add User");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    lib.showUsers();
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    lib.issueBook(userId, bookId);
                    break;
                case 4:
                    System.out.print("Enter User ID to return book: ");
                    int retId = sc.nextInt();
                    lib.returnBook(retId);
                    break;
                case 5:
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(bookId, title, author));
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    lib.addUser(new User(userId, name));
                    break;
            }
                        
        } while (choice != 0);
        sc.close();
    }
}
