/*
    给定一个二叉树，找到该二叉树中两个指定节点的最近公共祖先。
 */
package shu.middle;

public class problem236 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        StringBuilder sb = new StringBuilder();
        lowestCommonAncestor(root, p, q, sb);
        return root;
    }

    public void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, StringBuilder sb){

    }

}
