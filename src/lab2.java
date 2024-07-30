public class lab2 {
    public static void main(String[] args) {
        System.out.println(1);
        menu();
        System.out.println(2);

        int sum = add(1, 2);
        System.out.println(sum);
    }

    public static void menu() {
        System.out.println("我是菜单");
    }

    public static int add(int x, int y) {
        System.out.println("加法函数启动");
        return x + y;
    }
}
