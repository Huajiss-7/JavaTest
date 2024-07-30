
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int height;

    public TreeNode(int data) {
        this.data = data;
        this.height = 1;
    }
}

public class 初见二叉树 {
    private TreeNode root;

    // 获取节点的高度
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 计算平衡因子
    private int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // 执行右旋
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // 执行右旋
        x.right = y;
        y.left = T2;

        // 更新高度
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // 插入节点
    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // 如果存在相同的值，可以选择如何处理，这里简化为不插入
            return node;
        }

        // 更新高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // 计算平衡因子
        int balance = getBalanceFactor(node);

        // 如果不平衡，则进行相应的平衡操作
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // 其他平衡操作可以在这里添加

        return node;
    }

    public static void main(String[] args) {
        初见二叉树 avlTree = new 初见二叉树();
        avlTree.root = avlTree.insert(avlTree.root, 10);
        avlTree.root = avlTree.insert(avlTree.root, 20);
        avlTree.root = avlTree.insert(avlTree.root, 30);

        // 在此之后进行其他操作或检查平衡性
    }
}

