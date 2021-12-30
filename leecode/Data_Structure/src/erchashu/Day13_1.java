/** 二叉搜索树中的搜索
 *  给定二叉搜索树BST的根节点和一个值。需要在BST中找到节点值等于给定值的节点。返回以该节点为根的子树。如果节点不存在，则返回null；
 *
 *  BST：左子树节点的值都比当前根节点的值小，右子树的值都比当前根节点的值大；对于BST的每一个节点node，左子树和右子树都是BST；
 */

package erchashu;

import java.util.LinkedList;
import java.util.Queue;

public class Day13_1 {


    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

//        System.out.println(searchBST(node1, 3).val);


    }

    public static TreeNode searchBST(TreeNode root, int val) {

        //使用队列保存节点值；
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode node;
//
//        if (root==null) return null;
//        if (root.val==val) return root;
//
//        queue.offer(root);
//
//        while (queue.peek()!=null){
//            node = queue.poll();
//            if (node.val == val) return node;
//            if (node.left!=null) queue.offer(node.left);   //左边节点不为空，则入队；
//            if (node.right!=null) queue.offer(node.right); //右边节点不为空，则入队；
//        }
//        return null;


        //
        if (root==null) return null;
        while (root!=null){
            if (val == root.val)  return root;
            if (val < root.val)  root = root.left;
            if (val > root.val)  root = root.right;
        }
        return root;

    }

}
