public class system {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        //System.out.println(start);
        //System.exit(0);
        for (int i = 0; i <10000000 ; i++) {

        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);//用于判断程序运行时间
    }
}
