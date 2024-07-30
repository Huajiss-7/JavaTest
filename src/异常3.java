public class 异常3 {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5};
        try {//快捷键ctrl+alt+T
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = e.getMessage();
            System.out.println(message);
            String str = e.toString();
            System.out.println(str);
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        System.out.println("看看我执行了没");//红色打印异常，但不会结束虚拟机
        System.err.println(123);//用于打印错误语句,当错误输出语句与正常输出语句一起打印时，有可能打印顺序不一样
    }
}
