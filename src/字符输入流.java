import java.io.FileReader;
import java.io.IOException;

public class 字符输入流 {
    public static void main(String[] args) throws IOException {
        /*
            第一步：创建对象
            public FileReader(File file)        创建字符输入流关联本地文件
            public FileReader(String pathname)  创建字符输入流关联本地文件

            第二步：读取数据
            public int read()                   读取数据，读到末尾返回-1
            public int read(char[] buffer)      读取多个数据，读到末尾返回-1

            第三步：释放资源
            public void close()                 释放资源/关流
        */

        //1.创建对象并关联本地文件
        FileReader fr = new FileReader("C:\\Users\\13063\\IdeaProjects\\AfterEclipse\\a.txt");
        //2.读取数据 read()
        //字符流的底层也是字节流，默认也是一个字节一个字节的读取的。
        //如果遇到中文就会一次读取多个，GBK一次读两个字节，UTF-8一次读三个字节

        //read（）细节：
        //1.read():默认也是一个字节一个字节的读取的,如果遇到中文就会一次读取多个
        //2.在读取之后，方法的底层还会进行解码并转成十进制。
        //  最终把这个十进制作为返回值
        //  这个十进制的数据也表示在字符集上的数字
        //  英文：文件里面二进制数据 0110 0001
        //          read方法进行读取，解码并转成十进制97
        //  中文：文件里面的二进制数据 11100110 10110001 10001001
        //          read方法进行读取，解码并转成十进制27721

        // 我想看到中文汉字，就是把这些十进制数据，再进行强转就可以了

        int ch;
        while((ch = fr.read()) != -1){
            System.out.print((char)ch);
        }

        //3.释放资源
        fr.close();

        System.out.println();
        System.out.println("----------");
        //第二种带参数read()方式
        /*
            第一步：创建对象
            public FileReader(File file)        创建字符输入流关联本地文件
            public FileReader(String pathname)  创建字符输入流关联本地文件

            第二步：读取数据
            public int read()                   读取数据，读到末尾返回-1
            public int read(char[] buffer)      读取多个数据，读到末尾返回-1

            第三步：释放资源
            public void close()                 释放资源/关流
        */


        //1.创建对象
        FileReader fr1 = new FileReader("a.txt");
        //2.读取数据
        char[] chars = new char[2];
        int len;
        //read(chars)：读取数据，解码，强转三步合并了，把强转之后的字符放到数组当中
        //空参的read + 强转类型转换
        while((len = fr1.read(chars)) != -1){
            //把数组中的数据变成字符串再进行打印
            System.out.print(new String(chars,0,len));
        }
        //3.释放资源
        fr1.close();





    }
}
