import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class 时区工具 {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        System.out.println(today);

        LocalDate birthday=LocalDate.of(2001,10,31);
        System.out.println(birthday);

        Period period=Period.between(birthday,today);
        System.out.println("相差的时间为："+period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println(period.toTotalMonths());

        System.out.println("-----------duration------------");
        LocalDateTime today1=LocalDateTime.now();
        LocalDateTime birthday1=LocalDateTime.of(2001,10,31,0,00,000);
        Duration duration=Duration.between(birthday1,today1);
        System.out.println(duration);

        System.out.println(duration.toDays());

        System.out.println("--------chronounit----------");
        long between1 = ChronoUnit.YEARS.between(birthday1, today1);
        System.out.println(between1);

        System.out.println("---------活了多少天---------");
        LocalDate time1=LocalDate.now();
        LocalDate time2=LocalDate.of(2001,10,31);
        long between = ChronoUnit.DAYS.between(time2, time1);
        System.out.println("我活了"+between+"天");
    }
}
