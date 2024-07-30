import java.util.LinkedHashMap;

public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer>lhm=new LinkedHashMap<>();//存取有序

        lhm.put("a",4);
        lhm.put("a",1);
        lhm.put("c",3);
        lhm.put("b",2);

        System.out.println(lhm);
    }
}
