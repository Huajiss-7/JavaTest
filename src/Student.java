import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student> , Serializable {
    @Serial
    private static final long serialVersionUID = -3888304584003484586L;
    //private static final long serialVersionUID=1L;
    private String name;
    private int age;
    private transient String address=null;//transient 瞬态关键字 不会把这个属性序列化到本地文件当中

    @Override
    public int compareTo(Student o) {
        System.out.println("------------");//可视化比较过程
        System.out.println("this: "+this);
        System.out.println("o: "+o);
        //想要按照年龄升序排列
        int result = this.getAge() - o.getAge();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age,String address) {
        this.name = name;
        this.age = age;
        this.address=address;
    }

    public Student() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
