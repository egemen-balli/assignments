//Egemen BALLI 13 Nov 2023
public class Car implements Vehicle{
    @Override
    public void startEngine() {
        System.out.println("Car Engine has Started Working.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car Engine has Stopped Working.");
    }
}
