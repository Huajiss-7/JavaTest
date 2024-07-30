import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class 增强for {
    public static void main(String[] args) {
        Collection<String>coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        for(String s:coll){
            System.out.println(s);
        }

        System.out.println("---------------------");

        coll.forEach(new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("---------------------");

        coll.forEach(s-> System.out.println(s));
    }
}
