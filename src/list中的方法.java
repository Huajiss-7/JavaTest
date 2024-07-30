import java.util.ArrayList;
import java.util.List;

public class list中的方法 {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list);

        list.add(1,"111");
        System.out.println(list);

        String remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list);

        list.remove("ccc");
        System.out.println(list.remove("aaa"));
        System.out.println(list);

        list.set(1,"222");
        System.out.println(list);

        String s = list.get(2);
        System.out.println(s);
    }
}
