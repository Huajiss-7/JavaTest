import java.util.Comparator;
import java.util.TreeMap;

public class 树地图 {
    public static void main(String[] args) {
        //Goods g1=new Goods(3,"火腿3");
        //Goods g2=new Goods(1,"香肠1");
        //Goods g3=new Goods(2,"烤肠2");
        TreeMap <Integer,String>tm=new TreeMap<>();
        tm.put(3,"火腿3");
        tm.put(1,"香肠1");
        tm.put(2,"烤肠2");
        System.out.println(tm);

        TreeMap <Integer,String>tm2=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                System.out.println("---------");
                return o2-o1;
            }
        });

        tm2.put(3,"火腿3");
        tm2.put(1,"香肠1");
        tm2.put(2,"烤肠2");
        System.out.println(tm2);
    }
}

/*class Goods{
    int id;
    String name;

    public Goods() {
    }

    public Goods(int id, String name) {
        this.id = id;
        this.name = name;
    }
}*/
