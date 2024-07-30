import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class 迭代器 {
    public static void main(String[] args) {
        Collection<String>coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");

        Iterator<String>it=coll.iterator();
        while (it.hasNext()){
            String str=it.next();
            System.out.println(str);
        }

        //it.next();//指出范围后，报错没有这个元素
        System.out.println(it.hasNext());//指针不复位
}
}
