import java.io.File;

public class File1 {
    public static void main(String[] args) {
        String str="C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest";
        File f1=new File(str);
        System.out.println(f1);

        String parent="C:\\Users\\13063\\Desktop\\upm学习\\编程概念";
        String child="fileTest";
        File f2=new File(parent,child);
        System.out.println(f2);

        File f3=new File(parent+"\\"+child);
        System.out.println(f3);

        File parent2=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念");
        File f4=new File(parent2,child);
        System.out.println(f4);

    }
}
