import java.util.TreeMap;

public class 树地图排序 {
    public static void main(String[] args) {
        Stu s1=new Stu(20,"zhangsan");
        Stu s2=new Stu(29,"lisi");
        Stu s3=new Stu(20,"wangwu");
        TreeMap<Stu,String>tm=new TreeMap<>();
        tm.put(s1,"河南");
        tm.put(s2,"河北");
        tm.put(s3,"山东");
        System.out.println(tm);
    }
}

class Stu implements Comparable<Stu>{
    int age;
    String name;

    @Override
    public int compareTo(Stu o) {
        int i=o.age-this.age;//先按照年龄排序，年龄一样按照姓名首字母排序，都一样视为同一人
        i=i==0?o.name.compareTo(this.name):i;
        return i;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stu() {
    }

    public Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
