import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream流练习 {
    public static void main(String[] args) {
        practice1();
        practice2();
        practice3();
        Stream.of(1,2,3,4,5).forEach(s-> System.out.print(s+" "));
        System.out.println();
        int []arr={1,2,3,4,5};
        Stream.of(arr).forEach(s-> System.out.print(s+" "));
        Integer []arr1={1,2,3,4,5};
        System.out.println();
        Stream.of(arr1).forEach(s-> System.out.print(s+" "));
        System.out.println();
        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
    }

    public static void practice3() {
        ArrayList<String>list1=new ArrayList<>();
        Collections.addAll(list1,"王老吉,24","加多宝,23","哇哈哈,22","伍仟,24","股价,30");
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"美羊羊,35","花花,36","花圆圆,43","张太太,31","股价,30");

        Stream<String> stream1 = list1.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);
        Stream<String> stream2 = list2.stream().filter(s -> s.split(",")[0].startsWith("花")).skip(1);
        Stream.concat(stream1,stream2).map(new Function<String, Actor>() {
            @Override
            public Actor apply(String s) {
                Actor actor=new Actor(s.split(",")[0],Integer.parseInt(s.split(",")[1]));
                return actor;
            }
        }).forEach(s-> System.out.println(s));
    }

    public static void practice1() {
        ArrayList<Integer>list1=new ArrayList<>();
        Collections.addAll(list1,1,2,3,4,5,6,7,8,9,10);
        List<Integer> collect = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void practice2(){
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"张三,23","李四四,24","王五五五,25");
        Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0]
                        , s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(collect);
    }
}

class Actor{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
