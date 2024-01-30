//Egemen Balli 15 Mar 2023
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Librarian {
    private String name;
    private String email;
    private ArrayList<Borrower> borrowers = new ArrayList<>();

    public Librarian(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void addBook(Book book){
        try {
            Date date = book.getPublicationDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            FileWriter fileWriter = new FileWriter(new File("Books.txt"), true);
            fileWriter.write(book.getTitle() + "|" + book.getAuthor().toString() + "|" + book.getISBN() + "|" + book.getPublisher().toString() + "|" + strDate + "|" + book.getAvailableCopies() + "\n");
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    void removeBook(Book book){
        try {
            File file = new File("Books.txt");
            Scanner scanner = new Scanner(file);
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (scanner.hasNextLine()){
                String[] st = scanner.nextLine().split("\\|");
                if(book.getTitle() != st[0]){
                    try {
                        FileWriter fileWriter = new FileWriter(new File("Books.txt"), true);
                        fileWriter.write(st[0] + "|" + st[1] + "|" + st[2] + "|" + st[3] + "|" + st[4] + "|" + st[5] + "\n");
                        fileWriter.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void addAuthor(Author author){
        try {
            FileWriter fileWriter = new FileWriter(new File("Authors.txt"), true);
            fileWriter.write(author.getName() + "\'" + author.getEmail() + "\'" + author.getBiography() + "\n");
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    void removeAuthor(Author author){
        try {
            File file = new File("Authors.txt");
            Scanner scanner = new Scanner(file);
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (scanner.hasNextLine()){
                String[] st = scanner.nextLine().split("\'");
                if(author.getName() != st[0]){
                    try {
                        FileWriter fileWriter = new FileWriter(new File("Authors.txt"), true);
                        fileWriter.write(st[0] + "\'" + st[1] + "\'" + st[2] + "\n");
                        fileWriter.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void addPublisher(Publisher publisher){
        try {
            FileWriter fileWriter = new FileWriter(new File("Publishers.txt"), true);
            fileWriter.write(publisher.getName() + "\'" + publisher.getEmail() + "\'" + publisher.getAddress() + "\n");
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    void removePublisher(Publisher publisher){
        try {
            File file = new File("Publishers.txt");
            Scanner scanner = new Scanner(file);
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (scanner.hasNextLine()){
                String[] st = scanner.nextLine().split("\'");
                if(publisher.getName() != st[0]){
                    try {
                        FileWriter fileWriter = new FileWriter(new File("Publishers.txt"), true);
                        fileWriter.write(st[0] + "\'" + st[1] + "\'" + st[2] + "\n");
                        fileWriter.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void addBorrower(String borrowersName, String borrowersMail){
        borrowers.add(new Borrower(borrowersName, borrowersMail));
    }

    void removeBorrower(String borrowersName){
        borrowers.remove(findBorrower(borrowersName));
    }

    Book findBook(String title){
        try {
            Scanner scanner = new Scanner(new File("Books.txt"));
            ArrayList<Book> books = new ArrayList<>();
            while(scanner.hasNextLine()){
                String[] info = scanner.nextLine().split("\\|");
                String[] a = info[1].split("\'");
                String[] p = info[3].split("\'");

                SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
                Date date = null;
                try {
                    date = formatter.parse(info[4]);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                books.add(new Book(info[0], new Author(a[0],a[1],a[2]), info[2], new Publisher(p[0],p[1],p[2]), date, Integer.parseInt(info[5])));
            }
            for (Book i:books) {
                if(i.getTitle().equals(title)){
                    return i;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    Book findBook(Author author){
        return findBook(author.getName());
    }

    Borrower findBorrower(String borrowersName){
        for (Borrower i:borrowers) {
            if(i.getName().equals(borrowersName)){
                return i;
            }
            if(i.getEmail().equals(borrowersName)){
                return i;
            }
        }
        return null;
    }

}
