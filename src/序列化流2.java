import java.io.*;
import java.util.ArrayList;

public class 序列化流2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*需求：
            将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
        */


        //1.序列化多个对象
        Student s1 = new Student("zhangsan",23,"南京");
        Student s2 = new Student("lisi",24,"重庆");
        Student s3 = new Student("wangwu",25,"北京");


        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\duixiang.txt"));
        oos.writeObject(list);


        oos.close();

        //读取对象

        //1.创建反序列化流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\duixiang.txt"));

        //2.读取数据
        ArrayList<Student> list1 = (ArrayList<Student>) ois.readObject();

        for (Student student : list1) {
            System.out.println(student);
        }


        //3.释放资源
        ois.close();

    }
}
