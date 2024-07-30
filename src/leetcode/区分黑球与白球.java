package leetcode;

public class 区分黑球与白球 {
    public static void main(String[] args) {
        String s="111111111100100010";
        System.out.println(minimumSteps(s));
    }

    public static long minimumSteps(String s) {
        long step=0;
        int right=s.length()-1;
        int left=0;
        while (left<right){
            while (s.charAt(right)=='1'&&right>0){
                right--;
            }
            while (s.charAt(left)=='0'&&left<s.length()-1){
                left++;
            }
            if(right>left)step+=right-left;
            right--;
            left++;
        }
        return step;
    }
}

    /*桌子上有 n 个球，每个球的颜色不是黑色，就是白色。

        给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。

        在每一步中，你可以选择两个相邻的球并交换它们。

        返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。



        示例 1：

        输入：s = "101"
        输出：1
        解释：我们可以按以下方式将所有黑色球移到右侧：
        - 交换 s[0] 和 s[1]，s = "011"。
        最开始，1 没有都在右侧，需要至少 1 步将其移到右侧。
        示例 2：

        输入：s = "100"
        输出：2
        解释：我们可以按以下方式将所有黑色球移到右侧：
        - 交换 s[0] 和 s[1]，s = "010"。
        - 交换 s[1] 和 s[2]，s = "001"。
        可以证明所需的最小步数为 2 。
        示例 3：

        输入：s = "0111"
        输出：0
        解释：所有黑色球都已经在右侧。*/