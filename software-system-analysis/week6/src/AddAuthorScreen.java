//Egemen Balli 15 Mar 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddAuthorScreen extends JFrame{
    public JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton addAuthorButton;

    public AddAuthorScreen(Librarian librarian) {
        addAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                librarian.addAuthor(new Author(textField1.getText(), textField2.getText(), textArea1.getText()));
            }
        });
    }
}
