/** 从前序和中序遍历构造二叉树
 *  给定两个整数数组 preorder和inorder
 */

//我的想法是使用递归，构造两个辅助函数，一个用来计算当前传入数组的根节点，一个根据找到的根节点返回中序数组中的索引，将其分为左子树和右子树。

package shu.middle;

import java.util.ArrayList;
import java.util.Arrays;

public class problem105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len==1) return new TreeNode(preorder[0]);

        int curRootNum = findRoot(preorder, 0, len); //找到当前根节点
        int midNodeIndex = split(inorder, curRootNum, 0, len); //
        TreeNode root = new TreeNode(curRootNum); //构造根节点
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, len), Arrays.copyOfRange(inorder, 0, midNodeIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 2, len), Arrays.copyOfRange(inorder, midNodeIndex, len));

        return root;
    }

    public int split(int[] nums, int curRootNum, int l ,int r){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curRootNum) return i;
        }
        return -1;
    }

    public int findRoot(int[] nums, int l, int r){
        return nums[0];
    }


}
