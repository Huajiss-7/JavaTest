import java.util.Scanner;

public class 键盘录入 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //String s1=sc.next();//123 123
        //System.out.println(s1);//123

        String s2=sc.nextLine();//123 123
        System.out.println(s2);//123 123

        String integer= sc.next();
        int i=Integer.parseInt(integer);
        System.out.println(i);
    }
}
