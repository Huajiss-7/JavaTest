public class 包装类 {
    public static void main(String[] args) {
        Integer i1=new Integer(1);
        Integer i2=Integer.valueOf(1);
        int i3=i1.intValue()+i2.intValue();
        System.out.println(i3);

        Integer i4=10;
        int i5=i4;
        System.out.println(i5);

        String i6=Integer.toBinaryString(100);
        System.out.println(i6);//默认自动装箱 拆箱
    }
}
