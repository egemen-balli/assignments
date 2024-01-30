//Egemen BALLI 10 Oct 2023
class Cube extends ThreeDimShapes implements I3DCalculatable{
    double edge;

    Cube(String shapeTypes, String nameOfShapes, double edge){
        super(shapeTypes, nameOfShapes);
        this.edge = edge;
    }

    public double calculateVolume(){
        return edge*edge*edge;
    }

    @Override
    public String toString() {
        return this.shapeTypes + "{shapeTypes=3d} " + nameOfShapes + "{edge=" + edge + " volume=" + calculateVolume() + "}";
    }
}