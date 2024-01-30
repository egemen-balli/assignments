//Egemen Balli 15 Mar 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JButton librarianLoginButton;
    private JButton borrowerLoginButton;
    public JPanel panel;

    public MainFrame(Librarian librarian) {
        librarianLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianScreen librarianScreen = new LibrarianScreen(librarian);
                librarianScreen.setContentPane(librarianScreen.panel);
                librarianScreen.setSize(420,420);
                librarianScreen.setVisible(true);
            }
        });
        borrowerLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowerScreen borrowerScreen = new BorrowerScreen(librarian);
                borrowerScreen.setContentPane(borrowerScreen.panel);
                borrowerScreen.setSize(840,420);
                borrowerScreen.setVisible(true);
            }
        });
    }
}
