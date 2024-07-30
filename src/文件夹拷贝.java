import java.io.*;

public class 文件夹拷贝 {
    public static void main(String[] args) throws IOException {
        File start=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\copy\\start");
        File end=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\copy\\end");

        copydir(start,end);
    }

    public static void copydir(File src,File dest) throws IOException {
        dest.mkdirs();
        for (File file : src.listFiles()) {
            if(file.isFile()){
                FileInputStream fis=new FileInputStream(file);
                FileOutputStream fos=new FileOutputStream(new File(dest,file.getName()));
                byte []bytes=new byte[1024];
                int len;
                while ((len=fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
            }else {
                copydir(file,new File(dest,file.getName()));
            }
        }
    }
}
