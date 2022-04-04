/** 最大二叉树
 *  给定一个不重复的整数数组 nums。
 *  1. 创建也给根节点，其值为nums中的最大值
 *  2. 递归的在最大值左边的 子数组前缀上 构建左子树
 *  3. 递归地在最大值右边的 子数组前缀上 构建右子树
 */

package shu.middle;

public class problem654 {


    public static void main(String[] args) {

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = Integer.MIN_VALUE;
        return construct(nums, 0, nums.length - 1);
    }

    public static TreeNode construct(int[] nums, int low, int high) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        if (low > high){
            return null;
        }
        for (int i = low; i <= high; i++) { //在给定数组范围内，找到最大值
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max); //以最大值为根，创建节点；
        root.left = construct(nums, low, index-1); //递归的对根结点的左子树进行该操纵
        root.right = construct(nums, index+1, high); //递归的对根结点的右子树进行该操纵
        return root; //返回当前根节点
    }


}
