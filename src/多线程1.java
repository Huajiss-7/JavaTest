public class 多线程1 {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.setName("线程1");
        //t2.setName("线程2");

        t1.setPriority(1);
        t2.setPriority(10);//优先级高，执行概率高，先执行完概率高

        t1.start();
        t2.start();
    }
}
