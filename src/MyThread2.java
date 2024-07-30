import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread2 extends Thread{
    //static 表示这个类的所有对象共用这个数据
    static int ticket = 0;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //1.循环
        while(true){
            //2.同步代码块
            //锁对象一定要是唯一的，MyThread2.class表示这个类在文件中的字节码文件是唯一的
            //synchronized (MyThread2.class){
            lock.lock(); //2 //3
            try {
                //3.判断
                if(ticket == 100){
                    break;
                    //4.判断
                }else{
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "在卖第" + ticket + "张票！！！");
                }
                //  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
//}
