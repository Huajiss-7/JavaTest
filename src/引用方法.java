import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class 引用方法 {
    public static void main(String[] args) {
        String[]arr={"1","2","3","4","5"};
        List<Integer> collect = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
        int sum=0;
        for (Integer i : collect) {
            sum+=i;
        }
        System.out.println(sum);

        System.out.println("------------------");

        ArrayList<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("张三丰");
        list.add("赵敏");
        list.add("张强");

        list.stream().filter(new 测试()::test).forEach(s-> System.out.println(s));

        System.out.println("---------------");
        ArrayList<String> list1=new ArrayList<>();
        list1.add("张无忌,15");
        list1.add("周芷若,14");
        list1.add("张三丰,100");
        list1.add("赵敏,20");
        list1.add("张强,20");

        list1.stream().map(XueSheng::new).forEach(s-> System.out.println(s));

        System.out.println("--------类名引用成员方法------------");
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"aaa","bbb","ccc","ddd");
        list2.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));

        System.out.println("--------数组构造方法引用------");
        ArrayList<Integer>list3=new ArrayList<>();
        Collections.addAll(list3,1,2,3,4,5);
        list3.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];

            }
        });

        Integer[] arr1 = list3.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr1));
    }


}

class 测试{
    public  boolean test(String s) {
        return s.startsWith("张")&&s.length()==3;
    }
}

class XueSheng{
    private String name;
    private  int age;

    public XueSheng(String name){
        this.name=name.split(",")[0];
        this.age=Integer.parseInt(name.split(",")[1]);
    }

    public XueSheng(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "XueSheng{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public XueSheng() {
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
