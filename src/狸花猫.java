public class 狸花猫 extends 猫{
    public 狸花猫() {
    }
    public  狸花猫(String name,int age){
        super.setAge(age);
        super.setName(name);
    }

    public void eat(){
        System.out.println("一只"+this.getAge()+"岁的叫"+this.getName()+"的狸花猫正在吃东西");
    }
}
