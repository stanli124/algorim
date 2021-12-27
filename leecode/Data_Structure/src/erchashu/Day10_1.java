/// 二叉树的前序遍历
//   给定二叉树的root根节点，返回它节点值的前序遍历
//
// /

package erchashu;

import java.util.ArrayList;
import java.util.List;


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


public class Day10_1 {

    public static void main(String[] args) {


        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

//        TreeNode node1 = new TreeNode();
        preorderTraversal(node1);
        for (Integer num : preorderTraversal(node1)){
            System.out.println(num);
        }

    }

    public static List<Integer> preorderTraversal(TreeNode root) {


        //前序遍历：先访问根节点，再前序遍历左子树，再前序遍历右子树。
        List<Integer> firstOrder = new ArrayList<>();
        if (root==null) return firstOrder;    //若当前节点为空，没有可以访问的值，返回空的list；


        //递归调用，返回左子树和右子树的列表；
        firstOrder.add(root.val);             //不为空，则先访问根节点；
        firstOrder.addAll(preorderTraversal(root.left));  //前序遍历左子树
        firstOrder.addAll(preorderTraversal(root.right)); //前序遍历右子树
        return firstOrder;


    }

}
