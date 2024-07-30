import java.util.Arrays;
import java.util.Comparator;

public class 方法引用 {
    public static void main(String[] args) {
        Integer[]arr={3,5,4,1,6,2};
        //method1(arr);

        Arrays.sort(arr,方法引用::subtraction);

        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }

    public static int subtraction(int num1,int num2){
        return num2-num1;
    }

    private static void method1(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }
}
