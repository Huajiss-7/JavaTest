import java.util.HashMap;
import java.util.Map;

public class 双列集合 {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<>();
        map.put("郭靖","黄蓉");
        map.put("美羊羊","喜羊羊");
        String s1=map.put("美羊羊","沸羊羊");//覆盖,返回覆盖值
        String s2=map.put("大熊","静香");
        System.out.println(map);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("---------------");

        String s3=map.remove("美羊羊");
        System.out.println(s3);
        System.out.println(map);

        System.out.println("-----------------");

        boolean b1=map.containsKey("大熊");
        System.out.println(b1);
        boolean b2=map.containsValue("静香");
        System.out.println(b2);

        System.out.println("------------------");

        int size=map.size();
        System.out.println(size);
        System.out.println(map);

        System.out.println("------------------");

        map.clear();
        System.out.println(map);
    }
}
