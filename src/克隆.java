import com.google.gson.Gson;

import java.util.Objects;

public class 克隆 {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[]data={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        User u1=new User(1,"huaji","123","animal1",data);
        User u2= (User) u1.clone();
        System.out.println(u1);
        System.out.println(u2);
        //外部导入gson包
        Gson gson=new Gson();
        String g1=gson.toJson(u1);//把对象变成字符串
        System.out.println(g1);
        User u3=gson.fromJson(g1,User.class);
        System.out.println(u3);
        String g2=gson.toJson(u2);
        boolean r=Objects.equals(g1,g2);//字符串的equals比较的是内容，object默认比较的是地址
        System.out.println(r);

        boolean result= Objects.equals(u1,u3);
        System.out.println(result);
    }
}
