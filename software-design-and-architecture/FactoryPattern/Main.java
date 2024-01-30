//Egemen BALLI 6 Nov 2023
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        CarBrand mercedesFactory = new MercedesFactory();
        CarBrand toyotaFactory = new ToyotaFactory();
        CarBrand renaultFactory = new RenaultFactory();

        System.out.println("Enter brand choice.");
        String input1 = myObj.nextLine();

        System.out.println("Enter a body type.");
        String input2 = myObj.nextLine();

        switch(input1) {
            case "Mercedes":
                mercedesFactory.orderCar(input2).displayCarSpecs();
                break;
            case "Renault":
                renaultFactory.orderCar(input2).displayCarSpecs();
                break;
            case "Toyota":
                toyotaFactory.orderCar(input2).displayCarSpecs();
                break;
            default:
                mercedesFactory.orderCar(input2).displayCarSpecs();
        }
    }
}