//Egemen BALLI 6 Nov 2023
public class MercedesHatchback extends Car{

    public MercedesHatchback() {
        modelName = "A";
        weight = 1;
        acceleration = 1;
        topSpeed = 1;
        price = 1;
    }

    @Override
    double deliveryTime() {
        return 1;
    }

    @Override
    double productionTime() {
        return 1;
    }

    @Override
    String originOfTheCar() {
        return "Germany";
    }
}
