//Egemen BALLI 11 Dec 2023
public class MovingUpState implements ElevatorState {
    private Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void pressButton(int destinationFloor) {
        System.out.println("Elevator is moving up to floor " + destinationFloor);
        elevator.setCurrentFloor(destinationFloor);
    }
}
