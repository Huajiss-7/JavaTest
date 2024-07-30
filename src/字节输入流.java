import java.io.FileInputStream;
import java.io.IOException;

public class 字节输入流 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\test.txt");
         int b1=fis.read();//调用一次读一次,读不到返回-1
        System.out.println((char)b1);
        //循环读取
        while ((b1=fis.read())!=-1){
            System.out.println((char)b1);
        }
        fis.close();
    }
}
