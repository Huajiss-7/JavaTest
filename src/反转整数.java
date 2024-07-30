public class 反转整数 {
    public static void main(String[] args) {
        int result=reverse(-123);
        System.out.println(result);
        int n=365;
        int sum=n%10;
        System.out.println(sum);
        System.out.println(n);
    }

    public static int reverse(int x){
        String s=""+x;
        int flag=0;
        if (s.charAt(0)=='-')flag=1;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='-'){
                sb.append(s.charAt(i));
            }
        }
        String str=sb.reverse().toString();
        if(str.length()>=9)return 0;
        double f=Integer.parseUnsignedInt(str);
        if(flag==1)f=f*-1;
        return (int)f;
    }
}
