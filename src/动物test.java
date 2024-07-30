public class 动物test {
    public static void main(String[] args) {
        猫 mao=new 狸花猫("小明",20);
        动物 gou=new 狮子狗("小红",18);
        gou.eat();
        mao.eat();

        method(mao);
        //method(gou);报错

    }

    public static <T extends 猫>void method(T a){
        System.out.println("只有猫能调用");
    }
}
