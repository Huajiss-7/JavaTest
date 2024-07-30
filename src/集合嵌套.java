import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 集合嵌套 {
    public static void main(String[] args) {

        ArrayList<String>cityList1=new ArrayList<>();
        Collections.addAll(cityList1,"新乡","开封","郑州","洛阳","许昌");
        ArrayList<String>cityList2=new ArrayList<>();
        Collections.addAll(cityList2,"武汉","襄阳","宜昌","孝感");
        ArrayList<String>cityList3=new ArrayList<>();
        Collections.addAll(cityList3,"济南","烟台","青岛","日照");

        HashMap<String,ArrayList<String>>hm=new HashMap<>();
        hm.put("河南",cityList1);
        hm.put("湖北",cityList2);
        hm.put("山东",cityList3);

        for (Map.Entry<String, ArrayList<String>> provice : hm.entrySet()) {
            StringBuilder sb=new StringBuilder();
            String key = provice.getKey();
            sb.append(key).append("=");
            ArrayList<String>city=provice.getValue();
            for (int i = 0; i < city.size(); i++) {
                if(i==city.size()-1)sb.append(city.get(i));
                else sb.append(city.get(i)).append(",");
            }
            System.out.println(sb);
        }
    }
}
