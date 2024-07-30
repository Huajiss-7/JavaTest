package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插入区间 {
    public static void main(String[] args) {
        int[][]intervals={{1,3},{6,9}};
        int[]newIntervals={2,5};
        for (int[] ints : insert(intervals, newIntervals)) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        int[][] newIntervals = new int[intervals.length+1][2];
       for (int i = 0; i < intervals.length; i++) {
           newIntervals[i] = intervals[i];
       }
       newIntervals[newIntervals.length-1] = newInterval;
       return merge(newIntervals);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int len = intervals.length;

        // 遍历不重叠的左边区间
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 遍历重叠的区间
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval); // 将合并后的新区间加入结果

        // 遍历不重叠的右边区间
        while (i < len) {
            res.add(intervals[i]);
            i++;
        }

        // 将结果转化为二维数组
        return res.toArray(new int[res.size()][]);
    }

    /*public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index=intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0]<=intervals[i][0]){
                index=i;
                break;
            }
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        int begin1=intervals[index-1][0];
        int end1=intervals[index-1][1];
        int begin2=newInterval[0];
        int end2=newInterval[1];
        int begin3=intervals[index][0];
        int end3=intervals[index][1];
        int begin,end;
        if(end1>begin2){
            end=Math.max(end1,end2);
            list.removeLast();
            list.add(new int[]{begin1,end});
        }
        if(end2>begin3){
            end=Math.max(end2,end3);
            list.removeLast();
            list.add(new int[]{begin1,end});
        }
    }*/

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
给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。

在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。

返回插入之后的 intervals。

注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。



示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。*/
