/** 根节点到叶节点数字之和
 *  给你一个二叉树的根节点root，树中每个节点都存放有一个0-9之间的数字。
 *  每条从根节点到叶节点的路径都代表一个数字：例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123
 *  计算从根节点到叶节点生成的 所有数字之和。
 */

package shu.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


public class problem129 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(sumNumbers(node1));
    }

    //需要传入当前树的深度，用来计算数字
//    public static int sumNumbers(TreeNode root) {
//        int sums = 0;
//        ArrayDeque<TreeNode> que = new ArrayDeque<>();
//        que.offer(root);
//
//
//        while (que.size()!=0){
//            ArrayList<Integer> nums = new ArrayList<>();
//            TreeNode node = que.removeFirst(); //拿到第一个节点
//            if (node.)
//        }
//
//
//        return sums;
//    }
//
//    public static void nums(TreeNode node, int deepth){
//       if (node == null) {
//           return;
//       }
//
//       nums(node.left, deepth+1);
//       nums(node.right, deepth+1);
//
//       if (node.left==null && node.right==null){
//
//       }
//
//    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int prevSum) {
        if (root == null) {  //当前节点为空返回0
            return 0;
        }
        int sum = prevSum * 10 + root.val; //当前节点不是null，则计算值；
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
