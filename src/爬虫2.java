import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 爬虫2 {
    public static void main(String[] args) {
        String s="Java11 gdgdjmkmkbgbm jaVa6 gsrgdfffg gtgee jAvA3 lpppeprjjf JaVa";
        String regex1="((?i)java)(?=11|6|3)";//后面有这些才爬取，但是只爬取前面的
        String regex2="((?i)java)(?:11|6|3)";//后面有这些一起爬取了
        String regex3="((?i)java)(11|6|3)";//和上面一样效果
        String regex4="((?i)java)(?!11|6|3)";//爬取只有前面，没有后面的
        Pattern p1=Pattern.compile(regex1);
        Pattern p2=Pattern.compile(regex2);
        Pattern p3=Pattern.compile(regex3);
        Pattern p4=Pattern.compile(regex4);
        Matcher m1=p1.matcher(s);
        while (m1.find()){
            String s1=m1.group();
            System.out.println(s1);
        }
        System.out.println("--------------------");
        Matcher m2=p2.matcher(s);
        while (m2.find()){
            String s1=m2.group();
            System.out.println(s1);
        }
        System.out.println("--------------------");
        Matcher m3=p3.matcher(s);
        while (m3.find()){
            String s1=m3.group();
            System.out.println(s1);
        }
        System.out.println("--------------------");
        Matcher m4=p4.matcher(s);
        while (m4.find()){
            String s1=m4.group();
            System.out.println(s1);
        }

        String s2="abbbbbbbbbb";
        String regex5="ab+";//贪婪爬取
        Pattern p5=Pattern.compile(regex5);
        Matcher m5=p5.matcher(s2);
        while(m5.find()){
            String s1=m5.group();
            System.out.println(s1);
        }
        System.out.println("--------------");
        String regex6="ab+?";//非贪婪爬取
        Pattern p6=Pattern.compile(regex6);
        Matcher m6=p6.matcher(s2);
        while(m6.find()){
            String s1=m6.group();
            System.out.println(s1);
        }
        System.out.println("--------------");
        String s3="小明horgonjvnvjper小王fuorvne小红";
        String s4=s3.replaceAll("[\\w&&[^_]]+","vs");
        System.out.println(s4);
        String[]s5=s3.split("[\\w&&[^_]]+");
        for (int i = 0; i < s5.length; i++) {
            System.out.println(s5[i]);

            System.out.println("---------------");
            String regex7="(.+).+\\1";
            System.out.println("abc1234abc".matches(regex7));
            //左括号为分组标志，谁的左括号先出现谁在前
            //这是判断开头有一样的字符，结尾也有一样的  aaa123aaa
            String regex8="((.+)\\2*).+\\1";
            System.out.println("aaa123aaa".matches(regex8));//true
            System.out.println("aba".matches(regex8));//true
            System.out.println("abcab".matches(regex8));//true
            System.out.println("----------------");
            String s6="我要学学学学学学学编编编程程程程";
            String s7=s6.replaceAll("(.)\\1+","$1");
            System.out.println(s7);//我要学编程
        }
    }
}
