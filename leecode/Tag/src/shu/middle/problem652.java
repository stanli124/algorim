/** 寻找重复的子树
 *  给定一颗二叉树，返回所有重复的子树
 *  对于同一类的重复子树，只需要返回其中任一一颗的根结点
 */

package shu.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class problem652 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(1);
        findDuplicateSubtrees(root);
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> res = new HashMap<>();
        List<TreeNode> list = new ArrayList();
        help(root, res, list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val);
        }

        return list;
    }

    public static String help(TreeNode root, HashMap<String, Integer> res, List<TreeNode> list) {
        //把当前节点和左右子树拼接起来，并放入map中。
        //如果map中有当前值则是重复子树，将其加入结果中
        if (root == null){
            return ",#";
        }
        String left = help(root.left, res, list);
        String right = help(root.right, res, list);

        StringBuilder s1 = new StringBuilder();
        s1.insert(0, right).insert(0, left).insert(0, ","+root.val);

        if (!res.containsKey(s1.toString())){
            res.put(s1.toString(), 1);
        }else {
            int value = res.get(s1.toString());
            if (value==1){
                list.add(root);
                System.out.println(s1.toString());
                res.put(s1.toString(), res.get(s1.toString())+1);
            }
        }
        return s1.toString();
    }


}
