package 网络编程;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        String string=UUID.randomUUID().toString();
        System.out.println(string);
        String str = UUID.randomUUID().toString().replace("-", "");
        System.out.println(str);//9f15b8c356c54f55bfcb0ee3023fce8a
    }
}