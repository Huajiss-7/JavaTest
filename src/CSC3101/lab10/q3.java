package CSC3101.lab10;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("https://liveexample.pearsoncmg.com/data/babynamesranking2010.txt");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.next();
        try (Scanner input=new Scanner(url.openStream())){
            boolean find=false;
            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] info = line.split("\\s+");
                if(info[1].equals(name)||info[3].equals(name)){
                    System.out.println(name+"  is ranked no."+info[0]);
                    find=true;
                    break;
                }
            }
            if(!find){
                System.out.println("The name "+name+" is not listed in the ranking.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
