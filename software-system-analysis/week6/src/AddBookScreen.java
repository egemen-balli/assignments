//Egemen Balli 15 Mar 2023
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddBookScreen extends JFrame{
    public JPanel panel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton addBookButton;
    private JDateChooser JDateChooser1;

    public AddBookScreen(Librarian librarian) {
        try {
            Scanner authorScanner = new Scanner(new File("Authors.txt"));
            Scanner publisherScanner = new Scanner(new File("Publishers.txt"));

            while(authorScanner.hasNextLine()){
                String[] list = authorScanner.nextLine().split("\'");
                comboBox1.addItem(list[0]);
            }
            while(publisherScanner.hasNextLine()){
                String[] list = publisherScanner.nextLine().split("\'");
                comboBox2.addItem(list[0]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new File("Authors.txt"));

                Scanner scanner2 = new Scanner(new File("Publishers.txt"));
                Author A = null;
                while(scanner.hasNextLine()){
                    String[] scn = scanner.nextLine().split("\'");
                    if(scn[0].equals(comboBox1.getSelectedItem().toString())){
                        A = new Author(scn[0],scn[1],scn[2]);
                    }
                }
                Publisher P = null;
                while (scanner2.hasNextLine()){
                    String[] scn = scanner2.nextLine().split("\'");
                    if(scn[0].equals(comboBox2.getSelectedItem().toString())){
                        P = new Publisher(scn[0],scn[1],scn[2]);
                    }
                }

                    librarian.addBook(new Book(textField1.getText(), A, textField2.getText(), P, JDateChooser1.getDate(), Integer.parseInt(textField4.getText())));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
