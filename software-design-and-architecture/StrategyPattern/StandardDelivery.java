//Egemen BALLI 16 Oct 2023
public class StandardDelivery implements DeliveryStrategy{
    @Override
    public void printDeliveryType() {
        System.out.println("Standard Delivery");
    }

    @Override
    public int calculateDeliveryTime() {
        return 3;
    }
}
