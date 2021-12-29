/** 二叉树的层序遍历
 *  给你一个二叉树，请你返回其按层序遍历得到的节点值。即逐层地，从左到右访问所有节点。
 */


package erchashu;

import java.util.*;

public class Dya11_1 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(levelOrder(node1));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> list = new ArrayList<>();
        if (root==null) return list;

        Map<TreeNode, Integer> nodeToLevel = new LinkedHashMap<>();

        level(root, nodeToLevel, 0); //求所有节点及对应的层；

        int mapLen = list.size();
        for (TreeNode node : nodeToLevel.keySet()){

            if (nodeToLevel.get(node) != mapLen){ //如果没有那么多list，则添加那么多list；
                for (int i = 0; i < nodeToLevel.get(node)-mapLen; i++) {
                    list.add(new ArrayList<Integer>());
                }
                mapLen = list.size(); //如果当前node的层 在 list中没有 就新建到当前层；
            }

            list.get(nodeToLevel.get(node)-1).add(node.val);
        }

        return list;
    }

    public static void level(TreeNode node, Map map, int ceng){
        if (node==null) return;
        ceng = ceng +1;
        map.put(node, ceng);

        level(node.left, map, ceng);
        level(node.right, map, ceng);

    }


}
