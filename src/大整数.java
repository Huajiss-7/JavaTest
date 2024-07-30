import java.math.BigInteger;

public class 大整数 {
    public static void main(String[] args) {
        BigInteger bi1=BigInteger.valueOf(10);
        BigInteger bi2=BigInteger.valueOf(10);
        bi1.add(bi2);
        System.out.println(bi1);//10
        System.out.println(bi2.add(bi1));

        BigInteger[]arr=bi1.divideAndRemainder(bi2);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        System.out.println(bi1.equals(bi2));

        BigInteger bi3=bi1.pow(2);
        System.out.println(bi3);

        BigInteger bi4=bi1.max(bi2);
        System.out.println(bi4);
        System.out.println(bi4==bi1);
        System.out.println(bi4==bi2);
    }
}
