import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 点名4 {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。

          运行结果要求：
            被点到的学生不会再被点到。
            但是如果班级中所有的学生都点完了， 需要重新开启第二轮点名。

          核心思想：
               点一个删一个，把删除的备份，全部点完时还原数据。

        */

        //1.定义变量，表示初始文件路径，文件中存储所有的学生信息
        String src = "names.txt";
        //2.定义变量，表示备份文件，一开始文件为空
        String backups = "backups.txt";
        //3.读取初始文件中的数据，并把学生信息添加到集合当中
        ArrayList<String> list = readFile(src);
        //4.判断集合中是否有数据
        if (list.size() == 0) {
            //5.如果没有数据，表示所有学生已经点完，从backups.txt中还原数据即可
            //还原数据需要以下步骤：
            //5.1 读取备份文件中所有的数据
            list = readFile(backups);
            //5.2 把所有的数据写到初始文件中
            writeFile(src, list, false);
            //5.3 删除备份文件
            new File(backups).delete();
        }
        //5.集合中有数据，表示还没有点完，点一个删一个，把删除的备份到backups.txt当中
        //打乱集合
        Collections.shuffle(list);
        //获取0索引的学生信息并删除
        String stuInfo = list.remove(0);
        //打印随机到的学生信息
        System.out.println("当前被点到的学生为：" + stuInfo);
        //把删除之后的所有学生信息，写到初始文件中
        writeFile(src, list, false);
        //把删除的学生信息备份（追加写入）
        writeFile(backups, stuInfo, true);


    }

    private static void writeFile(String pathFile, ArrayList<String> list, boolean isAppend) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile, isAppend));
        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();
    }

    private static void writeFile(String pathFile, String str, boolean isAppend) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile, isAppend));
        bw.write(str);
        bw.newLine();
        bw.close();
    }


    private static ArrayList<String> readFile(String pathFile) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(pathFile));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        return list;
    }
}
