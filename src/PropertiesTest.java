import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        /*

              Properties跟IO流结合的操作

        */

        //1.创建集合
        Properties prop = new Properties();

        //2.添加数据
        prop.put("aaa","bbb");
        prop.put("bbb","ccc");
        prop.put("ddd","eee");
        prop.put("fff","iii");

        //3.把集合中的数据以键值对的形式写到本地文件当中
        FileOutputStream fos = new FileOutputStream("fileTest\\a.properties");
        prop.store(fos,"test");
        fos.close();


        /*BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\a.properties"));
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            bw.write(key + "=" + value);
            bw.newLine();
        }
        bw.close();*/


        //读取
        //1.创建集合
        Properties prop1 = new Properties();
        //2.读取本地Properties文件里面的数据
        FileInputStream fis = new FileInputStream("fileTest\\a.properties");
        prop1.load(fis);
        fis.close();

        //3.打印集合
        System.out.println(prop1);



    }
}
