//Egemen BALLI 16 Oct 2023
public class CargoCompB extends CargoCompany{
    public CargoCompB() {
        super(new ExpressDelivery(), new FlatRatePricing());
    }

    public void printComp() {
        System.out.println("CargoCompB:");
        deliveryStrategy.printDeliveryType();
        System.out.println("Estimated Delivery Time: " + deliveryStrategy.calculateDeliveryTime() + " days");
        System.out.println("Delivery Price: $" + pricingStrategy.calculateDeliveryPrice());
        System.out.println();
    }
}
