import java.util.Arrays;

public class lambda表达式  {
    public static void main(String[] args) {
        Integer[]arr={8,3,2,5,6,10,4,1,9,7};
        /*Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//匿名内部类*/

        Arrays.sort(arr,(Integer o1, Integer o2) -> {return o2-o1;});

        System.out.println(Arrays.toString(arr));

        System.out.println("-------------------");
        method(new Swim() {
            @Override
            public void swim() {
                System.out.println("接口对象，就是创建一个实现接口的类的对象");
            }
        });

        method(()->{
            System.out.println("lambda");
        });

        method(()->System.out.println("省略到极致"));
    }

    public static void method(Swim s){
        s.swim();
    }

}
interface Swim{
    public abstract void swim();
}