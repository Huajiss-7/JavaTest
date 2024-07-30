import java.util.Calendar;
import java.util.Date;

public class 日历类 {
    public static void main(String[] args) {
        Calendar c1=Calendar.getInstance();
        System.out.println(c1);

        Date d1=new Date(0L);
        c1.setTime(d1);
        System.out.println(c1);
        System.out.println("----------------");

        c1.set(Calendar.MONTH,12);//月份范围0-11，超出范围了年进一
        c1.add(Calendar.DAY_OF_WEEK,1);

        int year=c1.get(Calendar.YEAR);
        int month=c1.get(Calendar.MONTH)+1;//月份对应会默认少一个 实际1月显示的是0月
        int day=c1.get(Calendar.DAY_OF_MONTH);
        int week=c1.get(Calendar.DAY_OF_WEEK);
        System.out.println(year+"年"+month+"月"+day+"日"+" 星期"+week);
    }
}
