package CSC3101.网工.lab6;

import CSC3101.网工.lab5.lab5;

import java.io.*;
import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) throws IOException {
        File file4Read=new File("rectData.dat");
        File file4Write=new File("rectInfo.txt");
        if(!file4Write.exists()){
            file4Write.createNewFile();
        }
        try (Scanner input=new Scanner(file4Read);PrintWriter output=new PrintWriter(new FileWriter(file4Write,true))){
            for (int i=0;i<15;i++){
                if(input.hasNextLine()){
                    String line = input.nextLine();
                    String[] info = line.split(" ");
                    Rectangle rectangle=new Rectangle(Double.parseDouble(info[0]),Double.parseDouble(info[0]));
                    output.write("weight:"+rectangle.getWidth()+" length:"+rectangle.getLength()+" area"+rectangle.getArea()+" parameter:"+rectangle.getPerimeter()+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("404\nfile not found");
            System.exit(0);
        }
    }
}

class Rectangle{
    private double width; // 宽度
    private double length; // 长度
    private static int noofObj = 0; // 共享的对象数量

    // 无参数构造函数
    public Rectangle() {
        this(1.0, 1.0); // 默认宽度和长度为1.0
    }

    // 带参数构造函数
    public Rectangle(double width, double length) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("宽度和长度必须大于0");
        }
        this.width = width;
        this.length = length;
        noofObj++;
    }

    // 获取宽度
    public double getWidth() {
        return width;
    }

    // 设置宽度
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("宽度必须大于0");
        }
        this.width = width;
    }

    // 获取长度
    public double getLength() {
        return length;
    }

    // 设置长度
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("长度必须大于0");
        }
        this.length = length;
    }

    // 获取对象数量
    public static int getNoofObj() {
        return noofObj;
    }

    // 计算周长
    public double getPerimeter() {
        return 2 * (width + length);
    }

    // 计算面积
    public double getArea() {
        return width * length;
    }

    // 显示面积和周长
    public void displayAreaPerimeter() {
        System.out.println("面积: " + getArea() + ", 周长: " + getPerimeter());
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "宽度: " + width + ", 长度: " + length + ", 面积: " + getArea() + ", 周长: " + getPerimeter();
    }

    public boolean hasLargerArea(lab5 r2){
        return this.getArea()>r2.getArea();
    }

    public boolean isEqual(lab5 r2){
        return this.getArea()==r2.getArea();
    }
}