public class 死锁Test {
    public static void main(String[] args) {
       /*
           需求：
                死锁
       */


        死锁 t1 = new 死锁();
        死锁 t2 = new 死锁();

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();

    }
}
