import java.io.File;

public class 统计文件夹大小 {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\13063\\Desktop\\upm学习");
        long len=getlen(file);
        System.out.println("文件夹的大小为"+(len/1024)/1024+"MB");
    }

    public static long getlen(File src){
        long len=0;
        for (File file : src.listFiles()) {
            if(file.isFile()){
                len+=file.length();
            }else {
                len+=getlen(file);
            }
        }
        return len;
    }
}
