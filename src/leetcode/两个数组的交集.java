package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class 两个数组的交集 {
    public static void main(String[] args) {
        int[]nums1={1,2,2,1};
        int[]nums2={2,2};
        for (int i : intersection(nums1, nums2)) {
            System.out.print(i+" ");
        }
        System.out.println("\n----------------");
        for (int i : intersect(nums1, nums2)) {
            System.out.print(i+" ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>hs=new HashSet<>();
        HashSet<Integer>ans=new HashSet<>();
        for (int i : nums1) {
            hs.add(i);
        }
        for (int i : nums2) {
            if(hs.contains(i)){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer>hs=new HashSet<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for (int i : nums1) {
            hs.add(i);
        }
        for (int i : nums2) {
            if(hs.contains(i)){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

    /*给定两个数组 nums1 和 nums2 ，返回 它们的
        交集
        。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。



        示例 1：

        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
        示例 2：

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]
        解释：[4,9] 也是可通过的*/


    /*给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。



        示例 1：

        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2,2]
        示例 2:

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[4,9]*/
