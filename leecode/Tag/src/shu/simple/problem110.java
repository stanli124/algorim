/** 平衡二叉树
 *
 */

package shu.simple;


public class problem110 {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        isBalanced(node1);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        if (Math.abs(high(root.left) - high(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }


    public static int high(TreeNode node) {
        if (node==null) return 0;

        return 1 + Math.max(high(node.left),high(node.right));
    }

}
