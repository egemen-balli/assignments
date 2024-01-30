//Egemen BALLI 13 Nov 2023
public class MotorcycleFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }
}
