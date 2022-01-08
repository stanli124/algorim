/** 将有序数组转换为二叉搜索树
 *   给定一个升序的整数数组nums，请你将其转换为一颗 高度平衡 二叉搜索树
 *   高度平衡二叉树 是 满足[每个节点的左右两个子树的高度差的绝对值不超过1]的二叉树
 */

package shuzu.simple;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class problem108 {

    public static void main(String[] args) {

        TreeNode node = sortedArrayToBST(new int[]{-10,-3,0,5,9});


    }

    public static TreeNode sortedArrayToBST(int[] nums) {
//        if (nums.length == 0) return new TreeNode();
//
//        int high = nums.length - 1;
//        int low = 0;
//
//        TreeNode root = new TreeNode();


        return insertNode(0, nums.length - 1, nums);

    }

    public static TreeNode insertNode(int left, int right, int[] nums){
//        if (high < 0 || low > nums.length-1 || low > high || node==null) return ;
//
//        int mid = (low+high) / 2;
//        insertNode(low, mid - 1, nums, node.left);
//        node.val = nums[mid];
//        if (mid > 0) node.left = new TreeNode();
//        if (mid < nums.length-1)node.right = new TreeNode();
//        insertNode(mid + 1, high, nums, node.right);

        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = insertNode(left, mid - 1, nums);
        root.right = insertNode(mid + 1, right, nums);
        return root;




    }

}
