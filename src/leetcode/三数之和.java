package leetcode;

import java.util.*;

public class 三数之和 {
    public static void main(String[] args) {
        int[]nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    //双指针
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])continue;//出现重复元素，跳下一个避免结果重复
            for(int j=i+1,k=nums.length-1;j<nums.length;j++){
                if (j>i+1&&nums[j]==nums[j-1])continue;//同理，枚举时第二个元素重复也跳下一个
                while (j<k&&nums[i]+nums[j]+nums[k]>0)k--;//排列好后，第二个元素一定在中间，nums[i]<=nums[j]<=nums[k]，如果最大的那个nums[k]加当前的nums[j]都不能大于-nums[i]，那么k-1就更无意义，如果大于，那么左移k，直到k==j或者相加小于nums[i]
                if(j==k)break;//此时的nums[j]和后面相加无论如何都大于nums[i]，j再变大，nums[j]变大更无可能，这个i已无意义
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer>list=new ArrayList<>();
                    Collections.addAll(list,nums[i],nums[j],nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //超时
    public static List<List<Integer>> threeSum1(int[] nums) {
        if(nums.length<3)return null;
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        int seg=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<=0&&nums[i+1]>0)seg=i;
        }
        for (int i = 0; i <= seg; i++) {
            int one=nums[i];
            for (int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(one+nums[j]+nums[k]==0){
                        List<Integer>temp=new ArrayList<>();
                        Collections.addAll(temp,one,nums[j],nums[k]);
                        list.add(temp);
                    }
                }
            }
        }
        Set<List<Integer>>set=new HashSet<>(list);
        List<List<Integer>>ans=new ArrayList<>(set);
        return ans;
    }
}

    /*你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

        你返回所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。





        示例 1：

        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
        示例 2：

        输入：nums = [0,1,1]
        输出：[]
        解释：唯一可能的三元组和不为 0 。
        示例 3：

        输入：nums = [0,0,0]
        输出：[[0,0,0]]
        解释：唯一可能的三元组和为 0 。*/
