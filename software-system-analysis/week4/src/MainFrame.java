//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame{
    private JButton EXITButton;
    private JButton CREATEFLIGHTButton;
    private JButton BUYTICKETButton;
    private JButton SHOWFLIGHTSButton;
    private JButton SHOWTICKETSButton;
    public JPanel panelMain;

    public MainFrame(FlightController f_c, TicketController t_c) {
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });
        CREATEFLIGHTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFlight createFlight = new CreateFlight(f_c);
                createFlight.setContentPane(createFlight.panelMain);
                createFlight.setSize(500,300);
                createFlight.setVisible(true);
            }
        });
        BUYTICKETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyTicket buyTicket = new BuyTicket(t_c);
                buyTicket.setContentPane(buyTicket.panelMain);
                buyTicket.setSize(500,300);
                buyTicket.setVisible(true);
            }
        });
        SHOWFLIGHTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOfFlights listOfFlights = new ListOfFlights();
                listOfFlights.setContentPane(listOfFlights.panelMain);
                listOfFlights.setSize(500,300);
                listOfFlights.setVisible(true);
                listOfFlights.list1.setModel(f_c.showData());
            }
        });
        SHOWTICKETSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOfTickets listOfTickets = new ListOfTickets();
                listOfTickets.setContentPane(listOfTickets.panelMain);
                listOfTickets.setSize(500,300);
                listOfTickets.setVisible(true);
                listOfTickets.list1.setModel(t_c.showData());
            }
        });
    }
}
