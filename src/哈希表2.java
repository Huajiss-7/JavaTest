import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class 哈希表2 {
    public static void main(String[] args) {
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",25);
        Student s4=new Student("张三",23);
        Student s5=new Student("赵六",26);

        HashSet<Student>hs=new HashSet<>();

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        System.out.println(hs.add(s4));

        LinkedHashSet<Student>lhs=new LinkedHashSet<>();//存取顺序一致
        lhs.add(s1);
        lhs.add(s2);
        lhs.add(s3);
        System.out.println(lhs);

        TreeSet<Integer>ts=new TreeSet<>();//可给数据排序，默认从小到大
        ts.add(3);
        ts.add(2);
        ts.add(5);
        ts.add(1);
        ts.add(4);
        System.out.println(ts);

        TreeSet<Student>ts1=new TreeSet<>();
        ts1.add(s3);
        ts1.add(s1);
        ts1.add(s2);
        ts1.add(s5);
        System.out.println(ts1);

        TreeSet<String>ts2=new TreeSet<>(new Comparator<String>() {//只有函数式接口才能改成lambda
            @Override
            public int compare(String o1, String o2) {
                //o1代表当前元素，o2表示红黑中已有的元素
                int i = o1.length() - o2.length();
                i=i==0?o1.compareTo(o2):i;
                return i;
            }
        });
    }
}
