package leetcode;


import java.util.BitSet;

public class 引爆最多的炸弹 {
    public static void main(String[] args) {
        int[][]bombs={{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println(maximumDetonation(bombs));
    }

    public static int maximumDetonation(int[][] bombs) {
        int count=0;
        for (int i = 0; i < bombs.length; i++) {
            boolean[]visited=new boolean[bombs.length];
            int nowCount=dfs(bombs,visited,i);
            count=Math.max(count,nowCount);
        }
        return count;
    }

    private static int dfs(int[][] bombs, boolean[] visited,int index) {
        if(visited[index]){
            return 0;
        }
        visited[index]=true;
        int r=bombs[index][2];
        int count=1;// 当前炸弹自己
        for (int i = 0; i < bombs.length; i++) {
            if(!visited[i]){
                int x=Math.abs(bombs[i][0]-bombs[index][0]);
                int y=Math.abs(bombs[i][1]-bombs[index][1]);
                if(Math.pow(x,2)+Math.pow(y,2)<=Math.pow(r,2)){
                    //count++;  把count初始值赋为0，最后上面总count结果+1也行
                    count+=dfs(bombs,visited,i);
                }
            }
        }
        return count;
    }

    //抄的
    public int maximumDetonation2(int[][] bombs) {
        int n = bombs.length;
        BitSet[] f = new BitSet[n];
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            f[i] = new BitSet(n);
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    f[i].set(j); // i 可以到达 j
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (BitSet fi : f) {
                //无需继续递归是因为，假如A 可以引爆 C，C 可以引爆 B，B 可以引爆 D，D 不能引爆其他炸弹 表面上，A在经过B的时候，把B可以引爆的炸弹跳过了，但其实循环到B时，B的值已经改变把D抱进来了，所以再循环到C，通过C去包含B的值时候，就把D包含进来了
                if (fi.get(k)) { // i 可以到达 k
                    fi.or(f[k]); // i 也可以到 k 可以到达的点
                }
            }
        }

        int ans = 0;
        for (BitSet s : f) {
            ans = Math.max(ans, s.cardinality()); // 集合大小的最大值
        }
        return ans;
    }

    /*作者：灵茶山艾府
    链接：https://leetcode.cn/problems/detonate-the-maximum-bombs/solutions/1152450/jian-tu-bao-li-mei-ju-suo-you-qi-dian-by-h4mj/
    */

    //用自己的bitset
    public int maximumDetonation1(int[][] bombs) {
        int n = bombs.length;
        Bitset[] f = new Bitset[n];
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            f[i] = new Bitset(n);
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    f[i].set(j); // i 可以到达 j
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (Bitset fi : f) {
                if (fi.has(k)) { // i 可以到达 k
                    fi.or(f[k]); // i 也可以到 k 可以到达的点
                }
            }
        }

        int ans = 0;
        for (Bitset s : f) {
            ans = Math.max(ans, s.count()); // 集合大小的最大值
        }
        return ans;
    }
}

class Bitset {
    private static final int W = Long.SIZE;

    private final long[] bits;

    Bitset(int n) {
        bits = new long[(n + W - 1) / W]; // 需要 ceil(n/W) 个 W 位整数
    }

    void set(int p) {
        bits[p / W] |= 1L << (p % W);
    }

    boolean has(int p) {
        return (bits[p / W] & (1L << (p % W))) != 0;
    }

    void or(Bitset other) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] |= other.bits[i];
        }
    }

    int count() {
        int c = 0;
        for (long x : bits) {
            c += Long.bitCount(x);
        }
        return c;
    }
}


/*
给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。

炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。

你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。

给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。



示例 1：



输入：bombs = [[2,1,3],[6,1,4]]
输出：2
解释：
上图展示了 2 个炸弹的位置和爆炸范围。
如果我们引爆左边的炸弹，右边的炸弹不会被影响。
但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
示例 2：



输入：bombs = [[1,1,5],[10,10,5]]
输出：1
解释：
引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
示例 3：



输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
输出：5
解释：
最佳引爆炸弹为炸弹 0 ，因为：
        - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
        - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
        - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
所以总共有 5 个炸弹被引爆。*/
