import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class 转换流 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码读取(了解)

            因为JDK11：这种方式被淘汰了。替代方案(掌握)
            F:\JavaSE最新版\day29-IO（其他流）\资料\gbkfile.txt
        */

       /* //1.创建对象并指定字符编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\gbkfile.txt"),"GBK");
        //2.读取数据
        int ch;
        while ((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        //3.释放资源
        isr.close();*/


        FileReader fr = new FileReader("myio\\gbkfile.txt", Charset.forName("GBK"));
        //2.读取数据
        int ch;
        while ((ch = fr.read()) != -1){
            System.out.print((char)ch);
        }
        //3.释放资源
        fr.close();

        /*
            利用转换流按照指定字符编码写出
        */

/*
        //1.创建转换流的对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myio\\b.txt"),"GBK");
        //2.写出数据
        osw.write("你好你好");
        //3.释放资源
        osw.close();*/


            FileWriter fw = new FileWriter("myio\\c.txt", Charset.forName("GBK"));
            fw.write("你好你好");
            fw.close();



    }
}
