public class 丑数 {
    //自己写的，超时了
    /*public boolean isUgly(int n) {
        if(n==1)return true;
        if(n<=0){
            return false;
        }
        int flag=0;
        if(n%2==0||n%3==0||n%5==0)flag=1;
        for(int i=4;i<n;i++){
            if(i==5)continue;
            if(n%i==0){
                if(i%2==0||i%3==0||i%5==0)continue;
                flag=0;}
        }
        if(flag==1)return true;
        else return false;

    }*/

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }


}
