/*
 给定二叉搜索树的根节点和要插入树中的值val，将该值插入二叉搜索树，返回插入后二叉搜索树的根节点

 */

package shu.middle;

public class problem701 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) {
            return new TreeNode(val);
        }
        help(root, val);
        return root;
    }

    public TreeNode help(TreeNode root, int val) {
        if (root==null) return null;

        if (root.val > val){
            TreeNode treeNode = help(root.left, val);
            if (treeNode == null){
                root.left = new TreeNode(val);
            }
        }
        if (root.val < val){
            TreeNode treeNode = help(root.right, val);
            if (treeNode == null){
                root.right = new TreeNode(val);
            }
        }
        return root;
    }


}
