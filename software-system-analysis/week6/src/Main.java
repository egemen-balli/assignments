//Egemen Balli 15 Mar 2023
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("Egemen Balli", "egemen@gmail.com");
        librarian.addBorrower("Egemen the Borrower", "theborrower@hotmail.com");

        MainFrame mainFrame = new MainFrame(librarian);
        mainFrame.setContentPane(mainFrame.panel);
        mainFrame.setSize(420,420);
        mainFrame.setVisible(true);

    }
}
