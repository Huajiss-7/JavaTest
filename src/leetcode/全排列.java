package leetcode;

import java.util.*;

public class 全排列 {
    public static void main(String[] args) {
        int[]nums={1,2,3};
        System.out.println(permute(nums));
    }

    //自己写的
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();//记录答案
        List<Integer>path=new ArrayList<>();//记录当前固定了的前几位数
        boolean[]used=new boolean[nums.length];//记录哪个数用过没
        if(nums.length<1)return ans;
        dfs(nums,0,ans,path,used);//java里面都是值传递，传递对象是一个地址，传给函数的ans是一个地址，下面对ans的修改都是对地址里的内容修改，所以能保留结果
        //Set<List<Integer>>sets=new HashSet<>(ans);//nums有重复元素，去重
        //List<List<Integer>>ans1=new ArrayList<>(sets);
        return ans;
    }

    public static void dfs(int[]nums,int depth,List<List<Integer>>ans,List<Integer>path,boolean[]used){
        if(depth==nums.length){//到达最深处，全排列已经完成
            ans.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i])continue;//如果这个元素已经使用过了就跳过下一个
            List<Integer>newPath=new ArrayList<>(path);//如果直接使用path，那么所有path都指向同一个地方，会有bug
            newPath.add(nums[i]);//新的固定位
            boolean[]newUsed= new boolean[used.length];//没到底部，没被添加的used和path的作用就是继承给下一层创建新的used和path去接近底部，在过程中被继承后就被丢弃了
            System.arraycopy(used,0,newUsed,0,used.length);//同理，如果直接使用used会导致回退时出bug
            newUsed[i]=true;//标记这个数使用了
            dfs(nums,depth+1,ans,newPath,newUsed);//深度优先
        }
    }


    //抄的
    public static List<List<Integer>> permute3(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs3(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs3(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs3(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }




    public static List<List<Integer>> permute1(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs1(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs1(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                dfs1(nums, len, depth + 1, newPath, newUsed, res);
                // 2、无需回溯
            }
        }
    }
}


   /* 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



        示例 1：

        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        示例 2：

        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        示例 3：

        输入：nums = [1]
        输出：[[1]]*/