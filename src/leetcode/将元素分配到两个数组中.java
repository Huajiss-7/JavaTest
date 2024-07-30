package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 将元素分配到两个数组中 {
    public static void main(String[] args) {
        int[]nums={2,1,3,3};
        for (int num : resultArray1(nums)) {
            System.out.print(num+" ");
        }
    }

    public static int[] resultArray(int[] nums) {
        ArrayList<Integer>arr1=new ArrayList<>(),arr2=new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int g1=greaterCount(arr1, nums[i]);
            int g2=greaterCount(arr2, nums[i]);
            if(g1>g2)arr1.add(nums[i]);
            else if (g1<g2)arr2.add(nums[i]);
            else {
                if(arr2.size()<arr1.size())arr2.add(nums[i]);
                else arr1.add(nums[i]);
            }
        }
        arr1.addAll(arr2);
        int[]res=new int[nums.length];
        for (int i = 0; i < arr1.size(); i++) {
            res[i]=arr1.get(i);
        }
        return res;
    }

    public static int greaterCount(List<Integer>list,int val){
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>val)count++;
        }
        return count;
    }


    //抄的
    public static int[] resultArray1(int[] nums) {
        // 克隆输入数组并进行排序，但不去重
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;

        // 初始化两个列表 a 和 b 及其预分配空间
        List<Integer> a = new ArrayList<>(n);
        List<Integer> b = new ArrayList<>();
        // 将第一个元素添加到列表 a，将第二个元素添加到列表 b
        a.add(nums[0]);
        b.add(nums[1]);

        // 初始化两个树状数组 t1 和 t2，长度为 n + 1
        Fenwick t1 = new Fenwick(n + 1);
        Fenwick t2 = new Fenwick(n + 1);
        // 将第一个元素的位置添加到树状数组 t1，第二个元素的位置添加到树状数组 t2
        t1.add(Arrays.binarySearch(sorted, nums[0]) + 1);
        t2.add(Arrays.binarySearch(sorted, nums[1]) + 1);

        // 遍历数组的其余元素
        for (int i = 2; i < nums.length; i++) {
            int x = nums[i];
            int v = Arrays.binarySearch(sorted, x) + 1; // 获取当前元素在排序数组中的位置
            // 计算当前元素在列表 a 和 b 中的逆序对数量
            int gc1 = a.size() - t1.pre(v); // 计算列表 a 中比 x 大的元素数量
            int gc2 = b.size() - t2.pre(v); // 计算列表 b 中比 x 大的元素数量

            // 比较逆序对数量，将当前元素 x 添加到列表 a 或 b 中
            if (gc1 > gc2 || (gc1 == gc2 && a.size() <= b.size())) {
                a.add(x);
                t1.add(v); // 更新树状数组 t1
            } else {
                b.add(x);
                t2.add(v); // 更新树状数组 t2
            }
        }

        // 将列表 b 中的所有元素添加到列表 a 中
        a.addAll(b);
        // 将结果存回原数组 nums 中
        for (int i = 0; i < n; i++) {
            nums[i] = a.get(i);
        }
        return nums;
    }


}
//抄的
class Fenwick {
    private final int[] tree;

    public Fenwick(int n) {
        tree = new int[n];
    }

    // 把下标为 i 的元素增加 1
    public void add(int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & -i;//首先，我们需要理解 i & -i 的含义。这是一个常见的位运算技巧，用于获取整数 i 的二进制表示中最低位的 1 对应的值。
        }
    }

    // 返回下标在 [1,i] 的元素之和
    public int pre(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i &= i - 1;// 是一种常见的位运算技巧，通常用于快速清除整数 i 的二进制表示中最低位的 1。这个操作在很多算法中都有应用，特别是与位掩码和位计数相关的算法。
        }
        return res;
    }
}


/*给你一个下标从 1 开始、长度为 n 的整数数组 nums 。

        现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。

        你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：

        如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
        如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
        如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
        如果仍然相等，那么将 nums[i] 追加到 arr1 。
        连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。

        返回整数数组 result 。



        示例 1：

        输入：nums = [2,1,3,3]
        输出：[2,3,1,3]
        解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
        在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
        在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
        在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
        因此，连接形成的数组 result 是 [2,3,1,3] 。
        示例 2：

        输入：nums = [5,14,3,1,2]
        输出：[5,3,1,2,14]
        解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
        在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
        在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
        在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
        在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
        因此，连接形成的数组 result 是 [5,3,1,2,14] 。
        示例 3：

        输入：nums = [3,3,3,3]
        输出：[3,3,3,3]
        解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
        因此，连接形成的数组 result 是 [3,3,3,3] 。*/
