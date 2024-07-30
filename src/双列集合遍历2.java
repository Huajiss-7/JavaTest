import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 双列集合遍历2 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("郭靖","黄蓉");
        map.put("喜羊羊","美羊羊");
        map.put("小明","小红");
        map.put("大熊","静香");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> set : entries) {
            String key=set.getKey();
            String value = set.getValue();
            System.out.println(key+" "+value);
        }

    }
}
