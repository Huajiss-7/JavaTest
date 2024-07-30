import java.io.File;
import java.io.IOException;

public class File3 {
    public static void main(String[] args) throws IOException {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\c.txt");
        boolean newFile1 = f1.createNewFile();//返回是否创建成功
        System.out.println(newFile1);
        File f2=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\ccc");
        boolean newFile2 = f2.createNewFile();//返回是否创建成功
        System.out.println(newFile2);

        System.out.println("-------------");
        File f3=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\ddd");
        boolean mkdir = f3.mkdir();
        System.out.println(mkdir);

        File f4=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\eee\\fff");
        boolean mkdir1 = f4.mkdirs();
        System.out.println(mkdir1);

        System.out.println("-------------");
        File f5=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\ccc");
        boolean delete = f5.delete();
        System.out.println(delete);
    }
}
