//Egemen BALLI 10 Oct 2023
class Rectangle extends TwoDimShapes implements I2DCalculatable{
    double height;
    double width;

    Rectangle(String shapeTypes, String nameOfShapes, double height, double width){
        super(shapeTypes, nameOfShapes);
        this.height = height;
        this.width = width;
    }

    public double calculateArea(){
        return height*width;
    }

    public double calculatePerimeter(){
        return 2*(height+width);
    }

    @Override
    public String toString() {
        return this.shapeTypes + "{shapeTypes=2d} " + nameOfShapes + "{height=" + height + " width=" + width + " perimeter=" + calculatePerimeter() + " area=" + calculateArea() + "}";
    }
}