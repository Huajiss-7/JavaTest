import java.util.Calendar;

public class 闰年判断 {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        //System.out.println(calendar);
        calendar.set(2000,2,1);//三月1日
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

        Calendar calendar1=Calendar.getInstance();
        calendar1.set(2001,0,1);
        calendar1.add(Calendar.DAY_OF_YEAR,-1);
        int i1 = calendar1.get(Calendar.DAY_OF_YEAR);
        System.out.println(i1);
    }
}
