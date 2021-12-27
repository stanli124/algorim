/** 二叉树中序遍历
 *
 *
 */

package erchashu;

import java.util.ArrayList;
import java.util.List;

public class Day10_2 {



    public static void main(String[] args) {


        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

//        TreeNode node1 = new TreeNode();
        inorderTraversal(node1);
        for (Integer num : inorderTraversal(node1)){
            System.out.println(num);
        }

    }

    public static List<Integer> inorderTraversal(TreeNode root) {


        //中序遍历：先中序遍历左子树，再访问根节点，再中序遍历右子树。
        ArrayList<Integer> midOrder = new ArrayList<>();
        if (root==null) return midOrder;

        //递归调用，返回左子树和右子树的列表；
        midOrder.addAll(inorderTraversal(root.left));  //中序遍历左子树
        midOrder.add(root.val);
        midOrder.addAll(inorderTraversal(root.right));  //中序遍历左子树
        return midOrder;


    }


}
