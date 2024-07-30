public class 可变参数 {
    public static void main(String[] args) {
        getSum(1,2,3,4,5,6,7,8,9,10);
    }

    public static void getSum(int...args){//实际是个数组
        int sum=0;
        for (int arg : args) {
            sum+=arg;
        }
        System.out.println(sum);
    }
}
