//Egemen Balli 21 Feb 2023

public class Rocket implements SpaceShip{
    private double currentWeight;
    private double cargoLimit;
    private double rocketCost;

    public Rocket(double currentWeight, double cargoLimit, double rocketCost) {
        this.currentWeight = currentWeight;
        this.cargoLimit = cargoLimit;
        this.rocketCost = rocketCost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(double weight) {
        return !(currentWeight + weight >= cargoLimit);
    }

    @Override
    public double carry(double weight) {
        currentWeight += weight;
        return weight + currentWeight;
    }

    public double getRocketCost() {
        return rocketCost;
    }
}
