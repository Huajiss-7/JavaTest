package 阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{

    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            //不断从阻塞队列中获取面条
            try {
                String food = queue.take();//自带锁
                System.out.println(food);//打印语句在锁的外面，所以有可能重复打印，对数据不造成影响，比如执行到没有食物了但又抢到了线程，上面的取出代码就会wait，但接着执行打印代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
