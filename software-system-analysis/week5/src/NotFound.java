//Egemen Balli 8 Mar 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotFound extends JFrame{
    public JPanel panel1;
    private JButton OKButton;

    public NotFound() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
