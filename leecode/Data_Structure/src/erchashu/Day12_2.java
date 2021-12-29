/** 路径总和
 *  给定二叉树的根节点root和一个表示 目标和 的整数targetSum。判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。若存在则返回true，否则返回false；
 */

package erchashu;

public class Day12_2 {

    public static void main(String[] args) {
//        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null,null);
        TreeNode node1 = new TreeNode(1, node2, null);

        System.out.println(hasPathSum(node1, 1));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        return hasPathSum_(root, targetSum, 0);
    }


    public static boolean hasPathSum_(TreeNode root, int targetSum, int curSum) {
        if (root==null) return false;
        curSum = curSum + root.val;
        if (curSum == targetSum && root.left==null && root.right==null) return true;

//        hasPathSum_(root.left, targetSum, curSum);
//        hasPathSum_(root.right, targetSum, curSum);
        return hasPathSum_(root.left, targetSum, curSum) || hasPathSum_(root.right, targetSum, curSum);

    }

}
