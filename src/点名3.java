import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 点名3 {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。
            第三次必定是张三同学

          运行效果：
            第一次运行程序：随机同学姓名1
            第二次运行程序：随机同学姓名2
            第三次运行程序：张三
            …
        */

        //1.读取数据，并把学生信息添加到集合当中
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br1 = new BufferedReader(new FileReader("names.txt"));
        String line;
        while ((line = br1.readLine()) != null){
            list.add(line);
        }
        br1.close();
        //2.读取当前程序已经运行的次数
        BufferedReader br2 = new BufferedReader(new FileReader("count.txt"));
        String countStr = br2.readLine();
        int count = Integer.parseInt(countStr);
        br2.close();
        //4.表示程序再次运行了一次
        count++;
        //3.判断，如果当前已经是第三次，直接打印，不是第三次才随机
        if(count == 3){
            System.out.println("张三");
        }else {
            Collections.shuffle(list);
            String stuInfo = list.get(0);
            System.out.println(stuInfo);
        }

        //4.将程序已经运行的次数写会本地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
        bw.write(count + "");
        bw.close();



    }
}
