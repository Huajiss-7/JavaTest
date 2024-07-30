import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String a=new String();
        Scanner input=new Scanner(System.in);
        System.out.println("Hello world!");
        int[]b=new int[2];

    }
    //@Test
    public int[] twoSum(int[] nums, int target) {

        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a=i;
                    b=j;
                }
            }
        }
        int[]c={a,b};
        return c;
    }
}