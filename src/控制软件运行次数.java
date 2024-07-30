import java.io.*;

public class 控制软件运行次数 {
    public static void main(String[] args) throws IOException {
        //restart();
        /*BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
        int len;
        byte[]bytes=new byte[1024];
        if((len=bis.read())==-1){
            bos.write("欢迎使用本软件，第一次使用免费".getBytes());
        }
        while ((len=bis.read(bytes))!=-1){
            System.out.println(Arrays.toString(bytes));
        }
        bos.close();
        bis.close();*/

        BufferedReader bf=new BufferedReader(new FileReader("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
        String line=bf.readLine();
        int count;
        /*if(line==null){count=1;
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
            bw.write("");
            bw.close();
        }
        else {count=Integer.parseInt(line);
        count++;}*/

        try {
            count=Integer.parseInt(line);
            count++;
        }catch (Exception e){
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
            bw.write("");
            bw.close();
            count=1;
        }

        if(count>3){
            System.out.println("最多免费使用3次");
        }else {
            System.out.println("欢迎使用本软件，第"+count+"次使用免费");
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt"));
            bw.write(count+"");
            bw.close();
        }
        bf.close();

    }

    private static void restart() throws IOException {
        File f1=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt");
        f1.delete();
        File f2=new File("C:\\Users\\13063\\Desktop\\upm学习\\编程概念\\fileTest\\运行次数.txt");
        f2.createNewFile();
    }
}
