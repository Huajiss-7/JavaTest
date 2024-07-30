import java.io.File;
import java.io.IOException;

public class 删除一个多级文件夹 {
    public static void main  (String[] args)throws IOException {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\beUsedToDelete");
        System.out.println(f1.mkdir());
        File f2=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\beUsedToDelete\\aaa.txt");
        File f3=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\beUsedToDelete\\bbb.txt");
        System.out.println(f2.createNewFile()+" "+f3.createNewFile());
        System.out.println(f1.delete());
        delete(f1);
    }

    //作用:删掉src文件夹
    //参数：要删除的文件夹
    public static void delete(File src){
        File []files=src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }else {
                delete(file);
            }
        }
        src.delete();//递归完再删掉自己

    }
}
