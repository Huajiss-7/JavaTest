package leetcode;

import java.util.Arrays;

public class 你可以工作的最大周数 {
    public static void main(String[] args) {
        int[] milestones = {9, 3, 6, 8, 2, 1};
        System.out.println(numberOfWeeks1(milestones));
    }


    public static long numberOfWeeks1(int[] milestones) {
        long sum = 0;
        long max = 0;

        // Calculate the total number of tasks and find the maximum number of tasks in a single project
        for (int milestone : milestones) {
            sum += milestone;
            if (milestone > max) {
                max = milestone;
            }
        }

        // If the maximum number of tasks in a single project exceeds the sum of all other tasks + 1
        if (max > sum - max + 1) {
            return 2 * (sum - max) + 1;
        } else {
            return sum;
        }
    }

    /*计算所有任务的总数。
    计算最大的单个项目任务数。
    如果最大的单个项目任务数超过所有其他项目任务数之和 + 1，则返回 2 * (sum - max) + 1，否则返回 sum。
    sum：所有任务的总数。
    max：单个项目中的最大任务数。
    如果 max 大于 sum - max + 1，表示这个最大的项目任务数超过了所有其他项目任务数之和再加 1，那么我们最多可以完成 2 * (sum - max) + 1 周。否则，我们可以完成所有任务，即 sum 周。*/


    //有bug，代码逻辑不对9,3,6,8,2,1应该全部能做完的，这个逻辑剩中间两个没法做完了
    public static long numberOfWeeks(int[] milestones) {
        if (milestones.length == 1) return 1;
        Arrays.sort(milestones);
        long weeks = 0;
        int begin = 0;
        int end = milestones.length - 1;
        int endPos = 2;//从end开始执行为2
        while (begin < end) {
            if (endPos == 2) {
                if (milestones[begin] < milestones[end]) {
                    milestones[end] -= milestones[begin] + 1;
                    weeks += milestones[begin] * 2 + 1;
                    begin++;
                    endPos = 1;
                    continue;
                }
                if (milestones[begin] > milestones[end]) {
                    milestones[begin] -= milestones[end];
                    weeks += milestones[end] * 2;
                    end--;
                    endPos = 2;
                    continue;
                }
                if (milestones[begin] == milestones[end]) {
                    weeks += milestones[end] * 2;
                    begin++;
                    end--;
                }
            }
            if (endPos == 1) {
                if (milestones[begin] < milestones[end]) {
                    milestones[end] -= milestones[begin];
                    weeks += milestones[begin] * 2;
                    begin++;
                    endPos = 1;
                    continue;
                }
                if (milestones[begin] > milestones[end]) {
                    milestones[begin] -= milestones[end] + 1;
                    weeks += milestones[end] * 2 + 1;
                    end--;
                    endPos = 2;
                    continue;
                }
                if (milestones[begin] == milestones[end]) {
                    weeks += milestones[end] * 2;
                    begin++;
                    end--;
                }
            }
        }
        return weeks;
    }
}

    /*给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶段任务数量。

        你可以按下面两个规则参与项目中的工作：

        每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。
        在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。
        一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段任务。

        返回在不违反上面规则的情况下你 最多 能工作多少周。



        示例 1：

        输入：milestones = [1,2,3]
        输出：6
        解释：一种可能的情形是：
        - 第 1 周，你参与并完成项目 0 中的一个阶段任务。
        - 第 2 周，你参与并完成项目 2 中的一个阶段任务。
        - 第 3 周，你参与并完成项目 1 中的一个阶段任务。
        - 第 4 周，你参与并完成项目 2 中的一个阶段任务。
        - 第 5 周，你参与并完成项目 1 中的一个阶段任务。
        - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
        总周数是 6 。
        示例 2：

        输入：milestones = [5,2,1]
        输出：7
        解释：一种可能的情形是：
        - 第 1 周，你参与并完成项目 0 中的一个阶段任务。
        - 第 2 周，你参与并完成项目 1 中的一个阶段任务。
        - 第 3 周，你参与并完成项目 0 中的一个阶段任务。
        - 第 4 周，你参与并完成项目 1 中的一个阶段任务。
        - 第 5 周，你参与并完成项目 0 中的一个阶段任务。
        - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
        - 第 7 周，你参与并完成项目 0 中的一个阶段任务。
        总周数是 7 。
        注意，你不能在第 8 周参与完成项目 0 中的最后一个阶段任务，因为这会违反规则。
        因此，项目 0 中会有一个阶段任务维持未完成状态。*/