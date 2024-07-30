import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 文件拷贝 {
    public static void main(String[] args) throws IOException {
        //源文件
        FileInputStream fis=new FileInputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\test.txt");
        //目标地址+拷贝之后的文件名
        FileOutputStream fos=new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\copy\\test.txt");
         int b;
         while ((b=fis.read())!=-1){
             fos.write(b);
         }
         //先开后关
         fos.close();
         fis.close();
    }
}
