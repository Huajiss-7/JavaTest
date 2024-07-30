import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class 网络爬虫1 {
    public static void main(String[] args) throws IOException {
        URL url1=new URL("https://hanyu.baidu.com/shici/detail?from=aladdin&pid=60841450e8714b78a6f7ef385dcb63e0");

        try {
            URLConnection connection= url1.openConnection();
            BufferedReader bf=new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line= bf.readLine())!=null){
                System.out.println(line);
            }
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
