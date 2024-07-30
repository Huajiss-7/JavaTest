public class object {
    public static void main(String[] args) {
        Object obj=new Object();
        String s=obj.toString();
        System.out.println(s);

        String s1="abc";
        StringBuilder sb=new StringBuilder("abc");
        System.out.println(s1.equals(sb));
        System.out.println(sb.equals(s1));
    }
}
