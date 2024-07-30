package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

public class 找出最长等值子数组 {
    public static void main(String[] args) {
        List<Integer>nums=new ArrayList<>();
        Collections.addAll(nums,1,3,2,3,1,3);
        System.out.println(longestEqualSubarray(nums,3));
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        List<Integer>[]posList=new ArrayList[nums.size()+1];//假设nums的值是连续的,最多就是1到size-1
        Arrays.setAll(posList, new IntFunction<List<Integer>>() {
            @Override
            public List<Integer> apply(int value) {
                return new ArrayList<>();
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            posList[nums.get(i)].add(i);//记录每个相同数字所在的位置
        }

        int ans=0;
        for (List<Integer> pos : posList) {//因为pos无论怎么分布，结果都是遍历nums的所有数一遍，所以三重循环的时间复杂度也是O(n)
            if(pos.size()<=ans)continue;//就是全部相同的数都能取到也不能更新最大值
            int left=0;
            for(int right=0;right<pos.size();right++){//右移窗口
                while (pos.get(right)-pos.get(left)-(right-left)>k)left++;//要删除的值大于k左移窗口
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans;
    }
}


/*给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

        如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。

        从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。

        子数组 是数组中一个连续且可能为空的元素序列。



        示例 1：

        输入：nums = [1,3,2,3,1,3], k = 3
        输出：3
        解释：最优的方案是删除下标 2 和下标 4 的元素。
        删除后，nums 等于 [1, 3, 3, 3] 。
        最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
        可以证明无法创建更长的等值子数组。
        示例 2：

        输入：nums = [1,1,2,2,1,1], k = 2
        输出：4
        解释：最优的方案是删除下标 2 和下标 3 的元素。
        删除后，nums 等于 [1, 1, 1, 1] 。
        数组自身就是等值子数组，长度等于 4 。
        可以证明无法创建更长的等值子数组。*/
