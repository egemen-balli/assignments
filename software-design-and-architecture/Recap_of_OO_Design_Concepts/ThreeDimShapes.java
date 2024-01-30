//Egemen BALLI 10 Oct 2023
abstract class ThreeDimShapes extends Shape{
    String shapeTypes;

    ThreeDimShapes(String shapeTypes, String nameOfShapes){
        super(nameOfShapes);
        this.shapeTypes = shapeTypes;
    }
}