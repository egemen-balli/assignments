//Egemen BALLI 6 Nov 2023
public class MercedesSedan extends Car{
    public MercedesSedan() {
        modelName = "A";
        weight = 2;
        acceleration = 2;
        topSpeed = 2;
        price = 2;
    }

    @Override
    double deliveryTime() {
        return 2;
    }

    @Override
    double productionTime() {
        return 2;
    }

    @Override
    String originOfTheCar() {
        return "Germany";
    }
}
