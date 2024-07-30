import java.util.*;

public class 哈希表统计 {
    public static void main(String[] args) {
        Random r=new Random();
        String[]arr={"a","b","c","d"};
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<80;i++){
            int index=r.nextInt(arr.length);
            list.add(arr[index]);
        }

        HashMap<String,Integer>hm=new HashMap<>();
        for (String name : list) {
            if(hm.containsKey(name)){
                int count=hm.get(name);
                hm.put(name,++count);
            }else {
                hm.put(name,1);
            }
        }

        System.out.println(hm);

        int max=0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            max=entry.getValue()>max? entry.getValue() : max;
        }
        System.out.println(max);

        for (Map.Entry<String, Integer> entry : entries) {
            if(max==entry.getValue()){
                System.out.println(entry.getKey());//一样多会都打印
            }
        }
    }
}
