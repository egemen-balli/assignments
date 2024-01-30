//Egemen Balli 15 Mar 2023
import java.util.Date;

public class Book {
    private String title;
    private Author author;
    private String ISBN;
    private Date publicationDate;
    private Publisher publisher;
    private int availableCopies;

    public Book(String title, Author author, String ISBN, Publisher publisher, Date publicationDate, int availableCopies){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    void borrowBook(){
        availableCopies--;
    }

    void returnBook(){
        availableCopies++;
    }
}
