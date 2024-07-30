public class 包装类测试 {
    public static void main(String[] args) {
        Integer a=1;
        test1(a);
        System.out.println(a);
    }

    public static void test1(Integer a){
        a=2;
    }
}
