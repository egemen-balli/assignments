//Egemen BALLI 6 Nov 2023
import com.sun.net.httpserver.Authenticator;

public class RenaultHatchback extends Car{
    public RenaultHatchback() {
        modelName = "B";
        weight = 4;
        acceleration = 4;
        topSpeed = 4;
        price = 4;
    }

    @Override
    double deliveryTime() {
        return 4;
    }

    @Override
    double productionTime() {
        return 4;
    }

    @Override
    String originOfTheCar() {
        return "France";
    }
}
