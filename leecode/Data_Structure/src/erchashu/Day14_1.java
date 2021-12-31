/** 验证二叉搜索树
 *  给定一个根节点root，判断其是否是有效的二叉搜索树；
 *
 *
 */

package erchashu;

import com.sun.javafx.sg.prism.NGNode;

import java.util.ArrayList;

public class Day14_1 {


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(isValidBST(node1));
    }
    //先将所有值取出来，因为是中序遍历，所有对于二叉搜索树一定是有序的；然后对取出来的值进行遍历，若后一个值<=前一个值那么返回false；
//    public static boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> totalNums = new ArrayList();
//
//        midOrder(root, totalNums);
//        System.out.println(totalNums);
//
//        for (int i = 0; i < totalNums.size()-1; i++) {
//            if (totalNums.get(i)>=totalNums.get(i+1)) return false;
//        }
//
//        return true;
//
//    }
//
//    public static void midOrder(TreeNode node, ArrayList totalNums) {
//        if (node==null) return ;
//        midOrder(node.left, totalNums);
//        totalNums.add(node.val);
//        midOrder(node.right, totalNums);
//    }


    public static boolean isValidBST(TreeNode root) {
        midOrder(root, Integer.MIN_VALUE ,Integer.MAX_VALUE);

        return midOrder(root, Integer.MIN_VALUE ,Integer.MAX_VALUE);
    }

    public static boolean midOrder(TreeNode node, long lower, long upper) {
        if (node==null) return true;

        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return midOrder(node.left, lower, node.val) && midOrder(node.right, node.val, upper);

    }

}
