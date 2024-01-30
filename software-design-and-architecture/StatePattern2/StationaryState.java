//Egemen BALLI 11 Dec 2023
public class StationaryState implements ElevatorState {
    private Elevator elevator;

    public StationaryState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void pressButton(int destinationFloor) {
        System.out.println("Elevator is stationary. Moving to floor " + destinationFloor);
        elevator.setCurrentFloor(destinationFloor);
    }
}
