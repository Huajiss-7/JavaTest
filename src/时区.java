import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class 时区 {
    public static void main(String[] args) {
        Set<String>zoneIds= ZoneId.getAvailableZoneIds();//获得所有时区
        System.out.println(zoneIds.size());
        System.out.println(zoneIds);

        ZoneId zoneId = ZoneId.systemDefault();//获得默认时区
        System.out.println(zoneId);

        ZoneId zoneId1 = ZoneId.of("America/Cuiaba");
        System.out.println(zoneId1);
        System.out.println("---------------------");

        //Instant类
        Instant now=Instant.now();
        System.out.println(now);//比中国时区少8小时，最后显示是纳秒

        Instant instant1 = Instant.ofEpochMilli(0);
        System.out.println(instant1);

        Instant instant2=Instant.ofEpochSecond(1L,1000000000);//前面秒，后面是纳秒
        System.out.println(instant2);

        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);

        Instant instant3=Instant.ofEpochMilli(0L);
        Instant instant4=Instant.ofEpochMilli(100000L);
        boolean b1=instant3.isBefore(instant4);
        boolean b2=instant3.isAfter(instant4);
        System.out.println(b1+" "+b2);

        Instant instant5=Instant.ofEpochMilli(1000000L);
        System.out.println(instant5);
        Instant instant6=instant5.minusSeconds(2000L);//时间对象不会变，每次改变都会产生新对象
        System.out.println(instant6);

        System.out.println("-----------------");
        //时区类
        ZonedDateTime z1=ZonedDateTime.now();
        System.out.println(z1);

        ZonedDateTime z2= ZonedDateTime.of(2001,10,31,5,15,
                10,10000,ZoneId.of("Asia/Shanghai"));
        System.out.println(z2);

        Instant instant7=Instant.now();
        ZoneId zoneId2=ZoneId.of("Asia/Shanghai");
        ZonedDateTime z3=ZonedDateTime.ofInstant(instant7,zoneId2);
        System.out.println(z3);

        ZonedDateTime z4=z3.withYear(2001);
        System.out.println(z4);

        ZonedDateTime z5=z4.minusYears(1);
        System.out.println(z5);

        ZonedDateTime z6=z5.plusMonths(1);
        System.out.println(z6);

        System.out.println("----------------------");
        ZonedDateTime time1=Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        System.out.println(dtf1.format(time1));
    }
}
