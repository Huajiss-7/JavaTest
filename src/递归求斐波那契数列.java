import java.util.Scanner;

public class 递归求斐波那契数列 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入斐波那契数列项数");
        int num=input.nextInt();
        if(num>20){
            System.out.println("饶了CPU吧");
            System.exit(0);
        }
        //System.out.print("1 ");
        for (int i = 1; i <=num; i++) {
            long f=forge(i);
            System.out.print(f+" ");
        }
    }

    public static long forge(int num){
        if(num==1||num==2){
            //System.out.print("1 ");
            return 1;}
        long a=forge(num-1)+forge(num-2);
        //System.out.print(a+" ");
        return a;
    }

}
