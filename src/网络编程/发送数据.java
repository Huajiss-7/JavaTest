package 网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 发送数据 {
    public static void main(String[] args) throws IOException {
        //发送数据


        //1.创建DatagramSocket对象(快递公司)
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用
        //有参：指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        String str = "你好威啊！！！";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;//这个指定的是发到哪个端口，从哪个端口发出无所谓

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        //3.发送数据
        ds.send(dp);


        //4.释放资源
        ds.close();


    }
}
