/** 给定一个二叉树，找出其最小深度
 *  最小深度是从根结点到最近叶子节点的最短路径上的节点数量
 *
 */


package shu.simple;

public class problem111 {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root==null)  //当前节点为null则返回0
            return 0;

        //左右子树都不为null，则判断左子树和右子树的最小深度
        if (root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else if (root.left != null) //如果只有左子树，那么只左子树的最小深度
            return minDepth(root.left) + 1;
        else if (root.right != null) //如果只有右子树，那么只右子树的最小深度
            return minDepth(root.right) + 1;
        else //如果左右字数都为空，那么返回本层的1
            return 1;

    }

}
