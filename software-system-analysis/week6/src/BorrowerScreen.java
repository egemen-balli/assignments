//Egemen Balli 15 Mar 2023
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BorrowerScreen extends JFrame{
    public JPanel panel;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton GIVEButton;

    public BorrowerScreen(Librarian librarian) {
        GIVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrower borrower = librarian.findBorrower(textField1.getText());
                borrower.borrow(librarian.findBook(textField2.getText()));
                List<Book> bookList = borrower.getBorrowedBooks();
                String[][] arr = new String[bookList.size()][6];
                for (int i = 0;i<bookList.size();i++) {
                    arr[i][0] = bookList.get(i).getTitle();
                    arr[i][1] = bookList.get(i).getAuthor().getName();
                    arr[i][2] = bookList.get(i).getISBN();
                    arr[i][3] = bookList.get(i).getPublicationDate().toString();
                    arr[i][4] = bookList.get(i).getPublisher().getName();
                    arr[i][5] = ""+bookList.get(i).getAvailableCopies();
                }

                table1.setModel(new DefaultTableModel(arr, new String[]{"Book Name","Author","ISBN","Publication Date","Publisher","Available Copies"}));
            }
        });
    }
}
