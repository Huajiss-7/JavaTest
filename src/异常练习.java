import java.util.Scanner;

public class 异常练习 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GirlFriend gf=new GirlFriend();

        while (true) {
            try {
                System.out.println("输入姓名3-10，字符之间");
                String name = sc.nextLine();
                gf.setName(name);
                System.out.println("输入年龄在18-40岁之间");
                String age = sc.nextLine();
                gf.setAge(Integer.parseInt(age));
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("年龄格式有误");
                //throw new RuntimeException(e);
            }catch (NameFormatException e){
                e.printStackTrace();
                System.out.println("名字格式有误");
            }catch (RuntimeException e){
                System.out.println("年龄范围有误");
                e.printStackTrace();
            }
        }

        System.out.println(gf);
    }
}

class GirlFriend{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameFormatException {
        if(name.length()>10||name.length()<3){
            throw new NameFormatException(name+"格式有误，长度应为3-10");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>40||age<18){
            throw new RuntimeException();
        }
        this.age = age;
    }

    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public GirlFriend() {
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}