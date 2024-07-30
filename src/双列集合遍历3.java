import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class 双列集合遍历3 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("郭靖","黄蓉");
        map.put("喜羊羊","美羊羊");
        map.put("小明","小红");
        map.put("大熊","静香");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String string, String string2) {
                System.out.println(string+" "+string2);
            }
        });
        System.out.println("----------------");
        map.forEach((string, string2) -> System.out.println(string+" "+string2));
    }
}
