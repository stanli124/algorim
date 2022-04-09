/*
 给定二叉搜索树的根节点和需要查找的值val
 返回以该值为节点的子树。
 */

package shu.simple;

public class problem700 {
    TreeNode node = null;
    public static void main(String[] args) {
        problem700 a = new problem700();
        a.node = a.searchBST(new TreeNode(1), 2);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        TreeNode treeNode = null;
        if (root.val > val){
            treeNode = searchBST(root.left, val);
        }else
            treeNode = searchBST(root.left, val);

        return treeNode;
    }

}
