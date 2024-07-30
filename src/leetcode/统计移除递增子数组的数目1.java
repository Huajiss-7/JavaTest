package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 统计移除递增子数组的数目1 {
    public static void main(String[] args) {
        int []nums={6,5,7,8};
        System.out.println(incremovableSubarrayCount(nums));
    }

    //抄的时间O(n) 空间O(1) 双指针 困难题
    //https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/solutions/2577665/shuang-zhi-zhen-on-shi-jian-o1-kong-jian-3fl2/?envType=daily-question&envId=2024-07-10
    public static int intincremovableSubarrayCount2(int[] nums){
        int n=nums.length;
        int i=0;
        while(i<n-1&&nums[i]<nums[i+1]){//因为是下标，所以i最大为n-1
            i++;//先计算前缀最大递增坐标，看看前面有几个元素递增的
        }
        if(i==n-1){// 每个非空子数组都可以移除
            return n*(n+1)/2;
        }

        int ans = i + 2; // 不保留后缀的情况，一共 i+2 个 例如 12312 i=2可以移除 12,312,2312,12312

        // 枚举保留的后缀为 a[j:]
        for(int j=n-1;j==n-1||nums[j]<nums[j+1];j--){//上面返回的特判情况，就保证了整个数组不是单调递增的不可能无限循环
            while(i>=0&&nums[i]>=nums[j]){//维护左指针
                i--;
            }
            ans+=i+2;//保留后缀，把前面移除的所有情况，同上，中间必须全移走，所以就是顺带捎走前面的元素总共有i+2种
        }
        return ans;
    }

    //简单题
    public static int incremovableSubarrayCount(int[] nums) {
        Set<Integer>set=new HashSet<>() ;//记录移除的数组下标
        int count=0;
        for(int len=1;len<=nums.length;len++) {//遍历每个长度的子数组
            for (int i = 0; i <= nums.length-len; i++) {//遍历当前长度下每个起始位置
                for (int j = i; j < len+i; j++) {
                    set.add(j);
                }//存移除子数组的下标
                if(isIncrement(nums,set))count++;
                set.clear();
            }
        }
        return count;
    }

    private static boolean isIncrement(int[] nums,Set<Integer> set) {
        int left = -1;

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(i)) {
                continue;
            }
            if (left!=-1&&nums[left] >= nums[i]) {
                return false;
            }
            left = i;
        }
        return true;
    }
}

/*给你一个下标从 0 开始的 正 整数数组 nums 。

如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。

请你返回 nums 中 移除递增 子数组的总数目。

注意 ，剩余元素为空的数组也视为是递增的。

子数组 指的是一个数组中一段连续的元素序列。



示例 1：

输入：nums = [1,2,3,4]
输出：10
解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 [1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
示例 2：

输入：nums = [6,5,7,8]
输出：7
解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
nums 中只有这 7 个移除递增子数组。
示例 3：

输入：nums = [8,7,6,6]
输出：3
解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 nums 变为 [6,6] ，它不是严格递增的。*/

