public class 异常2 {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5};
        try {
            //System.out.println(arr[10]);
            //System.out.println(2/0);//不是下面的异常类型，执行不了catch
            String s=null;
            System.out.println(s.equals("abc"));
        }catch (ArrayIndexOutOfBoundsException |NullPointerException e){
            System.out.println("数组越界了");
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }catch (Exception e){
            System.out.println("异常");
        }
        System.out.println("看看我执行了没");
    }
}
