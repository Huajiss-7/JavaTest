public class RegexDemo1 {
    public static void main(String[] args) {
        //0不能开头，6-20位，全部为数字
        String qq="1306356122";
        boolean b=qq.matches("[1-9]\\d{5,19}");
        System.out.println(b);
        System.out.println("判断范围");
        System.out.println("a".matches("[abc]"));
        System.out.println("ab".matches("[abc]"));//false 大括号只能匹配单字符
        System.out.println("ab".matches("[abc][abc]"));
        System.out.println("取反");
        System.out.println("a".matches("[^abc]"));
        System.out.println("d".matches("[^abc]"));
        System.out.println("多字符");
        System.out.println("abc123".matches("\\w{6,}"));
        System.out.println("ab_1".matches("[\\w&&[^_]]{4}"));

        System.out.println("座机号码");
        String regex1="0\\d{2,3}-?[\\d&&[^0]]\\d{4,9}";
        System.out.println("010-6685829".matches(regex1));

        String tool="([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";//24小时制时间 23:59:00
    }
}
