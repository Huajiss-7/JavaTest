public class 位运算 {
    public static void main(String[] args) {
        Integer a = 10; // 二进制表示: 1010
        Integer b = 5;  // 二进制表示: 0101

        // 原始值
        System.out.println("Original number a: " + a);
        System.out.println("Binary representation of a: " + Integer.toBinaryString(a));
        System.out.println("Original number b: " + b);
        System.out.println("Binary representation of b: " + Integer.toBinaryString(b));
        System.out.println("---------------");

        // 按位与（&）
        Integer andResult = a & b;
        System.out.println("Result of a & b: " + andResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(andResult));
        System.out.println("---------------");

        // 按位或（|）
        Integer orResult = a | b;
        System.out.println("Result of a | b: " + orResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(orResult));
        System.out.println("---------------");

        // 按位非（~）
        Integer notResult = ~a;
        System.out.println("Result of ~a: " + notResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(notResult));
        System.out.println("---------------");

        // 按位异或（^）
        Integer xorResult = a ^ b;
        System.out.println("Result of a ^ b: " + xorResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(xorResult));
        System.out.println("---------------");

        // 左移操作（<<）
        Integer leftShiftResult = a << 1;
        System.out.println("Result of a << 1: " + leftShiftResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(leftShiftResult));
        System.out.println("---------------");

        // 右移操作（>>）
        Integer rightShiftResult = a >> 2;
        System.out.println("Result of a >> 2: " + rightShiftResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(rightShiftResult));
        System.out.println("---------------");

        // 无符号右移操作（>>>）
        Integer unsignedRightShiftResult = -1 >>> 1;//无符号高位补0
        System.out.println("Result of -1 >>> 1: " + unsignedRightShiftResult);
        System.out.println("Binary representation: " + Integer.toBinaryString(unsignedRightShiftResult));
        System.out.println("---------------");
        Integer unsignedRightShiftResult2 = -1 >> 1;//有符号右移，高位补对应的符号位
        System.out.println("Result of -1 >> 1: " + unsignedRightShiftResult2);
        System.out.println("Binary representation: " + Integer.toBinaryString(unsignedRightShiftResult2));
        System.out.println("---------------");
    }
}
