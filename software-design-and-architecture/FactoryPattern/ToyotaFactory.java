//Egemen BALLI 6 Nov 2023
public class ToyotaFactory extends CarBrand{
    @Override
    Car createCar(String type) {
        if(type.equals("Sedan")){
            return new ToyotaSedan();
        } else if (type.equals("SUV")) {
            return new ToyotaSUV();
        } else if (type.equals("Hatchback")) {
            return new ToyotaHatchback();
        }
        return null;
    }
}
