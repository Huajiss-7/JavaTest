public class 爬台阶问题 {
    //一次只能上一阶或者两阶，求到20阶有几种爬法
    public static void main(String[] args) {
        int sum=getCount(20);
        System.out.println(sum);
        int sum2=getCount2(20);//如果还可以爬三阶
        System.out.println(sum2);
    }

    public static int getCount(int step){
        if(step==1)return 1;
        if(step==2)return 2;
        return getCount(step-1)+getCount(step-2);//相当于爬到第18阶爬两步到20阶和爬到19阶了爬一步到20阶，假设爬到18阶有x种方法，爬到19阶有y种方法，所以爬20阶就这两种相加1*x+1*y
    }

    public static int getCount2(int step){
        if(step==1)return 1;
        if(step==2)return 2;
        if(step==3)return 4;
        return getCount(step-1)+getCount(step-2)+getCount(step-3);
    }
}
