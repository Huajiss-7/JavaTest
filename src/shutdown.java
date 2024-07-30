import java.io.IOException;

public class shutdown {
    public static void main(String[] args) throws IOException {
        //Runtime.getRuntime().exec("shutdown -s");
        for (int i = 0; i <10 ; i++) {
            Runtime.getRuntime().exec("notepad");
        }


    }
}
