import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class 点名2 {
    //男生70%点到，女生30%
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("names.txt"));
        ArrayList<String>boys=new ArrayList<>();
        ArrayList<String>girls=new ArrayList<>();
        String line=null;
        while ((line=br.readLine())!=null){
            String gender=line.split("-")[1];
            if(gender.equals("男"))boys.add(line.split("-")[0]);
            if(gender.equals("女"))girls.add(line.split("-")[0]);
        }
        Random r=new Random();
        int boyCount=0;
        int girlCount=0;
        for(int i=0;i<1000000;i++){
            int index= r.nextInt(10);
            Collections.shuffle(boys);
            Collections.shuffle(girls);
            if(index<7) {
                //System.out.println(boys.get(0));
                boyCount++;
            }
            else {
                //System.out.println(girls.get(0));
                girlCount++;
            }
        }
        System.out.println("点到男生的次数:"+boyCount);
        System.out.println("点到女生的次数:"+girlCount);
    }
}
