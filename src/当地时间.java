import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;

public class 当地时间 {
    public static void main(String[] args) {
        LocalDate newtime=LocalDate.now();
        System.out.println(newtime);
        LocalDate time1=LocalDate.of(2023,11,25);
        System.out.println(time1);

        Month m1= time1.getMonth();
        System.out.println(m1);
        int m2=time1.getMonthValue();
        System.out.println(m2);

        int day1=newtime.getDayOfYear();
        System.out.println(day1);

        System.out.println("--------生日判断----------");
        LocalDate birthDay=LocalDate.of(2001,10,31);
        LocalDate nowDay=LocalDate.now();
        MonthDay birth=MonthDay.of(birthDay.getMonth(),birthDay.getDayOfMonth());
        MonthDay now=MonthDay.from(nowDay);
        MonthDay changeDay = now.with(Month.of(10)).withDayOfMonth(31);
        System.out.println(birth);
        System.out.println("今天是你的生日吗? "+((birth.equals(now))?"是":"不是") );
        System.out.println("今天是你的生日吗? "+((birth.equals(changeDay))?"是":"不是") );

        System.out.println("-------LocalTime--------");
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
    }
}
