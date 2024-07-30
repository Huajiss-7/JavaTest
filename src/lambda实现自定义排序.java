import java.util.Arrays;

public class lambda实现自定义排序 {
    public static void main(String[] args) {
        String[]strs={"z","af","gfh","ervm","nblll"};
        /*Arrays.sort(strs);
        System.out.println(Arrays.toString(strs))//默认按照首字母ASCII码顺序排序;*/

        /*Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        })*///完全体

        Arrays.sort(strs, (String o1, String o2) -> o1.length()-o2.length());//按照长度从小到大
        System.out.println(Arrays.toString(strs));
    }
}
