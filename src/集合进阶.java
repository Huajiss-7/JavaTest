import java.util.ArrayList;
import java.util.Collection;

public class 集合进阶 {
    public static void main(String[] args) {
        Collection<String>coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll);

        coll.remove("aaa");
        System.out.println(coll);

        coll.clear();
        System.out.println(coll);
    }
}
