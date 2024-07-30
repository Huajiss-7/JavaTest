import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间范围判断 {
    public static void main(String[] args) throws ParseException {
        String s1="2023年11月11日 0:01:00";
        String s2="2023年11月11日 0:11:0";
        String startTime="2023年11月11日 0:00:0";
        String endTime="2023年11月11日 0:10:0";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d1 = sdf.parse(s1);
        Date d2=sdf.parse(s2);
        long l1=d1.getTime();
        long l2=d2.getTime();
        boolean b1=judge(sdf, startTime, endTime,l1);
        boolean b2=judge(sdf,startTime,endTime,l2);
        System.out.println(b1);
        System.out.println(b2);
    }

    private static boolean judge(SimpleDateFormat sdf, String startTime, String endTime,long l) throws ParseException {
        long range1= sdf.parse(startTime).getTime();
        long range2= sdf.parse(endTime).getTime();
        if(l>=range1&&l<=range2)return true;
        else return false;
    }
}
