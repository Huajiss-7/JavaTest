package CSC3101;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:9
public class lab9 {
    public static void main(String[] args) {
        //q1
        /*Scanner sc=new Scanner(System.in);
        System.out.println("please enter three sides ,color and whether its filled of the triangle");
        Triangle triangle=new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.next(),sc.nextBoolean() );
        System.out.println("trigle->color:"+triangle.getColor()+"\nis filled?: "+ triangle.isFilled()+"\narea: "+triangle.getArea()+"\nperimeter:"+triangle.getPerimeter());*/

        //q2
        Triangle t1 = new Triangle(3, 4, 5, "blue", true);
        Triangle t2 = new Triangle(6, 8, 10, "red", false);
        GeometricObject gmax = GeometricObject.max(t1, t2);
        System.out.println("max is :"+(gmax==t1?"t1":"t2"));

        Circle c1=new Circle("black",true,2);
        Circle c2=new Circle("white",false,1);
        GeometricObject cmax = GeometricObject.max(c1, c2);
        System.out.println("max is :"+(cmax==t1?"c1":"c2"));
    }
}


class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        return Math.sqrt(getPerimeter() / 2 * (getPerimeter() / 2 - side1) * (getPerimeter() / 2 - side2) * (getPerimeter() / 2 - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public int compareTo(Object o) {
        Triangle o1 = (Triangle) o;
        return (int) (this.getArea() - o1.getArea());
    }
}


abstract class GeometricObject implements Comparable {
    private String color;

    private boolean filled;

    public GeometricObject() {
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public static GeometricObject max(GeometricObject g1, GeometricObject g2) {
        int i = g1.compareTo(g2);
        if (i > 0) return g1;
        else return g2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();

    abstract public double getPerimeter();
}

class Circle extends GeometricObject {

    private double radius;

    public Circle() {
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Object o) {
        Circle o1 = (Circle) o;
        return (int) (this.getArea() - o1.getArea());
    }
}
