import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream流的终结方法 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("张无忌-男-15");
        list.add("周芷若-女-14");
        list.add("张三丰-男-100");
        list.add("赵敏-女-20");
        list.add("张强-男-20");

        //遍历
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //统计
        long count = list.stream().count();
        System.out.println(count);

        //收集到数组
        Object[] arr1 = list.stream().toArray();
        System.out.println(Arrays.toString(arr1));

        String[] arr = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr));

        //收集到集合
        //收集男性
        //list.add("张强-男-20");
        list.stream().filter(s->"男".equals(s.split("-")[1])).forEach(s -> System.out.println(s));
        List<String> collect = list.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("------------");

        Set<String> collect1 = list.stream().filter(s -> "20".equals(s.split("-")[2])).collect(Collectors.toSet());
        System.out.println(collect1);//set可去重

        System.out.println("------------");
        //收集到map集合
        Map<String, Integer> collect2 = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(new Function<String, String>() {//键的规则
                                              @Override
                                              public String apply(String s) {
                                                  return s.split("-")[0];
                                              }
                                          },
                        new Function<String, Integer>() {//值的规则

                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }));
        System.out.println(collect2);

        System.out.println("-----------------");

        Map<String, Integer> collect3 = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap( s-> s.split("-")[0],
                        s-> Integer.parseInt(s.split("-")[2])));
        System.out.println(collect3);

    }
}
