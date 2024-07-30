import java.io.File;
import java.io.IOException;

public class File练习 {
    public static void main(String[] args) throws IOException {
        //test1
        creatFile();

        //test2
        boolean b = haveAVI(new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest"));
        if(b) System.out.println("文件夹有avi文件");else System.out.println("文件夹没有avi文件");

        //test3


    }

    public static void creatFile () throws IOException {
        File f1=new File("fileTest");
        boolean b1 = f1.mkdirs();
        System.out.println(b1);

        File f2=new File(f1,"a.txt");
        boolean newFile = f2.createNewFile();
        System.out.println(newFile);

        //File f3=new File("aaa.txt");
        //System.out.println(f3.createNewFile());
    }

    public static boolean haveAVI(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()&&file1.toString().endsWith(".avi"))return true;
        }
        return false;
    }
}
