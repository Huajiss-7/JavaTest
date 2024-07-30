import java.util.ArrayList;

public class 泛型 {
    public static void main(String[] args) {
        ArrayList al=new ArrayList();//不写泛型什么都能添加，但是全部作为Object类对待，无法使用子类特有的方法
        al.add(123);
        al.add("asd");
        al.add('c');
        System.out.println(al);

        ArrayList<String>al2=new ArrayList<>();
        al2.add("加了泛型，确定添加类型");
    }
}
