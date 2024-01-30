//Egemen BALLI 6 Nov 2023
public abstract class CarBrand {
    public Car orderCar(String type) {
        Car car;
        car = createCar(type);
        return car;
    }

    abstract Car createCar(String type);
}
