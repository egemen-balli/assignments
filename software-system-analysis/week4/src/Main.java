//Egemen Balli 28 Feb 2023
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FlightController flightController = new FlightController();
        TicketController ticketController = new TicketController(flightController);

        MainFrame mainFrame = new MainFrame(flightController, ticketController);
        mainFrame.setContentPane(mainFrame.panelMain);
        mainFrame.setSize(200,500);
        mainFrame.setVisible(true);
    }
}
