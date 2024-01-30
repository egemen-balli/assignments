//Egemen BALLI 6 Nov 2023
public class ToyotaHatchback extends Car{
    public ToyotaHatchback() {
        modelName = "C";
        weight = 7;
        acceleration = 7;
        topSpeed = 7;
        price = 7;
    }

    @Override
    double deliveryTime() {
        return 7;
    }

    @Override
    double productionTime() {
        return 7;
    }

    @Override
    String originOfTheCar() {
        return "Japan";
    }
}
