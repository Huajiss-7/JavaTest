public class 数组加一 {
    public static void main(String[] args) {
        int[]digits = {9,9,9};
        int[]digits2={1,2,3,4};
        int[]digits3={1,2,9,9};
        int[]result=plusOne(digits);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length-1]=digits[digits.length-1]+1;
        if(digits[digits.length-1]>9){
        for (int i = digits.length; i >1 ; i--) {
            if(digits[i-1]>9){
                digits[i-1]=0;
                digits[i-2]=digits[i-2]+1;
            }
        }//for
    }//if
        if(digits[0]>9){
            digits[0]=0;
            int[]result=new int[digits.length+1];
            System.arraycopy(digits,0,result,1,digits.length);
            result[0]=1;
            return result;
        }
        return digits;
    }

    //其他方法
    /*public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }*/
}
