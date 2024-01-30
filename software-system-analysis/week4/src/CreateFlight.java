//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFlight extends JFrame{
    private JButton ENTERButton;
    public JPanel panelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public CreateFlight(FlightController f_c) {
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    f_c.create(textField1.getText(), textField2.getText(), textField3.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
