import java.util.*;

public class 不可变集合 {
    public static void main(String[] args) {
        //不可变集合,不是对象,只能进行查询
        List<String> list = List.of("张三", "李四", "王五");

        String s1 = list.get(0);
        System.out.println(s1);

        for (String s : list) {
            System.out.print(s+" ");
        }

        System.out.println();

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String next = it.next();
            System.out.print(next+" ");
        }

        System.out.println("-----------------------");
        //list.add("aaa");
        //list.remove(0);

        Set<String> set = Set.of("abc", "123", "ABC");
        System.out.println(set);
       // Set<String> set1 = Set.of("abc","123", "123", "ABC");//报错，set元素不能重复

        System.out.println("--------------------------");
        Map<String, String> map = Map.of("1", "a", "2", "b", "3", "c");
        System.out.println(map);

        System.out.println("----------超过十个键值对的map不可变集合创建方式--------------");
        HashMap<String,String>hm=new HashMap<>();
        hm.put("111","aaa");
        hm.put("222","bbb");
        hm.put("333","ccc");
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        System.out.println(entries);
        Object[] objects = entries.toArray();
        System.out.println(objects+" ");
        Map.Entry[] array = entries.toArray(new Map.Entry[0]/*不要写超过实际数据的索引*/);//变成entry对象的数组
        System.out.println(array);
        Map map1 = Map.ofEntries(array);
        System.out.println(map1);

        System.out.println("---------简化--------------");
        Map<Object, Object> objectObjectMap = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));
        System.out.println(objectObjectMap);

        System.out.println("-------更简单的-----------");
        Map<String, String> map2 = Map.copyOf(hm);//自动转化成不可变集合
        System.out.println(map2);
    }
}
