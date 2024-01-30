//Egemen BALLI 6 Nov 2023
public class MercedesSUV extends Car{
    public MercedesSUV() {
        modelName = "A";
        weight = 3;
        acceleration = 3;
        topSpeed = 3;
        price = 3;
    }

    @Override
    double deliveryTime() {
        return 3;
    }

    @Override
    double productionTime() {
        return 3;
    }

    @Override
    String originOfTheCar() {
        return "Germany";
    }
}
