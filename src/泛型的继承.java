import java.util.ArrayList;

public class 泛型的继承 {
    public static void main(String[] args) {
        ArrayList<Ye>list1=new ArrayList<>();
        ArrayList<Fu>list2=new ArrayList<>();
        ArrayList<Zi>list3=new ArrayList<>();
        method(list1);
        //method(list2);//泛型无法继承
        //method(list3);

        method2(list2);
        method3(list1);
    }

    public static void method(ArrayList<Ye>list){

    }

    public static void method2(ArrayList<?extends Ye>list){
        //可以传递所有父类的子类对象
    }

    public static void method3(ArrayList<?super Zi>list){
        //可以传递所有子类的父类对象
    }

}

class Ye{//一个文件只能有一个public的类

}

class Fu extends Ye{

}

class Zi extends Fu{

}


