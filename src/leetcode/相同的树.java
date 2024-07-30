package leetcode;

import java.util.Stack;

public class 相同的树 {
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q=new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        Stack<TreeNode>sp=new Stack<>();
        sp.push(p);
        Stack<TreeNode>sq=new Stack<>();
        sq.push(q);
        while (!sp.isEmpty()&&!sq.isEmpty()){
            TreeNode p1=sp.pop();
            TreeNode q1=sq.pop();
            if(p1.val==q1.val){
                if(p1.right!=null&&q1.right!=null){
                    sp.push(p1.right);
                    sq.push(q1.right);
                }
                if(p1.left!=null&&q1.left!=null){
                    sp.push(p1.left);
                    sq.push(q1.left);
                }
                if((p1.right==null&&q1.right!=null)||(p1.right!=null&&q1.right==null))return false;
                if((p1.left==null&&q1.left!=null)||(p1.left!=null&&q1.left==null))return false;
            }
            else return false;
        }
        return true;
    }
}

  /*  给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。



        示例 1：


        输入：p = [1,2,3], q = [1,2,3]
        输出：true*/
