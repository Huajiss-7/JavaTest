import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class 树地图统计 {
    public static void main(String[] args) {
        String s="asoidadjdsoadoajdokfccsd";
        TreeMap<Character,Integer>tm=new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(tm.containsKey(c)){
                int count=tm.get(c);
                tm.put(c,++count);
            }else{
                tm.put(c,1);
            }
        }

        System.out.println(tm);

        StringBuilder sb=new StringBuilder();
        tm.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character key, Integer value) {
                sb.append(key).append("(").append(value).append(") ");
            }
        });
        System.out.println(sb);

        StringJoiner sj=new StringJoiner("","","");
        tm.forEach((Character key, Integer value)-> sj.add(key+"").add("(").add(value+"").add(") "));
        System.out.println(sj);
    }
}
