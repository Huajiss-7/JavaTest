import java.io.FileOutputStream;
import java.io.IOException;

public class 字节输出流初见io流 {
    public static void main(String[] args) throws IOException {
        //写一段文字到本地文件
        FileOutputStream fos=new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\test.txt",true);
        //创建对象时后面写true表示开启续写，再写不会清空
        fos.write(97);//写的是ASCII码的值
        //fos.close();
        //System.out.println((int)'a');

        //一次写入多个数据
        byte[]bytes={98,99,100,101};
        fos.write(bytes,1,2);//off表示从第几个开始，len表示写入几个
        //fos.close();

        //续写或换行
        String s1="\r\nwoshihaoren";
        fos.write(s1.getBytes());
        fos.close();
    }
}
