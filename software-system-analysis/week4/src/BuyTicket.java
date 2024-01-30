//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyTicket extends JFrame {
    public JPanel panelMain;
    private JButton ENTERButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public BuyTicket(TicketController t_c) {
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t_c.create(textField1.getText(), textField2.getText(), textField3.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
