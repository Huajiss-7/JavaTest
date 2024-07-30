import java.util.Scanner;

public class 教学 {
    static double[]arr=new double[5];

    public static void main(String[] args) {
        System.out.println(教学.add(1, 2));
        System.out.println(arr[0]);
        Scanner sc=new Scanner(System.in);
        displayBMI(11);

        int sum=add(1,2);
        System.out.println(sum);

        int a=10>5?0:1;
        System.out.println(a);

        System.out.println("随便输入");
        String s1=sc.nextLine();
        System.out.println(s1);
    }

    public static void displayBMI(int a){
        System.out.println("看我执行了没"+a);
    }

    public static int add(int x,int y){
        return x+y;
    }
}
