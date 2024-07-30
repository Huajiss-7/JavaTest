import java.util.ArrayList;
import java.util.Collections;

public class collections {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"afd","123","fsdf","nbm","sfsdf","po0");
        System.out.println(list);
        Collections.shuffle(list);//打乱
        System.out.println(list);
    }
}
