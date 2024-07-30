package leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[]nums={0,0,0,1,1,2,3,4,4,4,5,5};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer>set=new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int index=0;
        for (Integer i : set) {
            nums[index]=i;
            index++;
        }
        return set.size();
    }

    //双指针版本
    public static int removeDuplicates1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;//本质是把不相等的元素移到左边
        while(q < nums.length){
            if(nums[p] != nums[q]){//如果相等直接q往后移一位，如果不相等则把q位置的元素复制到p+1位置上，p，q各往后移一位
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

}

    /*给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

        考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

        更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        返回 k 。
        判题标准:

        系统会用下面的代码来测试你的题解:

        int[] nums = [...]; // 输入数组
        int[] expectedNums = [...]; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }
        如果所有断言都通过，那么您的题解将被 通过。



        示例 1：

        输入：nums = [1,1,2]
        输出：2, nums = [1,2,_]
        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
        示例 2：

        输入：nums = [0,0,1,1,1,2,2,3,3,4]
        输出：5, nums = [0,1,2,3,4]
        解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。*/
