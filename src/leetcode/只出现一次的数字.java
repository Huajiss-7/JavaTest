package leetcode;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[]nums={0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int one=0;//因为重复的数字都出现三次，所以所有数字化成二进制每一个比特位相加之和模3的值就是剩余的单个数字
        int two=0;//因为模三有0，1，2三种结果，表示为00，01，10 所以用two one表示两个二进制位
        for (int num : nums) {
            one=one^num&~two;//位运算不能随意交换位置
            two=two^num&~one;//因为运算相加中间有可能取模余数为2，所以需要two来记录
        }
        return one;//因为每一位累加的结果模3之后一定为01或00所以只用返回one就行，two一定为0
    }

    public static int singleNumber1(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

}
//解析
//https://leetcode.cn/problems/single-number-ii/solutions/8944/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/

   /* 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

        你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。



        示例 1：

        输入：nums = [2,2,3,2]
        输出：3
        示例 2：

        输入：nums = [0,1,0,1,0,1,99]
        输出：99*/
