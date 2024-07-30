import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class 再见Stream流 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("张三丰");
        list.add("赵敏");
        list.add("张强");

        Stream<String> stream1 = list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        });
        //stream1.forEach(s -> System.out.println(s));
        System.out.println(list);
        System.out.println(stream1);

        Stream<String> stream2 = stream1.filter(s -> s.length() == 3);
        System.out.println(stream1);//stream流是一次性的，用完产生新流之后老流就关闭了
        //stream1.forEach(s -> System.out.println(s));
        stream2.forEach(s -> System.out.println(s));

        System.out.println("-------------------");

        list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("-----------");
        list.stream().skip(1).limit(3).forEach(s -> System.out.println(s));
        System.out.println("--------去重-------");
        list.add("张无忌");
        list.add("张无忌");
        list.add("张无忌");
        list.forEach(s -> System.out.println(s));
        System.out.println("---");
        list.stream().distinct().forEach(s -> System.out.println(s));//去重依赖于hashcode()和equals()如果自己的类，需要重写这两个方法

        System.out.println("------合并------");
        ArrayList<String>list1=new ArrayList<>();
        Collections.addAll(list1,"小张","小王","小李");
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"小刘","小赵","小红");

        Stream.concat(list1.stream(),list2.stream()).forEach(s -> System.out.println(s));

        System.out.println("--------数据类型转换------------");
        ArrayList<String>list3=new ArrayList<>();
        Collections.addAll(list3,"小张-18","红领巾-20","李明明明-30","阿-45");
        //只取出数字
        list3.stream().map(new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                String[] arr = s.split("-");//根据正则表达式进行切割，比如小张-15变成小张在0索引，15在1索引
                String age = arr[1];
                return Integer.parseInt(age);
            }
        }).forEach(s-> System.out.println(s));
        System.out.println("---");
        list3.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));
    }
}

