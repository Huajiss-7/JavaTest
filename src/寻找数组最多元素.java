public class 寻找数组最多元素 {
    public static void main(String[] args) {
        int[]arr={1,2,2,1,1,2,2};
        int majorElement=majorityElement(arr);
        System.out.println(majorElement);
    }

    public static int majorityElement(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <nums.length-i ; j++) {
                if(nums[i]<nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums[(int)Math.floor(nums.length/2)];
    }

    /*public static int majorityElement(int[] nums) {
        int x=0;
        int[][]arr=new int[nums.length][2];
        Arrays.fill(arr, 0);
        for(int i=0;i<nums.length;i++){
            for (int j = 0; j <i; j++) {
                if(nums[i]==nums[j]){
                    arr[i][0]=++;
                    arr[i]

                }
            }
        }

    }*/
}
