//Egemen Balli 15 Mar 2023
import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String Name;
    private String Email;
    private List<Book> borrowedBooks;

    public Borrower(String name, String email) {
        Name = name;
        Email = email;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    void borrow(Book book){
        borrowedBooks.add(book);
        book.borrowBook();
    }

    void returnBack(Book book){
        borrowedBooks.remove(book);
        book.returnBook();
    }

}
