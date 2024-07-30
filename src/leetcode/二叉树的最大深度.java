package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(maxDepth1(root));
    }

    //抄的
    public static int maxDepth1(TreeNode node){
        if(node==null)return 0;
        int depth= Math.max(maxDepth1(node.left),maxDepth1(node.right));
        return depth+1;
    }
    //自己写的
    public static int maxDepth(TreeNode root) {
        if(root==null)return 0;
        ArrayList<Integer>list=new ArrayList<>();
        dfs(root,1,list);
        int[]nums=list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        return nums[nums.length-1];
    }

    public static void dfs(TreeNode node, int depth, ArrayList<Integer>list){
        if(node.right==null&&node.left==null){
            list.add(depth);
            return;
        }
        if(node.left!=null){
            dfs(node.left,++depth,list);
            depth--;
        }
        if(node.right!=null){
            dfs(node.right,++depth,list);
            depth--;
        }
    }


    /*public static int maxDepth(TreeNode root) {
        int depth=0;
        int count=0;
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
            count++;
            if(temp.left==null&&temp.right==null){
                depth= Math.max(depth,count);
                count=0;
            }
        }
        return depth;
    }*/
}


   /* 给定一个二叉树 root ，返回其最大深度。

        二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。



        示例 1：





        输入：root = [3,9,20,null,null,15,7]
        输出：3
        示例 2：

        输入：root = [1,null,2]
        输出：2*/