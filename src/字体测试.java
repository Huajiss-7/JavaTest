import java.awt.*;

public class 字体测试 {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
