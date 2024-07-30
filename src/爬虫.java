import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 爬虫 {
    public static void main(String[] args) {
        String str="Javafsdf,eirwfj,Java11,ifjiefji,Java7,fjiewjfi,Java17";
        String regex="Java\\d{0,2}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        while(matcher.find()){
            method1(matcher);
        }
    }

    private static void method1(Matcher matcher) {
        //matcher.find();//必须先find才能group,在while中已经使用，函数中再次使用会使用两次
        String s1= matcher.group();
        System.out.println(s1);
    }
}
