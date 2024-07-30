import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 方法引用练习 {
    public static void main(String[] args) {
        //把字符串收集到学生类型的数组
        ArrayList<String> list1=new ArrayList<>();
        list1.add("张无忌,15");
        list1.add("周芷若,14");
        list1.add("张三丰,100");
        list1.add("赵敏,20");
        list1.add("张强,20");
        XueSheng1[] arr1 = list1.stream().map(XueSheng1::new).toArray(XueSheng1[]::new);
        System.out.println(Arrays.toString(arr1));

        System.out.println("-----------------");
        //创建学生对象，把姓名放入数组
        XueSheng1 xs1=new XueSheng1("小张",15);
        XueSheng1 xs2=new XueSheng1("小王",18);
        XueSheng1 xs3=new XueSheng1("小李",20);
        ArrayList<XueSheng1>list2=new ArrayList<>();
        Collections.addAll(list2,xs1,xs2,xs3);
        String[] arr2 = list2.stream().map(XueSheng1::getName).toArray(String[]::new);
        for (String s : arr2) {
            System.out.println(s);
        }

        System.out.println("----------------");

    }
}

class XueSheng1{
    private String name;
    private  int age;

    public XueSheng1(String name){
        this.name=name.split(",")[0];
        this.age=Integer.parseInt(name.split(",")[1]);
    }

    public XueSheng1(String name, int age) {
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

    public XueSheng1() {
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