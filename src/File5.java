import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class File5 {
    public static void main(String[] args) {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest");
        File[] files = f1.listFiles();
        for (File file : files) {
            if (file.isFile()&&file.getName().endsWith(".txt")){
                System.out.println(file);
            }
        }

        System.out.println("----------");

        File[] files1 = f1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile()&&pathname.toString().endsWith(".txt");
            }
        });

        for (File file : files1) {
            System.out.println(file);
        }

        System.out.println("-----------------");

        File[] files2 = f1.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir);
                System.out.println(name);
                File src=new File(dir,name);
                return src.isFile()&&src.getName().endsWith(".txt");
            }
        });
        System.out.println();
        for (File file : files2) {
            System.out.println(file);
        }
    }
}
