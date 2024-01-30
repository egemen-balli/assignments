//Egemen BALLI 16 Oct 2023
public class CargoCompC extends CargoCompany{

    public CargoCompC() {
        super(new StandardDelivery(), new VariableRatePricing());
    }

    public void printComp() {
        System.out.println("CargoCompC:");
        deliveryStrategy.printDeliveryType();
        System.out.println("Estimated Delivery Time: " + deliveryStrategy.calculateDeliveryTime() + " days");
        System.out.println("Delivery Price: $" + pricingStrategy.calculateDeliveryPrice());
        System.out.println();
    }
}
