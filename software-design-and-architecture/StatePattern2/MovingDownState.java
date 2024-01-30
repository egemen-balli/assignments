//Egemen BALLI 11 Dec 2023
public class MovingDownState implements ElevatorState {
    private Elevator elevator;

    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void pressButton(int destinationFloor) {
        System.out.println("Elevator is moving down to floor " + destinationFloor);
        elevator.setCurrentFloor(destinationFloor);
    }
}
