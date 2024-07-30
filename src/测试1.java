public class 测试1 {
    public static void main (String[] args){
    //--------------------------------------
        int x1 = 0;

        int y1 = 0;

        switch (x1 + 1)  {//没加break

            case 0: y1 = 0;

            case 1: y1 = 1;

            default: y1 = -1;

        }
        System.out.println(y1);

//---------------------------------------
        int[] x = new int[5];

        int i;

        for (i = 0; i < x.length-1; i++)

            x[i] = i;

        System.out.println(x[i]);
//---------------------------------------------

        System.out.println(Math.sqrt(36));
        double a=10.5;
        int b=8;
        double d=calc((int)a,b);
        b=(int)d;
        System.out.println(b +"\t"+ a);
    }
    public static double calc(int x, int y){
        ++x;
        y=x*y;
        System.out.println(x +"\t"+ y);
        return y;
    }

    /*public static void main(String[] args) {
        System.out.println(printNumber((double)88));
    }
    public static int printNumber(long n) {
        System.out.println("long");
        return n;
    }
    public static long printNumber(int n) {
        System.out.println("int");
        return n;
    }*/

}
