//Egemen BALLI 11 Dec 2023
public class Elevator {
    private ElevatorState movingDown;
    private ElevatorState movingUp;
    private ElevatorState stationary;

    private ElevatorState currentState;
    private int currentFloor;

    public Elevator() {
        this.movingDown = new MovingDownState(this);
        this.movingUp = new MovingUpState(this);
        this.stationary = new StationaryState(this);
        this.currentState = new StationaryState(this);
        this.currentFloor = 0;
    }

    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    public void pressButton(int destinationFloor) {
        if (currentFloor == 0) {
            this.setState(this.stationary);
        } else if (destinationFloor > currentFloor) {
            this.setState(this.movingUp);
        } else if (destinationFloor < currentFloor) {
            this.setState(this.movingDown);
        } else {
            System.out.println("You are already on that floor");
        }s
        currentState.pressButton(destinationFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getMovingDown() {
        return movingDown;
    }

    public ElevatorState getMovingUp() {
        return movingUp;
    }

    public ElevatorState getStationary() {
        return stationary;
    }
}
