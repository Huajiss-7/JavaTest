import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 异常1 {
    public static void main(String[] args) throws ParseException {
        //practice1();
        //practice2();

        System.out.println("aaa");
        System.out.println(2/0);//执行到异常就不会继续执行下面的代码了
        System.out.println("bbb");
        System.out.println("ccc");

    }

    private static void practice2() {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个0-100的整数");
        int a=sc.nextInt();
        if(a>=0&&a<=100){
            System.out.println("a="+a);
        }else {
            throw new RuntimeException();
        }
    }

    private static void practice1() throws ParseException {
        String time="2030年1月1日";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        Date d1 = sdf.parse(time);
        System.out.println(d1);
    }
}
