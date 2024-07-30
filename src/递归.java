public class 递归 {
    public static void main(String[] args) {
        System.out.println("-------求和-------");
        int sum=sumHundred(100);
        System.out.println(sum);
        System.out.println("-------阶乘-------");
        int sumFactorial=factorial(5);
        System.out.println(sumFactorial);
    }

    public static int factorial(int num){
        if(num==1)return 1;
        num=num*factorial(num-1);
        return num;
    }

    public static int sumHundred(int num){
        if(num==1)return 1;
        num=num+sumHundred(num-1);
        return num;
    }
}
