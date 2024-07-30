import java.util.Scanner;

public class lab7 {
    //q1
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter foot");
        double foot=sc.nextDouble();
        System.out.println("meter:"+footToMeter(foot));
    }

    public static double footToMeter(double foot){
        return 0.305*foot;
    }*/

    //q2
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter an integer");
        int number= sc.nextInt();
        if(divisibleBy3(number)){
            System.out.println(number+" divisible by 3");
        }
        else System.out.println(number+" can not divisible by 3");
    }

    public static boolean divisibleBy3(int number){
        if(number%3==0)return true;
        return false;
    }*/

    //q3
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter 3 numbers");
        System.out.println("sum:"+sum(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
    }

    public static double sum(double a,double b,double c){
        return a+b+c;
    }
}
