import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File2 {
    public static void main(String[] args) {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\a.txt");
        File f3=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest");
        System.out.println(f1.isFile());//判断file是不是文件
        System.out.println(f1.isDirectory());//判断file是不是文件夹
        System.out.println(f1.exists());//判断file是否存在
        System.out.println("-------------------");
        File f2=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\buCunZai");
        System.out.println(f2.isFile());//判断file是不是文件
        System.out.println(f2.isDirectory());//判断file是不是文件夹
        System.out.println(f2.exists());//判断file是否存在

        System.out.println("-----获取方法-----");

        long len = f1.length();
        System.out.println(len);//获取文件的字节大小
        long len1 = f3.length();//无法获取文件夹的大小，返回的是0
        System.out.println(len1);

        System.out.println("--------");

        String paht1=f1.getAbsolutePath();
        System.out.println(paht1);
        File f4=new File("AfterEclipse\\a.txt");//写上模块名就是从模块里找，只写文件名就是从整个项目里找
        String path2 = f4.getAbsolutePath();
        System.out.println(path2);

        System.out.println("--------");
        String path3 = f4.getPath();//创建对象时写的什么路径，返回就是什么
        System.out.println(path3);

        System.out.println("---------");
        String name1 = f4.getName();
        System.out.println(name1);
        String name2=f3.getName();
        System.out.println(name2);

        System.out.println("---------");
        long time = f1.lastModified();//文件最后一次修改的时间，毫秒值
        System.out.println(time);
        Date d1=new Date(time);
        //System.out.println(d1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(d1));
    }
}
