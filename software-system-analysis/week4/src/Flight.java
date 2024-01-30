//Egemen Balli 28 Feb 2023
import java.util.ArrayList;
import java.util.Arrays;

public class Flight {
    private static int SEAT_NUMBER = 120;
    private String flight_code;
    private String departure;
    private String destination;
    private boolean canceled;
    private int[] seats;

    public Flight(ArrayList<String> info){
        canceled = false;
        seats = new int[SEAT_NUMBER];
        flight_code = info.get(0);
        departure = info.get(1);
        destination = info.get(2);
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getFlight_code() {
        return flight_code;
    }

    @Override
    public String toString() {
        return flight_code + " " + departure + " " + destination;
    }
}
