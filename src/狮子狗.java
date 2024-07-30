public class 狮子狗 extends 狗{
    public 狮子狗() {
    }
    public  狮子狗(String name,int age){
        super.setAge(age);
        super.setName(name);
    }

    public void eat(){
        System.out.println("一只"+this.getAge()+"岁的叫"+this.getName()+"的狮子狗正在吃东西");
    }
}
