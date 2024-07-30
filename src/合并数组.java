import java.util.Arrays;

public class 合并数组 {
    public static void main(String[] args) {
        int[]nums1 = {1,2,3,0,0,0};
        int m=3;
        int[]nums2 = {2,5,6};
        int n=3;
        merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        //nums1[0]=0; 会影响原数组
        if(nums1.length==0||nums2.length==0)return;
        int flag=0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]!=0){
                flag=1;
                break;
            }
        }
        if(flag==0){
            for (int i = 0; i < nums1.length&&i<nums2.length; i++) {
                nums1[i]=nums2[i];
            }
        }
        int j=0;
        for (int i = nums1.length-n; i < nums1.length&&j<nums2.length; i++,j++) {
            nums1[i]=nums2[j];
        }
        if(j<nums2.length-1){

        }

        Arrays.sort(nums1);
    }
}
