import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class 初见Stream流 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("张三丰");
        list.add("赵敏");
        list.add("张强");
        ArrayList<String>list1=new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张")){
                list1.add(name);
            }
        }
        System.out.println(list1);

        //Stream流
        list.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(name-> System.out.println(name));

        //单列集合
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"abc","def","123");
        list2.stream().forEach(s -> System.out.println(s));

        System.out.println("----------------------");

        //双列集合
        HashMap<Integer,String>hm=new HashMap<>();
        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(3,"c");
        hm.keySet().stream().forEach(i-> System.out.println(i));

        System.out.println("-----------------------");

        hm.entrySet().stream().forEach(entries-> System.out.println(entries));
        System.out.println("-------------------------");
        hm.entrySet().forEach(entries-> System.out.println(entries));

        System.out.println("-------数组-------------");

        String[]arr={"a","b","c","d"};
        Arrays.stream(arr).forEach(e-> System.out.println(e));

        System.out.println("-------零散数据(要求同类型)-------------");
        Stream.of("a","b","c","d").forEach(s-> System.out.println(s));
    }
}
