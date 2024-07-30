package leetcode;

public class 跳跃游戏2 {
    public static void main(String[] args) {
        int[]nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }

    //gpt的
    public static int jump1(int[] nums) {
        if(nums.length < 2) return 0;

        int times = 0; // 记录跳跃次数
        int maxDistance = 0; // 当前位置能够跳跃的最远距离
        int currentMaxDistance = 0; // 下一步能够跳跃的最远距离

        for(int i = 0; i < nums.length - 1; i++) {
            //在i到达能达到最远距离之间，更新这里面的点能到达的更远的距离，取最大值
            currentMaxDistance = Math.max(currentMaxDistance, i + nums[i]); // 计算下一步能够跳跃的最远距离
            //到达上一点到达能到达的最大距离时，更新这其中有没有能到达更大的距离，实际上就是跳到其中那个点，因为每一次更新都是到达最大距离，当更新的距离大于数组长度时不会再更新了，也就是更新几次能覆盖数组，这就是最小跳跃次数
            if(i == maxDistance) { // 到达当前位置能够跳跃的最远距离
                maxDistance = currentMaxDistance; // 更新当前位置能够跳跃的最远距离
                times++; // 跳跃次数加1
            }
        }

        return times;
    }


    //错了
    public static int jump(int[] nums) {
        if(nums.length<2)return 0;
        int times=0;
        int distance=nums[0];
        int index=0;
        while (distance<nums.length){
            int len=0;
            int temp=index;
            for (int j=index;j<index+nums[index]&&j<nums.length;j++){
                len=Math.max(len,j-index+nums[j]);
                if(len==j-index+nums[j]){
                    index=j;
                    times++;
                }
            }
            distance+=len-nums[temp];
        }
        return times;
    }
}

    /*给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

        0 <= j <= nums[i]
        i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



        示例 1:

        输入: nums = [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
        从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
        示例 2:

        输入: nums = [2,3,0,1,4]
        输出: 2*/