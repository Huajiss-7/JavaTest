import java.io.*;
import java.util.Scanner;

public class 注册登录 {
    //注册功能用于尝试，同时只能有一个用户
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        showMenu();
        int judge= sc.nextInt();
        switch (judge){
            case 1:
                register();
                break;
            case 2:
                login();
                break;
        }
    }

    public static void showMenu(){
        System.out.println("输入你想要的功能");
        System.out.println("1----注册");
        System.out.println("2----登录");
    }

    //注册
    public static void register() throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入您要注册的用户名");
        String username= sc.next();
        System.out.println("输入您要注册的密码");
        String password=sc.next();

        BufferedWriter bf=new BufferedWriter(new FileWriter("userInfo.txt"));
        String content="username="+username+"&"+"password="+password+"&count=0";
        bf.write(content);
        bf.close();
    }

    public static void login() throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader bf=new BufferedReader(new FileReader("userInfo.txt"));
        String line = bf.readLine();
        bf.close();

        String rightUsername=line.split("&")[0].split("=")[1];
        String rightPassword=line.split("&")[1].split("=")[1];
        int count=Integer.parseInt(line.split("&")[2].split("=")[1]);

        System.out.println("输入您的用户名");
        String username= sc.next();
        System.out.println("输入您的密码");
        String password=sc.next();

        BufferedWriter bw=new BufferedWriter(new FileWriter("userInfo.txt"));

        if(password.equals(rightPassword)&&username.equals(rightUsername)&&count<3){
            System.out.println("登录成功");
            bw.write("username=" + rightUsername + "&password=" + rightPassword + "&count=0");
        }else if(count>=3){
            System.out.println("账户已经被锁定");
        }else {
            count++;
            System.out.println("登陆失败,还剩下" + (3 - count) + "次机会");
            bw.write("username=" + rightUsername + "&password=" + rightPassword + "&count="+count);
        }
        bw.close();
    }
}



