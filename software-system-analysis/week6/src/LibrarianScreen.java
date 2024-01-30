//Egemen Balli 15 Mar 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianScreen extends JFrame{
    public JPanel panel;
    private JButton ADDBOOKButton;
    private JButton ADDAUTHORButton;
    private JButton ADDPUBLISHERButton;
    private JButton SEARCHButton;

    public LibrarianScreen(Librarian librarian) {
        ADDAUTHORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAuthorScreen addAuthorScreen = new AddAuthorScreen(librarian);
                addAuthorScreen.setContentPane(addAuthorScreen.panel);
                addAuthorScreen.setSize(420,420);
                addAuthorScreen.setVisible(true);
            }
        });
        ADDPUBLISHERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPublisherScreen addPublisherScreen = new AddPublisherScreen(librarian);
                addPublisherScreen.setContentPane(addPublisherScreen.panel);
                addPublisherScreen.setSize(420,420);
                addPublisherScreen.setVisible(true);
            }
        });
        ADDBOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookScreen addBookScreen = new AddBookScreen(librarian);
                addBookScreen.setContentPane(addBookScreen.panel);
                addBookScreen.setSize(420,420);
                addBookScreen.setVisible(true);
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchScreen searchScreen = new SearchScreen(librarian);
                searchScreen.setContentPane(searchScreen.panel);
                searchScreen.setSize(840,420);
                searchScreen.setVisible(true);
            }
        });
    }
}
