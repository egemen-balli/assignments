//Egemen BALLI 13 Nov 2023
public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Engine createEngine() {
        return new GasolineEngine();
    }
}
