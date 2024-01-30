//Egemen BALLI 6 Nov 2023
public class RenaultFactory extends CarBrand{
    @Override
    Car createCar(String type) {
        if(type.equals("Sedan")){
            return new RenaultSedan();
        } else if (type.equals("SUV")) {
            return new RenaultSUV();
        } else if (type.equals("Hatchback")) {
            return new RenaultHatchback();
        }
        return null;
    }
}
