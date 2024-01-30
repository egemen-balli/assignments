//Egemen Balli 28 Feb 2023
import java.util.ArrayList;

public class Ticket {
    public int CAPACITY = 30;
    public int EXTRA = 20;
    public int ECONOMY = 500;
    public int BUSINESS = 1000;
    public int FIRST = 1500;
    private Flight flight;
    private int price;
    private int seat_number;

    public Ticket(Flight flight, ArrayList<Integer> info){
        this.flight = flight;
        seat_number = info.get(1);
        if(0 <= seat_number && seat_number <= 20){
            price = FIRST;
        }else if (21 <= seat_number && seat_number <= 70){
            price = BUSINESS;
        } else if (71 <= seat_number && seat_number <= 120) {
            price = ECONOMY;
        }

        if(CAPACITY < info.get(2)){
            price = ((info.get(2)-CAPACITY)/3)*EXTRA;
        }
    }

    public int getSeat_number() {
        return seat_number;
    }

    @Override
    public String toString() {
        return
                "Flight: " + flight + "  price: " + price + "  Seat Number: " + seat_number;
    }
}
