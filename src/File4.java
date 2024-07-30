import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class File4 {
    public static void main(String[] args) {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest");
        File[] files = f1.listFiles();
        System.out.println(Arrays.toString(files));

        System.out.println("-------------");

        File[] files1 = File.listRoots();
        System.out.println(Arrays.toString(files1));

        System.out.println("-------------");

        String[] list = f1.list();//仅能获得名字
        System.out.println(Arrays.toString(list));

        System.out.println("-------------");

        String[] list1 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                System.out.println(src);
                return true;
            }
        });
        System.out.println(Arrays.toString(list1));

        System.out.println("-------------");

        String[] list2 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                return src.isFile()&&name.endsWith(".txt");
                //System.out.println(src);
            }
        });
        System.out.println(Arrays.toString(list2));
    }
}
