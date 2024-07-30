import java.util.ArrayList;
import java.util.Scanner;

public class 键盘录入求和 {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int sum=0,i=0;
        System.out.println("输入整数");
        while (sum<200){
        String i1= sc.nextLine();
        Integer i2=Integer.parseInt(i1);
        list.add(i2);
        sum+=list.get(i++);}
        System.out.println("输入总和大于200");
    }
}
