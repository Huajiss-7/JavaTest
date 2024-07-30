import java.io.*;

public class 序列化流1  {
   /* public static void main(String[] args) throws IOException {
        Student stu=new Student("zhangsan",23);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\duixiang.txt"));
        oos.writeObject(stu);
        oos.close();
    }*/

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
           需求：
                利用序列化流/对象操作输出流，把一个对象写到本地文件中

           构造方法：
                public ObjectOutputStream(OutputStream out)         把基本流变成高级流

           成员方法：
                public final void writeObject(Object obj)           把对象序列化（写出）到文件中去

        */


        //1.创建对象
        Student stu = new Student("zhangsan",23);

        //2.创建序列化流的对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\duixiang.txt"));

        //3.写出数据
        oos.writeObject(stu);

        //4.释放资源
        oos.close();


        //反序列化流
        /*
           需求：
                利用反序列化流/对象操作输入流，把文件中中的对象读到程序当中
           构造方法：
                public ObjectInputStream(InputStream out)         把基本流变成高级流
           成员方法：
                public Object readObject()                        把序列化到本地文件中的对象，读取到程序中来
        */



        //1.创建反序列化流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\duixiang.txt"));

        //2.读取数据
        Student o = (Student) ois.readObject();

        //3.打印对象
        System.out.println(o);

        //4.释放资源
        ois.close();//Student{name = zhangsan, age = 23, address = null}




    }
}
