//Egemen BALLI 6 Nov 2023
public class RenaultSedan extends Car{
    public RenaultSedan() {
        modelName = "B";
        weight = 5;
        acceleration = 5;
        topSpeed = 5;
        price = 5;
    }

    @Override
    double deliveryTime() {
        return 5;
    }

    @Override
    double productionTime() {
        return 5;
    }

    @Override
    String originOfTheCar() {
        return "France";
    }
}
