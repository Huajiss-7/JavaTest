package leetcode;

import java.util.Stack;

public class 对称二叉树 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;//在上面的基础上再判断
        Stack<TreeNode> left = new Stack<>();
        left.push(root.left);
        Stack<TreeNode> right = new Stack<>();
        right.push(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.pop();
            TreeNode r = right.pop();
            if (l.val == r.val) {
                if (l.right != null && r.left != null) {
                    left.push(l.right);
                    right.push(r.left);
                }
                if (l.left != null && r.right != null) {
                    left.push(l.left);
                    right.push(r.right);
                }
                if ((l.right == null && r.left != null) || (l.right != null && r.left == null)) return false;
                if ((l.left == null && r.right != null) || (l.left != null && r.right == null)) return false;
            } else return false;
        }
        return true;
    }


    //递归方法
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    static boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}

  /*  给你一个二叉树的根节点 root ， 检查它是否轴对称。



        示例 1：


        输入：root = [1,2,2,3,4,4,3]
        输出：true
        示例 2：


        输入：root = [1,2,2,null,3,null,3]
        输出：false*/
