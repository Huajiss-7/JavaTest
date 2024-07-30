import java.util.HashMap;

public class 哈希表例题 {
    public static void main(String[] args) {
        HashMap<Student,String>hm=new HashMap<>();
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",25);
        Student s4=new Student("王五",25);
        hm.put(s1,"河南");
        hm.put(s2,"河北");
        hm.put(s3,"山东");
        hm.put(s4,"云南");//student重写了equals，同姓名年龄被认为是一个人
        System.out.println(hm);
    }
}
