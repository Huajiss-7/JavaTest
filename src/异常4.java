public class 异常4 {
    public static void main(String[] args) {
        int []arr={};
        int[]arr1=null;

        try {
            int max=getMax(arr);
            int max1=getMax(arr1);
        } catch (NullPointerException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

        System.out.println("主函数看看我执行了吗");
        //System.out.println(max);
    }

    public static int getMax(int[]arr)throws NullPointerException,ArrayIndexOutOfBoundsException{//函数名后的运行时异常可以省略不写
        if(arr==null){
            throw new NullPointerException();
        }
        if(arr.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println("看看我执行了吗");
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i])max=arr[i];
        }
        return max;
    }
}
