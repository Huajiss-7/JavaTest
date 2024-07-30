import java.util.ArrayList;

public class 只出现一次的元素 {
    public static void main(String[] args) {
        int[]arr1={1,1,2,3,3,4,5};
        int[]arr2={2,2,1,1,3};
        int result=singleNumber1(arr2);
        int result1=singleNumber(arr2);
        System.out.println(result1);
        //System.out.println(result);
    }//也可以用先排序，再相邻的对比，如果相邻不等就输出


    //看了参考的方法
    public static int singleNumber(int[]nums){
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 1; j <nums.length-i ; j++) {
                if(nums[j-1]>nums[j]){
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }
            }
        }

        for (int i = 0; i < nums.length-1; i+=2) {
            //if(i==nums.length)return nums[nums.length-1];
            if(nums[i]==nums[i+1])continue;
            return nums[i];
        }
        return nums[nums.length-1];
    }



    //我自己写的方法
    public static int singleNumber1(int[] nums){
        ArrayList<Integer>judge=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(judge.contains(i))continue;
            int flag=0;
            for (int j = i+1; j < nums.length; j++) {
                /*for (int k = 0; k < judge.size(); k++) {
                    if(judge.contains(j)){
                        //System.out.println("看看执行了没");
                        continue;
                    }
                }*/
                if(j==nums.length)return nums[nums.length-1];
                if(nums[i]==nums[j]){
                    judge.add(j);
                    flag=1;
                }
            }
            if(flag==0)return nums[i];
        }
        return -1;
    }
}
