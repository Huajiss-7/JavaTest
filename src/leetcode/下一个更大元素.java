package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 下一个更大元素 {
    public static void main(String[] args) {
        int[]num1={4,1,2};
        int[]num2={1,3,4,2};
        for (int i : nextGreaterElement1(num1, num2)) {
            System.out.print(i+" ");
        }
    }

    /*我们可以先预处理 nums2\textit{nums}_2nums
2
        ​
        ，使查询 nums1\textit{nums}_1nums
1
        ​
    中的每个元素在 nums2\textit{nums}_2nums
2
        ​
    中对应位置的右边的第一个更大的元素值时不需要再遍历 nums2\textit{nums}_2nums
2
        ​
        。于是，我们将题目分解为两个子问题：

    第 111 个子问题：如何更高效地计算 nums2\textit{nums}_2nums
2
        ​
    中每个元素右边的第一个更大的值；

    第 222 个子问题：如何存储第 111 个子问题的结果。

    算法

    我们可以使用单调栈来解决第 111 个子问题。倒序遍历 nums2\textit{nums}_2nums
2
        ​
        ，并用单调栈中维护当前位置右边的更大的元素列表，从栈底到栈顶的元素是单调递减的。

    具体地，每次我们移动到数组中一个新的位置 iii，就将当前单调栈中所有小于 nums2[i]\textit{nums}_2[i]nums
2
        ​
        [i] 的元素弹出单调栈，当前位置右边的第一个更大的元素即为栈顶元素，如果栈为空则说明当前位置右边没有更大的元素。随后我们将位置 iii 的元素入栈。

    可以结合以下例子来理解。


            1 / 13
    因为题目规定了 nums2\textit{nums}_2nums
2
        ​
    是没有重复元素的，所以我们可以使用哈希表来解决第 222 个子问题，将元素值与其右边第一个更大的元素值的对应关系存入哈希表。

    细节

    因为在这道题中我们只需要用到 nums2\textit{nums}_2nums
2
        ​
    中元素的顺序而不需要用到下标，所以栈中直接存储 nums2\textit{nums}_2nums
2
        ​
    中元素的值即可。*/
    //单调栈
    //先遍历nums2，把其中所有元素的下一个更大值存入map中，之后num1只用根据key去拿值就行
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();//最小栈
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums2[i]){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i]=map.get(nums1[i]);
        }
        return res;
    }


    //暴力
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int index=j+1;
                    while (index<nums2.length){
                        if(nums1[i]<nums2[index]){
                            res[i]=nums2[index];
                            break;
                        }
                        index++;
                    }
                }
            }
        }
        return res;
    }
}

/*
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。



示例 1：

输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
输出：[-1,3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
        - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
        - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
        - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
示例 2：

输入：nums1 = [2,4], nums2 = [1,2,3,4].
输出：[3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
        - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
        - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。*/
