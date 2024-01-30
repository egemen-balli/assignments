//Egemen BALLI 6 Nov 2023
public abstract class Car {
    String modelName;
    double weight, acceleration, topSpeed, price;

    void displayCarSpecs(){
        System.out.println("Model Name: " + modelName);
        System.out.println("Weight: " + weight);
        System.out.println("Acceleration: " + acceleration);
        System.out.println("Top Speed: " + topSpeed);
        System.out.println("Price: " + price);
        System.out.println("Origin Country: " + originOfTheCar());
        System.out.println("Production Time: " + productionTime());
        System.out.println("Delivery Time: " + deliveryTime());
    }

    abstract double deliveryTime();

    abstract double productionTime();

    abstract String originOfTheCar();
}
