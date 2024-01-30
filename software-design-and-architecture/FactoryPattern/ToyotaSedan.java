//Egemen BALLI 6 Nov 2023
public class ToyotaSedan extends Car{
    public ToyotaSedan() {
        modelName = "C";
        weight = 8;
        acceleration = 8;
        topSpeed = 8;
        price = 8;
    }

    @Override
    double deliveryTime() {
        return 8;
    }

    @Override
    double productionTime() {
        return 8;
    }

    @Override
    String originOfTheCar() {
        return "Japan";
    }
}
