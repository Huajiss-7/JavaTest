//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:11
public class lab11 {
    //q1
    /*public static void main(String[] args) {
        int[]arr={1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[arr.length-1-i]+" ");
        }
    }*/

    //q2
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = {"S", "M", "L", "X"};
        String[] arr2 = {" $6.99", " $8.99", " $12.50", " $15.00"};
        boolean flag = true;
        while (flag) {
            System.out.println("choose a pizza size – S, M, L, or X");
            String s = sc.next();
            for (int i = 0; i < arr1.length; i++) {
                if (s.equals(arr1[i])) {
                    System.out.println(arr2[i]);
                    flag = false;
                }
            }
            if(flag) System.out.println("please re-enter the size");
        }
    }*/

    //q3
    public static void main(String[] args) {
        String[] names = {"zhangsan", "lisi", "wangwu", "zhaoliu", "sunqi"};
        int totalVowels = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
            totalVowels+=countVowels(names[i]);
        }
        System.out.println("\nTotal Vowels: " + totalVowels);
    }
    private static int countVowels(String str) {
        int count = 0;
        for (int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
