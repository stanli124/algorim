/** 对称二叉树
 *  给定一个二叉树，检查它是否是镜像对称的
 *
 */

package erchashu;

import java.util.ArrayList;
import java.util.List;

public class Day11_3 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
        //前序遍历，翻转后，再前序遍历一次；若两次的字符串不一样就不是镜像对称的；

        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        preOrder(root, nums1);
        reverse(root);
        preOrder(root, nums2);


        return nums1.toString().equals(nums2.toString());
    }

    public static void preOrder(TreeNode node, List nums){
        if (node==null){
            nums.add(-100);
            return;
        }
        nums.add(node.val);
        preOrder(node.left, nums);
        preOrder(node.right, nums);
    }

    public static void reverse(TreeNode node){
        if (node==null) return;
        TreeNode swag;
        swag = node.left;
        node.left = node.right;
        node.right = swag;

        reverse(node.left);
        reverse(node.right);

    }

}
