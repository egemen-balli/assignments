//Egemen BALLI 10 Oct 2023
class Circle extends TwoDimShapes implements I2DCalculatable{
    double radius;

    Circle(String shapeTypes, String nameOfShapes, double radius){
        super(shapeTypes, nameOfShapes);
        this.radius = radius;
    }

    public double calculateArea(){
        return Math.PI*radius*radius;
    }

    public double calculatePerimeter(){
        return Math.PI*radius*2;
    }

    @Override
    public String toString() {
        return this.shapeTypes + "{shapeTypes=2d} " + nameOfShapes + "{radius=" + radius + " perimeter=" + calculatePerimeter() + " area=" + calculateArea() + "}";
    }
}