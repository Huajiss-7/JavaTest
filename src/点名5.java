import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 点名5 {
    public static void main(String[] args) throws IOException {
        //1.把文件中所有的学生信息读取到内存中
        ArrayList<StudentForRoll> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("namesForRoll.txt"));
        String line;
        while((line = br.readLine()) != null){
            String[] arr = line.split("-");
            StudentForRoll stu = new StudentForRoll(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3]));
            list.add(stu);
        }
        br.close();

        //2.计算权重的总和
        double weight = 0;
        for (StudentForRoll stu : list) {
            weight = weight + stu.getWeight();
        }

        //3.计算每一个人的实际占比
        //[0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1]
        double[] arr = new double[list.size()];
        int index = 0;
        for (StudentForRoll stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }

        //4.计算每一个人的权重占比范围
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        //5.随机抽取
        //获取一个0.0~1.0之间的随机数
        double number = Math.random();
        //判断number在arr中的位置
        //二分查找法
        //方法回返回： - 插入点 - 1
        //获取number这个数据在数组当中的插入点位置
        int result = -Arrays.binarySearch(arr, number) - 1;
        StudentForRoll stu = list.get(result);
        System.out.println(stu);

        //6.修改当前学生的权重
        double w = stu.getWeight() / 2;
        stu.setWeight(w);

        //7.把集合中的数据再次写到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\src\\com\\itheima\\myiotest6\\names.txt"));
        for (StudentForRoll s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();


    }
}
