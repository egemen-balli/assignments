//Egemen BALLI 16 Oct 2023
public abstract class CargoCompany{
    DeliveryStrategy deliveryStrategy;
    PricingStrategy pricingStrategy;

    public CargoCompany(DeliveryStrategy deliveryStrategy, PricingStrategy pricingStrategy) {
        this.deliveryStrategy = deliveryStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    abstract void printComp();
}
