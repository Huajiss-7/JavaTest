public class math {
    public static void main(String[] args) {
        //System.out.println(Math.abs(-2123232423434234234));
        int j=0;
        double sum=0;
        double a=0;
        double ge=0;
        for (int i = 1; i <100000 ; i++) {
            sum=0;
            j=i;
            String s=""+i;
            while(j!=0){
                ge=j%10;
                a=Math.pow(ge,(double)s.length());
                /*a=ge;
                for (int k = 1; k <s.length() ; k++) {
                    a=a*ge;
                }*/
                sum=sum+a;
                j=j/10;
            }
            if(sum==i){
                System.out.print(i+" ");
            }
        }
    }
}
