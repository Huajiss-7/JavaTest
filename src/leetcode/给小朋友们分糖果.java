package leetcode;

public class 给小朋友们分糖果 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(5, 2));
    }

    public static int distributeCandies(int n, int limit) {
        int count=0;
        for (int i = 0; i <= limit&&n-i>=0; i++) {
            for (int j = 0; j <= limit && n - i -j>= 0; j++) {
                for(int k=0;k<=limit&&n-i-j-k>=0;k++){
                    if(i+j+k==n)count++;
                }
            }
        }
        return count;
    }

    //优化1
    public int distributeCandies1(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) {
                    break;
                }
                if (n - i - j <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //优化2
    /*枚举第一个小朋友分得 xxx 颗糖果，那么还剩下 n−xn-xn−x 颗糖果，此时有两种情况：

    n−x>limit×2n-x > \textit{limit} \times 2n−x>limit×2，至少有一个小朋友会分得大于 limit\textit{limit}limit 颗糖果，此时不存在合法方案。

    n−x≤limit×2n-x \le \textit{limit} \times 2n−x≤limit×2，对于第二个小朋友来说，至少得分得 max⁡(0,n−x−limit)\max(0, n-x-\textit{limit})max(0,n−x−limit) 颗糖果，才能保证第三个小朋友分得的糖果不超过 limit\textit{limit}limit 颗。同时至多能拿到 min⁡(limit,n−x)\min(\textit{limit}, n-x)min(limit,n−x) 颗糖果。

    对于第二种情况计算出所有的合法方案即可。*/


    public int distributeCandies2(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }

    /*方法三：容斥
    也可以采用常规计数的思想，用所有方案减去不合法的方案。使用组合数学的容斥原理，用所有的方案数减去至少有一个小朋友分得超过 limit\textit{limit}limit 颗糖果。但会重复计算至少有两个小朋友分得超过 limit\textit{limit}limit 颗糖果，因此把这部分加回来。计算这部分的时候又会重复计算三个小朋友都分得超过 limit\textit{limit}limit 颗糖果的方案，因此再减去这部分方案数。

    对于所有的方案数，因为允许小朋友分得 000 颗糖果，问题可转化为在 n+3n+3n+3 颗糖果中插两块板，使得每位小朋友至少分得一颗糖果。在 n+3n+3n+3 颗糖果中有 n+2n+2n+2 个空位，故方案数为 Cn+22C_{n+2}^2C
    n+2
            2
            ​
            ，这里使用 CCC 来表示组合数。

    至少有一个小朋友分得超过 limit\textit{limit}limit 颗糖果的方案数，可以先给任意一个小朋友分得 limit+1\textit{limit}+1limit+1 颗糖果，此时问题转化为将 n−limit−1n-\textit{limit}-1n−limit−1 颗糖果分给三个小朋友，故方案数为 C31×Cn−(limit+1)+22C_3^1 \times C_{n-(\textit{limit}+1)+2}^2C
3
        1
        ​
        ×C
    n−(limit+1)+2
            2
            ​
            。

    至少有两个小朋友分得超过 limit\textit{limit}limit 颗糖果的方案数，可以先给任意两个小朋友分得 limit+1\textit{limit}+1limit+1 颗糖果，此时问题转化为将 n−(limit+1)×2n-(\textit{limit}+1) \times 2n−(limit+1)×2 颗糖果分给三个小朋友，故方案数为 C32×Cn−(limit+1)×2+22C_3^2 \times C_{n-(\textit{limit}+1) \times 2+2}^2C
3
        2
        ​
        ×C
    n−(limit+1)×2+2
            2
            ​
            。

    至少有三个小朋友分得超过 limit\textit{limit}limit 颗糖果的方案数，可以先给三个小朋友分得 limit+1\textit{limit}+1limit+1 颗糖果，此时问题转化为将 n−(limit+1)×3n-(\textit{limit}+1) \times 3n−(limit+1)×3 颗糖果分给三个小朋友，故方案数为 Cn−(limit+1)×3+22C_{n-(\textit{limit}+1) \times 3+2}^{2}C
    n−(limit+1)×3+2
            2
            ​
            。

    最后整理方案数为 Cn+22−C31×Cn−(limit+1)+22+C32×Cn−(limit+1)×2+22−Cn−(limit+1)×3+22C_{n+2}^2 - C_3^1 \times C_{n-(\textit{limit}+1)+2}^2 + C_3^2 \times C_{n-(\textit{limit}+1) \times 2+2}^2 - C_{n-(\textit{limit}+1) \times 3+2}^2C
    n+2
            2
            ​
            −C
3
        1
        ​
        ×C
    n−(limit+1)+2
            2
            ​
            +C
3
        2
        ​
        ×C
    n−(limit+1)×2+2
            2
            ​
            −C
    n−(limit+1)×3+2
            2
            ​
            。*/
    public int distributeCandies3(int n, int limit) {
        return (int)(cal(n + 2) - 3 * cal(n - limit + 1) + 3 * cal(n - (limit + 1) * 2 + 2) - cal(n - 3 * (limit + 1) + 2));
    }

    public long cal(int x) {
        if (x < 0) {
            return 0;
        }
        return (long)x * (x - 1) / 2;
    }

    public long distributeCandies4(int n, int limit){
        return cal(n+2)-(3*cal(n-limit-1+2)-3*cal((n-2*(limit+1)+2))+cal(n-3*(limit+1)+2));
    }



}

    /*给你两个正整数 n 和 limit 。

        请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。



        示例 1：

        输入：n = 5, limit = 2
        输出：3
        解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
        示例 2：

        输入：n = 3, limit = 3
        输出：10
        解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3, 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。*/