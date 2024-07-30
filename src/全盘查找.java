import java.io.File;

public class 全盘查找 {
    public static void main(String[] args) {
        /*File src=new File("C:\\");
        findAVI(src);*/
        findAVI();
    }

    public static void findAVI(){
        File[] files = File.listRoots();//查找所有盘符
        for (File file : files) {
            findAVI(file);
        }
    }

    public static void findAVI(File src){
        if(src.listFiles()==null) System.out.println(src);//没有权限访问的文件夹会返回null,导致数组里为空

        if(src.listFiles()!=null) {
            for (File file : src.listFiles()) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".avi")) System.out.println(file);
                } else {
                    findAVI(file);
                }
            }//for
        }

    }//函数
}
