import java.util.Scanner;

public class 正则表达式控制输入2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Pattern p1=Pattern.compile("[\\d&&[^0]]\\d{0,9}");
        System.out.println("输入整数");
        while (true){
            String i1=sc.nextLine();
        if(i1.matches("[\\d&&[^0]]\\d{0,9}")){
            int i2=Integer.parseInt(i1);
            System.out.println(i2);
        }else {
            System.out.println("无效数据");
        }
        }//while
    }
}
