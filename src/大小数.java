import java.math.BigDecimal;
import java.math.RoundingMode;

public class 大小数 {
    public static void main(String[] args) {
        double a=0.01;
        double b=0.09;
        System.out.println(a+b);

        BigDecimal bd1=new BigDecimal("0.01");
        BigDecimal bd2=new BigDecimal("0.09");
        System.out.println(bd1.add(bd2));

        BigDecimal bd3=new BigDecimal("1");
        BigDecimal bd4=new BigDecimal("3");
        //BigDecimal bd5=bd3.divide(bd4);
        BigDecimal bd5=bd3.divide(bd4,10, RoundingMode.HALF_UP);
        System.out.println(bd5);
    }
}
