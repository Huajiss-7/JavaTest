package leetcode;

import java.util.*;

public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode tree1 = new TreeNode(1);
        List<Integer> l = preorderTraversal(tree);
        for (Integer i : l) {
            System.out.println(i);
        }
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();//如果使用全局静态的list，在一次运行的多次调用时，会累加结果，导致bug
        if (root == null) return list;
        list.add(root.val);
        if (root.left != null) list.addAll(preorderTraversal(root.left));
        if (root.right != null) list.addAll(preorderTraversal(root.right));
        return list;
    }

    //非递归前序遍历
    public static void preOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }


    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current.left != null) {
                stack.push(current.left);
                current.left = null; // 标记左子树已访问过  当再次从栈里出来时候就已经代表这是最左的节点了
            } else {
                list.add(current.val);
                stack.pop();
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
        }
        return list;
    }

    //只需调整入栈顺序即可实现三种遍历
    public static List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<Object> stack = new LinkedList<>();
        if(root == null) return res;
        stack.push("WHITE");
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = (TreeNode)stack.pop();
            String color = (String)stack.pop();
            if (node == null) continue;
            if(color == "WHITE"){
                stack.push("WHITE");
                stack.push(node.right);
                stack.push("GRAY");
                stack.push(node);
                stack.push("WHITE");
                stack.push(node.left);
            }else{
                res.add(node.val);
            }
        }
        return res;
    }

    //不用修改原树
    //gpt写的好像不对
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();
            if (current.right == null || current.right == prev) {
                result.add(current.val);
                stack.pop();
                prev = current;
                current = null;
            } else {
                current = current.right;
            }
        }

        return result;
    }
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
