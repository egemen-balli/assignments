//Egemen BALLI 16 Oct 2023
public class ExpressDelivery implements DeliveryStrategy{

    @Override
    public void printDeliveryType() {
        System.out.println("Express Delivery");
    }

    @Override
    public int calculateDeliveryTime() {
        return 1;
    }
}
