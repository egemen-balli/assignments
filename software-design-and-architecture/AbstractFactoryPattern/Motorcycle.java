//Egemen BALLI 13 Nov 2023
public class Motorcycle implements Vehicle{
    @Override
    public void startEngine() {
        System.out.println("Motorcycle Engine has Started Working.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle Engine has Stopped Working.");
    }
}
