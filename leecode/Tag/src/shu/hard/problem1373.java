/** 二叉搜索子树的最大键值和
 *  给你一颗以root为根的二叉树，请你返回任意二叉搜索子树的最大键值和
 */

package shu.hard;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class problem1373 {

    class bstInfo{
        int isBST;
        int maxNum;
        int minNum;
        int sum;

        bstInfo(int isBST, int maxNum, int minNum, int sum){
            this.isBST = isBST;
            this.maxNum = maxNum;
            this.minNum = minNum;
            this.sum = sum;
        }

    }

//    int max = Integer.MIN_VALUE;
//    public static void main(String[] args) {
//
//    }
//
//    public int maxSumBST(TreeNode root){
//        help(root);
//        return max;
//    }
//
//    public int help(TreeNode root){
//        if (root == null) return 0;
//
//        int left = help(root.left);
//        int right = help(root.right);
//
//        max = left > right ? left : right;
//
//        return left + right +root.val;
//    }

    int max = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public int maxSumBST(TreeNode root){
        traverse(root);
        return max;
    }

    public bstInfo traverse(TreeNode root){
        if (root ==null) return new bstInfo(1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        bstInfo left = traverse(root.left);
        bstInfo right = traverse(root.right);

        bstInfo res = new bstInfo(0,0,0,0);

        if (left.isBST == 1 && right.isBST == 1 //左右子树都是bst
                && root.val > left.maxNum //当前节点的值 > 左子树的最大值
                && root.val < right.minNum) //当前节点的值 < 右子树的最小值
        {
            res.isBST = 1;
            res.minNum = root.val < left.minNum ? root.val : left.minNum;
            res.maxNum = root.val > right.maxNum ? root.val : right.maxNum;
            res.sum = left.sum +right.sum + root.val;
            max = Math.max(max, res.sum);
        }else {
            res.isBST = 0;
        }
        return res;
    }


}