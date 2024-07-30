import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class set集合 {
    public static void main(String[] args) {
        Set<String>s=new HashSet<>();
        boolean r1 = s.add("aaa");
        boolean r2=s.add("aaa");//set集合不能重复，添加失败返回false
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(s);
        s.add("bbb");
        s.add("ccc");
        System.out.println(s);//存取无序
        //s.get()不存在，无索引

        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }//迭代器遍历

        System.out.println("--------a---------");

        for (String str : s) {
            System.out.println(str);
        }//增强for

        System.out.println("--------b---------");

        s.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("--------c----------");

        s.forEach (string-> System.out.println(string) );
    }
}
