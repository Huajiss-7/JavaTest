package CSC3101.网工.lab5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lab5 {
    private double width; // 宽度
    private double length; // 长度
    private static int noofObj = 0; // 共享的对象数量

    // 无参数构造函数
    public lab5() {
        this(1.0, 1.0); // 默认宽度和长度为1.0
    }

    // 带参数构造函数
    public lab5(double width, double length) {
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


class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        lab5[] rectangles = new lab5[10]; // 创建一个包含10个Rectangle对象的数组

        // 选择随机生成矩形还是手动输入
        System.out.println("请选择创建矩形的方式：1. 随机生成 2. 手动输入");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // 随机生成矩形
            for (int i = 0; i < rectangles.length; i++) {
                double width = Math.random() * 20 + 1;    // 随机宽度在1到21之间
                double length = Math.random() * 20 + 1;   // 随机长度在1到21之间
                try {
                    rectangles[i] = new lab5(width, length);
                } catch (IllegalArgumentException e) {
                    System.out.println("错误: " + e.getMessage());
                }
            }
        } else {
            // 手动输入矩形
            for (int i = 0; i < rectangles.length; i++) {
                System.out.println("输入矩形 " + (i + 1) + " 的宽度和长度：");
                double width = scanner.nextDouble();
                double length = scanner.nextDouble();
                try {
                    rectangles[i] = new lab5(width, length);
                } catch (IllegalArgumentException e) {
                    System.out.println("错误: " + e.getMessage());
                    i--; // 重新输入当前矩形
                }
            }
        }

        // 保留两位小数
        DecimalFormat df = new DecimalFormat("#.##");

        // 显示每个矩形的属性
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i] != null) {
                lab5 rectangle = rectangles[i];
                System.out.println("矩形 " + (i + 1));
                System.out.println("宽度: " + df.format(rectangle.getWidth()));
                System.out.println("长度: " + df.format(rectangle.getLength()));
                System.out.println("面积: " + df.format(rectangle.getArea()));
                System.out.println("周长: " + df.format(rectangle.getPerimeter()));


                if (rectangles[0] != null && rectangles[1] != null) {
                    if (rectangles[0].hasLargerArea(rectangles[1])) {
                        System.out.println("矩形 1 的面积大于矩形 2 的面积");
                    } else {
                        System.out.println("矩形 1 的面积不大于矩形 2 的面积");
                    }

                    // 检查第一个矩形和第二个矩形是否相等
                    if (rectangles[0].isEqual(rectangles[1])) {
                        System.out.println("矩形 1 和矩形 2 是相等的");
                    } else {
                        System.out.println("矩形 1 和矩形 2 不是相等的");
                    }
                }

                System.out.println("创建的矩形对象总数: " + lab5.getNoofObj());

                scanner.close();
            }
        }


    }
}