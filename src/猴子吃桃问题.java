public class 猴子吃桃问题 {
    public static int sum=0;
    public static void main(String[] args) {
        eatPeach(10);
        System.out.println(sum);
        int sum2=getCount(1);
        System.out.println(sum2);
    }

    public static int eatPeach(int day){
        if(day==1)return 1;
        sum=sum+(eatPeach(day-1)+1)*2;
        return sum;
    }

    //方法2
    public static int getCount(int day){
        if(day==10)return 1;
        return (getCount(day+1)+1)*2;
    }
}


