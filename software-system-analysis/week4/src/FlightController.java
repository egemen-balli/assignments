//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightController implements BaseController{
    private Scanner input = new Scanner(new File("cities.txt"));
    private ArrayList<Flight> all_flights;
    private ArrayList<String> departure_cities;
    private ArrayList<String> destination_cities;

    public FlightController() throws FileNotFoundException {
        this.all_flights = new ArrayList<>();
        this.departure_cities = new ArrayList<>();
        this.destination_cities = new ArrayList<>();

        ArrayList<String> arrayList = new ArrayList<>();
        while(input.hasNextLine()){
            arrayList.add(input.nextLine());
        }
        int i = 0;
        if(arrayList.get(i).equals("Departure")){
            i++;
            while (!arrayList.get(i).equals("Destination")){
                departure_cities.add(arrayList.get(i));
                i++;
            }
            i++;
            while(i < arrayList.size()){
                destination_cities.add(arrayList.get(i));
                i++;
            }
        }
    }

    public ArrayList<Flight> getAll_flights() {
        return all_flights;
    }

    @Override
    public void validate(String flightCode, String departure, String destination) throws Exception{
        int error = 1;
        if(!all_flights.isEmpty()){
            for(int i = 0; i < all_flights.size(); i++){
                if(all_flights.get(i).getFlight_code().equals(flightCode)){
                    error = 0;
                }
            }
            if(error == 0){
                throw new Exception("Flight code is exist");
            }
        }

        error = 1;
        for(int i = 0; i < departure_cities.size(); i++){
            if(departure_cities.get(i).equals(departure)){
                error = 0;
            }
        }
        if(error == 1){
            throw new Exception(departure+" is not a valid departure city");
        }

        error = 1;
        for(int i = 0; i < destination_cities.size(); i++){
            if(destination_cities.get(i).equals(destination)){
                error = 0;
            }
        }
        if(error == 1){
            throw new Exception(destination+" is not a valid destination city");
        }
    }

    @Override
    public void create(String input1, String input2, String input3) throws Exception{
        validate(input1, input2, input3);
        Flight flight = new Flight(showInput(input1, input2, input3));
        all_flights.add(flight);
    }

    @Override
    public ArrayList<String> showInput(String textField1,String textField2,String textField3) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Flight Code: "+textField1);
        System.out.println("Departure City: "+textField2);
        System.out.println("Destination City: "+textField3);
        System.out.println();
        list.add(textField1);
        list.add(textField2);
        list.add(textField3);
        return list;
    }

    @Override
    public DefaultListModel<String> showData() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Flight flights:all_flights) {
            model.addElement(flights.toString());
        }
        return model;
    }
}
