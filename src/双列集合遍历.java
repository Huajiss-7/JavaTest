import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 双列集合遍历 {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<>();
        map.put("郭靖","黄蓉");
        map.put("美羊羊","喜羊羊");
        map.put("小明","小红");
        map.put("大熊","静香");
        //通过键找值
        Set<String> keys = map.keySet();
        for (String key : keys) {
            //System.out.println(key);
            String value = map.get(key);
            //System.out.println(value);
            System.out.println(key+" "+value);
        }

        System.out.println("--------------------");

        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            String value = map.get(key);
            System.out.println(key+" "+value);
        }

        System.out.println("--------------------");

        keys.forEach(string-> System.out.println(string+" "+map.get(string)));
    }
}
