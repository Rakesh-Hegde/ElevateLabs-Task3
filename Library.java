import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
    if (findBookById(book.getId()) != null) {
        System.out.println(" Book with ID " + book.getId() + " already exists.");
        return;
    }
    books.add(book);
    System.out.println("✅ Book added successfully.");
    }


    public void addUser(User user) {
    if (findUserById(user.getId()) != null) {
        System.out.println("❌ User with ID " + user.getId() + " already exists.");
        return;
    }
    users.add(user);
    System.out.println("✅ User added successfully.");
    }


    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void issueBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        
        if (user == null || book == null) {
            System.out.println("Invalid user/book ID.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }
        if (user.getIssuedBook() != null) {
            System.out.println("User already has a book.");
            return;
        }

        book.issue();
        user.issueBook(book);
        System.out.println("Book issued to user.");
    }

    public void returnBook(int userId) {
        User user = findUserById(userId);
        if (user == null || user.getIssuedBook() == null) {
            System.out.println("No book to return.");
            return;
        }

        Book book = user.getIssuedBook();
        book.returnBook();
        user.returnBook();
        System.out.println("Book returned successfully.");
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }
}
