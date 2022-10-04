package JianZhiOffer;


//二叉树的深度；给定一颗二叉树，求该树的深度
public class Q55_1 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
