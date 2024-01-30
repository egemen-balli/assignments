//Egemen BALLI 6 Nov 2023
public class ToyotaSUV extends Car{
    public ToyotaSUV() {
        modelName = "C";
        weight = 9;
        acceleration = 9;
        topSpeed = 9;
        price = 9;
    }

    @Override
    double deliveryTime() {
        return 9;
    }

    @Override
    double productionTime() {
        return 9;
    }

    @Override
    String originOfTheCar() {
        return "Japan";
    }
}
