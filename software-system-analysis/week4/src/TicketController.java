//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketController implements BaseController{
    private FlightController f_c;
    private ArrayList<Ticket> all_tickets;
    private Scanner input;

    public TicketController(FlightController f_c) {
        all_tickets = new ArrayList<>();
        this.f_c = f_c;
    }

    @Override
    public void validate(String flightNumber, String seat, String luggage) throws Exception{
        if(Double.parseDouble(luggage) < 1){
            throw new Exception("Luggage cant be smaller than 1 kg");
        }

        for(Flight flights:f_c.getAll_flights()){
            if(flights.getFlight_code() == flightNumber && flights.isCanceled()){
                throw new Exception("This flight is canceled you can not buy ticket");
            }
        }

        for(Ticket tickets:all_tickets){
            if(tickets.getSeat_number() == Integer.parseInt(seat)){
                throw new Exception("This seat is taken please choose new seat");
            }
        }
    }

    @Override
    public void create(String input1, String input2, String input3) throws Exception{
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> stringList = showInput(input1,input2,input3);
        list.add(Integer.parseInt(stringList.get(0)));
        list.add(Integer.parseInt(stringList.get(1)));
        list.add(Integer.parseInt(stringList.get(2)));
        for(Flight flights:f_c.getAll_flights()){
            if(flights.getFlight_code().equals(input1)){
                Flight flight = flights;
                validate(input1, input2, input3);
                Ticket ticket = new Ticket(flight, list);
                all_tickets.add(ticket);
            }
        }
    }

    @Override
    public ArrayList<String> showInput(String textField1, String textField2, String textField3) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Flight Number: "+textField1);
        System.out.println("Seat Number: "+textField2);
        System.out.println("Luggage: "+textField3);
        System.out.println();
        list.add(textField1);
        list.add(textField2);
        list.add(textField3);
        return list;
    }

    @Override
    public DefaultListModel<String> showData() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Ticket tickets:all_tickets) {
            model.addElement(tickets.toString());
        }
        return model;
    }
}
