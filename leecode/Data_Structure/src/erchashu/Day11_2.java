/** 二叉树的最大深度
 *  给定一个二叉树，找出其最大深度
 *  二叉树的深度为根节点到最远叶节点的最长路径上的节点数
 *
 */


package erchashu;

public class Day11_2 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(maxDepth(node1));
    }

    public static int maxDepth(TreeNode root) {
//        if (root==null) return 0;
//
//        int leftDepth = 1;
//        int rightDepth = 1;
//        Integer depth = 0;
//
//        leftDepth+=maxDepth(root.left);
//        rightDepth+=maxDepth(root.right);
//        depth = leftDepth > rightDepth?leftDepth:rightDepth;
//
//        return depth;


        //省去了一个int类型的变量；
//        if (root==null) return 0;
//
//        int leftDepth = 1;
//        int rightDepth = 1;
//
//        leftDepth+=maxDepth(root.left);
//        rightDepth+=maxDepth(root.right);
//
//
//        return leftDepth > rightDepth?leftDepth:rightDepth;




        //不消耗内存
        if (root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));

    }

}
