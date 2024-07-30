import java.util.ArrayList;
import java.util.Collections;

public class 点名系统 {
    public static void main(String[] args) {

        ArrayList<String>boyList=new ArrayList<>();
        Collections.addAll(boyList,"鸣人","佐助","路飞","索隆");
        ArrayList<String>girlList=new ArrayList<>();
        Collections.addAll(girlList,"小樱","娜美","金克斯");
        ArrayList<String>list=new ArrayList<>(boyList);
        Collections.addAll(list,"小樱","娜美","金克斯");
        System.out.println(list);


        weightRandom(boyList,girlList);
        noRepeat(list);
    }

    public static <T> void weightRandom(ArrayList<T>boyList,ArrayList<T>girlList){
        ArrayList<Integer>list=new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1);
        Collections.addAll(list,0,0,0);
        Collections.shuffle(list);
        if(list.get(0)==1){
            Collections.shuffle(boyList);
            System.out.println(boyList.get(0));
        }else if(list.get(0)==0){
            Collections.shuffle(girlList);
            System.out.println(girlList.get(0));
        }
    }

    public static <E>void noRepeat(ArrayList<E>list){
        //循环从集合中抽一个删一个，把抽出来的再放入一个新集合中，最后把新集合拷贝给原集合，在清空新集合
    }
}
