import java.util.Scanner;

public class 手动转二进制 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个整数");
        int num=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            int ge=num%2;
            sb.append(ge);
            num/=2;
        }
        System.out.println(sb.reverse());
    }
}
