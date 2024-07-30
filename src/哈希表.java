public class 哈希表 {
    public static void main(String[] args) {
        Student s1=new Student("张三",18);
        Student s2=new Student("张三",18);
        int h1 = s1.hashCode();
        int h2=s2.hashCode();
        System.out.println(h1);
        System.out.println(h2);
        System.out.println("--------------");
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}
