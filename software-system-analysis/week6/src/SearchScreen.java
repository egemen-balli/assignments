//Egemen Balli 15 Mar 2023
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class SearchScreen extends JFrame{
    public JPanel panel;
    private JTable table1;
    private JTextField textField1;
    private JButton findBookByTitleButton;
    private JButton findBorrowerByNameButton;
    private JButton findBookByAuthorButton;
    private JButton findBorrowerByEmailButton;

    public SearchScreen(Librarian librarian) {
        //Scanner scanner = new Scanner(new File("Books.txt"));
        findBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //table1.setModel(new DefaultTableModel(,new String[]{"Title 1","Title 2","Title 3","Title 4"}));
            }
        });
        findBorrowerByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        findBookByAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        findBorrowerByEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
