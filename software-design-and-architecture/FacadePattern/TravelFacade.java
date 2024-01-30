//Egemen BALLI 11 Dec 2023
public class TravelFacade {
    private FlightBookingSystem flightBookingSystem;
    private HotelReservationSystem hotelReservationSystem;
    private CarRentalSystem carRentalSystem;
    private ActivityBookingSystem activityBookingSystem;
    private InsuranceSystem insuranceSystem;
    private NotificationService notificationService;

    public TravelFacade() {
        this.flightBookingSystem = new FlightBookingSystem();
        this.hotelReservationSystem = new HotelReservationSystem();
        this.carRentalSystem = new CarRentalSystem();
        this.activityBookingSystem = new ActivityBookingSystem();
        this.insuranceSystem = new InsuranceSystem();
        this.notificationService = new NotificationService();
    }

    public void planTrip(String departureCity, String destinationCity, String departureDate, String checkInDate, String checkOutDate, String activityDate, String startDate, String endDate, int numberOfDays, String activity) {
        flightBookingSystem.bookFlight(departureCity, destinationCity, departureDate);
        hotelReservationSystem.reserveHotel(destinationCity, checkInDate, checkOutDate);
        carRentalSystem.rentCar(destinationCity, startDate, numberOfDays);
        activityBookingSystem.bookActivity(destinationCity, activityDate, activity);
        insuranceSystem.purchaseInsurance(destinationCity, startDate, endDate);
        notificationService.notifyUser("Your trip is booked successfully!");
    }
}
