package leetcode;

public class 反转字符串 {
    public static void main(String[] args) {
        char[]s={'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c+" ");
        }
    }

    public static void reverseString(char[] s) {
        int first=0;
        int last=s.length-1;
        while (first<last){
            char temp=s[first];
            s[first]=s[last];
            s[last]=temp;
            first++;
            last--;
        }
    }
}
