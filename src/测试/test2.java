package 测试;

public class test2 {
    public static void main(String[] args) {
        Base1 son1=new Son1();
        son1.sayHello();
    }
}

class Base1{
    public void sayHello(){
        System.out.println("父亲的hello");
    }
}

class Son1 extends Base1{
    public void sayHello(){
        System.out.println("儿子的hello");
    }
}
