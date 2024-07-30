package leetcode;

public class 区域和检索数组不可变 {
    public static void main(String[] args) {
        int[]nums={-2, 0, 3, -5, 2, -1};
        NumArray numArray=new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {
    public int[]nums;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int left, int right) {
        int sum=0;
        while (left<=right){
            sum+=nums[left];
            left++;
        }
        return sum;
    }
}

//设计模式
//为了实现特定目的，如果像上面普通设计，时间复杂度太高
//设定特定数组，记录截至到每个下标的前面数之和
//这样的话要查询i到j直接数之和等于到j之和减去到i-1之和sums[j + 1] - sums[i];
class NumArray1 {
    int[] sums;

    public NumArray1(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}



   /* 给定一个整数数组  nums，处理以下类型的多个查询:

        计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
        实现 NumArray 类：

        NumArray(int[] nums) 使用数组 nums 初始化对象
        int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )


        示例 1：

        输入：
        ["NumArray", "sumRange", "sumRange", "sumRange"]
        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
        输出：
        [null, 1, -1, -3]

        解释：
        NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
        numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
        numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
        numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))*/