import java.io.*;
import java.util.Random;

public class 点名1 {
    //随机点名
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("names.txt"));
        Random r=new Random();
        int index=r.nextInt(120);
        int i=0;
        while (i<index){br.readLine();i++;}
        String line = br.readLine();
        br.close();
        String s = line.split("-")[0];
        System.out.println(s);
    }
}
