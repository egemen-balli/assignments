//Egemen BALLI 10 Oct 2023
class Sphere extends ThreeDimShapes implements I2DCalculatable, I3DCalculatable{
    double radius;

    Sphere(String shapeTypes, String nameOfShapes, double radius){
        super(shapeTypes, nameOfShapes);
        this.radius = radius;
    }

    public double calculateVolume(){
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }

    public double calculateArea(){
        return 4*Math.PI*radius*radius;
    }

    public double calculatePerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return this.shapeTypes + "{shapeTypes=3d} " + nameOfShapes + "{radius=" + radius + " volume=" + calculateVolume() + " area=" + calculateArea() + " perimeter=" + calculatePerimeter() + "}";
    }
}