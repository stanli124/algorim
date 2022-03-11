/** 左叶子之和
 *  给定二叉树的根节点root，返回所有左叶子之和
 *
 */

package shu.simple;

import java.util.ArrayList;
import java.util.List;

public class problem404 {

    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        compute('g', root, l);
        int sum = 0;

        for (int i = 0; i < l.size(); i++) {
            sum+=l.get(i);
        }

        return sum;
    }

    public void compute(char l_or_r, TreeNode node, List<Integer> l){
        if (node==null) return;
        if (node.left==null && node.right==null){
            if (l_or_r == 'l') l.add(node.val);
        }
        compute('l', node.left, l);
        compute('r', node.right, l);
    }


}
