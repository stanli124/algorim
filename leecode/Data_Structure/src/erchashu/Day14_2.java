/** 两数之和IV 输入BST
 *  给定一个二叉搜索树，root和一个目标结果k，如果BST中存在两个元素且它们的和等于给定的目标结果，则返回true；
 *
 */


package erchashu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day14_2 {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(findTarget(node1, 1000));

    }

    public static boolean findTarget(TreeNode root, int k) {
//        ArrayList<Integer> totalNums = new ArrayList<>();
//        qianxu(root, totalNums); //取出二叉树中所有的值；

        HashSet<Integer> subNum = new HashSet<>();
        return preOrder(root, k, subNum);  //递归实现两数之和，另外需要借助一个set保存差值；
    }

    //递归解法；迭代解法需要一个队列来存储节点；
    public static boolean preOrder(TreeNode node, int k, HashSet subNum){
        if (node==null) return false;

        if (subNum.contains(node.val)) return true;
        else subNum.add(k-node.val);

        return preOrder(node.left, k, subNum) || preOrder(node.right, k, subNum);

    }


//    public static void qianxu(TreeNode node, ArrayList nums){
//        if (node==null) return;
//
//        nums.add(node.val);
//        qianxu(node.left, nums);
//        qianxu(node.right, nums);
//
//    }




}
