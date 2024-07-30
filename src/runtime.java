import java.io.IOException;

public class runtime {
    public static void main(String[] args) throws IOException {
        long i=Runtime.getRuntime().maxMemory();
        long j=Runtime.getRuntime().totalMemory();
        System.out.println(i/1024/1024);
        System.out.println(j);
        System.out.println(Runtime.getRuntime().availableProcessors());
        Runtime.getRuntime().exec("notepad");
        //Runtime.getRuntime().exec("shutdown -s -t 3600");
        Runtime.getRuntime().exec("shutdown -s");
        //Runtime.getRuntime().exec("shutdown -a");
    }
}
