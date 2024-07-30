package leetcode;


import java.util.TreeMap;

//困难
public class 最小化曼哈顿距离 {
    public static void main(String[] args) {
        int [][]points={{3,10},{5,15},{10,2},{4,4}};
        System.out.println(minimumDistance(points));
    }


    //转切比雪夫距离
    //https://oi-wiki.org/geometry/distance/#%E6%9B%BC%E5%93%88%E9%A1%BF%E8%B7%9D%E7%A6%BB%E4%B8%8E%E5%88%87%E6%AF%94%E9%9B%AA%E5%A4%AB%E8%B7%9D%E7%A6%BB%E7%9A%84%E7%9B%B8%E4%BA%92%E8%BD%AC%E5%8C%96
    //对于每个点，我们分别计算它的坐标之和与坐标之差，并用有序集合维护这些值，
    // 此时任意两点曼哈顿距离的最大值即为两个集合中的最大值与该集合本身的最小值之差中取最大值。
    // 每次枚举点，从集合中删除对应的值，然后再次计算最大的曼哈顿距离，
    // 计算完成后再恢复，枚举完成后即可得到最小的曼哈顿距离。
    public static int minimumDistance2(int[][] points) {
        TreeMap<Integer, Integer> sx = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> sy = new TreeMap<Integer, Integer>();
        for (int[] p : points) {//记录每个点的坐标之和x+y和坐标之差x-y，还有有几个这样的值（判断相同值数量）
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int[] p : points) {
            sx.put(p[0] - p[1], sx.get(p[0] - p[1]) - 1);//这个值的数量-1
            if (sx.get(p[0] - p[1]) == 0) {
                sx.remove(p[0] - p[1]);//没这个值了
            }
            sy.put(p[0] + p[1], sy.get(p[0] + p[1]) - 1);
            if (sy.get(p[0] + p[1]) == 0) {
                sy.remove(p[0] + p[1]);
            }
            res = Math.min(res, Math.max(sx.lastKey() - sx.firstKey(), sy.lastKey() - sy.firstKey()));
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);//再放回来，换下一个点移除
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        return res;
    }


    //[[1,1],[7,3],[5,9],[6,4],[7,6],[6,4],[5,2],[4,2],[7,2],[1,1]]这个案例输出9，但答案是11
    public static int minimumDistance(int[][] points) {
        //先计算当前最大值对应的两点，答案应该在移除这两点的两个值之一
        //假如只有一个最大距离
        int x1=points[0][0];
        int y1=points[0][1];
        int x2=points[0][0];
        int y2=points[0][1];
        int max=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])>max){
                    x1=points[i][0];
                    y1=points[i][1];
                    x2=points[j][0];
                    y2=points[j][1];
                    max=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                }
            }
        }
        System.out.println(max);
        max=0;
        //分别移除x1,y1和x2,y2看哪个最大值更小
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if((points[i][0]==x1&&points[i][1]==y1)||(points[j][0]==x1&&points[j][1]==y1)){
                   continue;
                }
                if(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])>max){
                    max=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                }
            }
        }
        int max2=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if((points[i][0]==x2&&points[i][1]==y2)||(points[j][0]==x2&&points[j][1]==y2)){
                    continue;
                }
                if(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])>max2){
                    max2=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                }
            }
        }
        System.out.println(max);
        System.out.println(max2);
        System.out.println("----------");
        return Math.min(max,max2);
    }
}


/*
给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。

两点之间的距离定义为它们的
        曼哈顿距离
。

请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。



示例 1：

输入：points = [[3,10],[5,15],[10,2],[4,4]]
输出：12
解释：移除每个点后的最大距离如下所示：
        - 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
        - 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
        - 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
        - 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
示例 2：

输入：points = [[1,1],[1,1],[1,1]]
输出：0
解释：移除任一点后，任意两点之间的最大距离都是 0 。*/
