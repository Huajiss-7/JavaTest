package CSC3101.lab11;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:11
public class Q1 {
    public static void main(String[] args) {
        GeometricObject[] geometricObjects = new GeometricObject[5];
        geometricObjects[0] = new Square1(1);
        geometricObjects[1] = new Square1(2);
        geometricObjects[2] = new Square1(3);
        geometricObjects[3] = new Square1(4);
        geometricObjects[4] = new Square1(5);

        for (int i=0;i<geometricObjects.length;i++) {
            System.out.println("Area" +(i+1)+": "+ geometricObjects[i].area());
            if (geometricObjects[i] instanceof Colorable) {
                ((Colorable) geometricObjects[i]).howToColor();
            }
        }
    }
}

 abstract class GeometricObject {
    public abstract double area();
}

 interface Colorable {
    void howToColor();
}

class Square1 extends GeometricObject implements Colorable {
    private double side;

    public Square1() {
        this.side = 0;
    }

    public Square1(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}