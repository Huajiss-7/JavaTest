package 测试;

public class test3{
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(); // Creating a rectangle object
        System.out.println("length:"+rectangle.length);
        System.out.println("width:"+rectangle.width);
        System.out.println("area:"+rectangle.Area());
        System.out.println("perimeter:"+rectangle.Perimeter());
    }
}

 class Rectangle {
    double length=2;
    double width=1;
    Rectangle(){

    }
    Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    double Area(){
        return length*width;
    }
    double Perimeter(){
        return 2*(length+width);
    }

}