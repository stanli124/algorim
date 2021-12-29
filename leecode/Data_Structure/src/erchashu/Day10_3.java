/** 二叉树后续遍历
 *
 */

package erchashu;

import java.util.ArrayList;
import java.util.List;

public class Day10_3 {

    public static void main(String[] args) {


        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

//        TreeNode node1 = new TreeNode();
        postorderTraversal(node1);
        for (Integer num : postorderTraversal(node1)){
            System.out.println(num);
        }

    }

    public static List<Integer> postorderTraversal(TreeNode root) {


        //后序遍历：先后序遍历左子树，再后序遍历右子树，最后访问根节点。
        ArrayList<Integer> lastOrder = new ArrayList<>();
        if (root==null) return lastOrder;

        //递归调用，返回左子树和右子树的列表；
        lastOrder.addAll(postorderTraversal(root.left));  //添加后序遍历左子树的值
        lastOrder.addAll(postorderTraversal(root.right));  //添加后序遍历左子树的值
        lastOrder.add(root.val);   //最后访问根节点
        return lastOrder;
    }


}
