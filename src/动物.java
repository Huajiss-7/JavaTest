public class 动物 <E,T>{
    private String name;
    private int age;

    private E ha;

    private T hah;//当类中有不确定数据类型，也可以使用泛型

    public void eat(){
        System.out.println(age+"岁的"+name+"正在吃东西");
    }

    public 动物(){

    }

    public 动物(String name,int age){
        this.age=age;
        this.name=name;
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
