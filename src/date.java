import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class date {
    public static void main(String[] args) throws ParseException {
        Date d1=new Date();//当前时间
        System.out.println(d1);

        Date d2=new Date(0L);//从时间原点开始，过了0毫秒的时间
        System.out.println(d2);

        Date d3=new Date(1000L);//从时间原点开始，过了1000毫秒的时间
        System.out.println(d3);

        long time=d3.getTime();
        System.out.println(time);

        long time1=d2.getTime();
        time1=time1+1000L*60*60*24*365;
        Date d4=new Date(time1);
        System.out.println(d4);

        Random r=new Random();
        Date d5=new Date(r.nextLong());
        Date d6=new Date(r.nextLong());
        System.out.println(d5);
        System.out.println(d6);
        long l1=d5.getTime();
        long l2=d5.getTime();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println("--------------------");

        SimpleDateFormat sdf=new SimpleDateFormat();
        Date d7=new Date(0);
        String s=sdf.format(d7);
        System.out.println(s);

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        Date d8=new Date();
        String s1=sdf1.format(d8);
        System.out.println(s1);
        System.out.println("--------------");

        String s2="2000-11-11";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Date d10=sdf3.parse(s2);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String s3=sdf2.format(d10);
        System.out.println(s3);

    }
}
