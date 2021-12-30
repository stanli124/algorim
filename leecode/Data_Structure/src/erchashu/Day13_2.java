/** 二叉搜索树中的插入操作
 *
 *
 */

package erchashu;

public class Day13_2 {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(insertIntoBST(node1, 5));


    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;


        while (node!=null){
            if (val > node.val && node.right==null){
                node.right = new TreeNode(val);
                return root;
            }
            else if (val < node.val && node.left==null){
                node.left = new TreeNode(val);
                return root;
            }
            else if (val > node.val){
                node = node.right;
            }
            else node = node.left;;
        }

        return root;
    }

}
