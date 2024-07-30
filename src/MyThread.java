public class MyThread extends Thread{

    public MyThread(){

    }
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+":"+i);
            //表示出让当前CPU的执行权,然后两者重新抢夺，尽可能让执行结果更均匀
            Thread.yield();
        }
    }

}

