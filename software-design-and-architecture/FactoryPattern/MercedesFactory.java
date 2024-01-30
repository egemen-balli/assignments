//Egemen BALLI 6 Nov 2023
public class MercedesFactory extends CarBrand{
    @Override
    Car createCar(String type) {
        if(type.equals("Sedan")){
            return new MercedesSedan();
        } else if (type.equals("SUV")) {
            return new MercedesSUV();
        } else if (type.equals("Hatchback")) {
            return new MercedesHatchback();
        }
        return null;
    }
}
