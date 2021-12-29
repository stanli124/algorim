/** 翻转二叉树
 *
 */

package erchashu;

public class Day12_1 {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(invertTree(node1));

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root==null) return null;
        TreeNode swag;
        swag = root.left;
        root.left = root.right;
        root.right = swag;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
