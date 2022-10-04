package JianZhiOffer;

//平衡二叉树，给定一个二叉树，判断该二叉树是不是平衡二叉树
public class Q55_2 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        return Math.abs(treeHight(root.left)-treeHight(root.right))<=1&&isBalanced(root.right) && isBalanced(root.left) ;
    }

    public int treeHight(TreeNode node){
        if (node == null) return 0;
        int l = treeHight(node.left);
        int r = treeHight(node.right);
        return Math.max(l, r) + 1;
    }

}
