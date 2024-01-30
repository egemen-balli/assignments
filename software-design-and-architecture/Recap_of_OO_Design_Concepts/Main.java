//Egemen BALLI 10 Oct 2023
public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube("ThreeDimShape", "Cube", 5.0);
        Rectangle rectangle = new Rectangle("TwoDimShape", "Rectangle", 5.0, 10.0);
        Sphere sphere = new Sphere("ThreeDimShape", "Sphere", 5.0);
        Circle circle = new Circle("TwoDimShape", "Circle", 5.0);

        System.out.println(cube);
        System.out.println(rectangle);
        System.out.println(sphere);
        System.out.println(circle);
    }
}