package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] ints : merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//从区间开始大小，从小到大排序
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 0; i < intervals.length-1; i++) {
            if(mergedIntervals.getLast()[1] >= intervals[i + 1][0]) {//如果当前区间的结尾大于下一个区间的开头，就更新
                int begin = mergedIntervals.getLast()[0];
                int end = mergedIntervals.getLast()[1];
                int maxEnd = Math.max(end,intervals[i+1][1]);
                mergedIntervals.removeLast();
                mergedIntervals.add(new int[]{begin, maxEnd});
            }else {
                mergedIntervals.add(new int[]{intervals[i+1][0],intervals[i+1][1]});
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。



示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


提示：

        1 <= intervals.length <= 104
intervals[i].length == 2
        0 <= starti <= endi <= 104*/
