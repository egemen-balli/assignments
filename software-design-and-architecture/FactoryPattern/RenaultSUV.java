//Egemen BALLI 6 Nov 2023
public class RenaultSUV extends Car{
    public RenaultSUV() {
        modelName = "B";
        weight = 6;
        acceleration = 6;
        topSpeed = 6;
        price = 6;
    }

    @Override
    double deliveryTime() {
        return 6;
    }

    @Override
    double productionTime() {
        return 6;
    }

    @Override
    String originOfTheCar() {
        return "France";
    }
}
