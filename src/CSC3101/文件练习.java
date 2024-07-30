package CSC3101;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class 文件练习 {
    public static void main(String[] args) throws IOException {
        File file=new File("a.txt");
        System.out.println(file.exists());
        PrintWriter output=new PrintWriter(file);
        output.print(1);
        output.close();
        Scanner input=new Scanner(file);
        while (input.hasNext()){
            System.out.println(input.next());
        }
        Scanner sc=new Scanner(new URL("https://translate.google.com/?hl=zh-CN&sl=en&tl=zh-CN&text=gist&op=translate").openStream());
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }
}
