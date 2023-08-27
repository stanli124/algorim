import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem32iii {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 奇数行直接按照顺序加入list
         * 偶数行使用头插法加入list
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int dirrection = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> layerNodes = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode pollNode = q.poll();
                    if (dirrection % 2 == 0){ // 偶数行
                        layerNodes.add(0, pollNode.val);
                    } else { // 奇数行
                        layerNodes.add(pollNode.val);
                    }
                    if (pollNode.left != null) {
                        q.add(pollNode.left);
                    }
                    if (pollNode.right != null) {
                        q.add(pollNode.right);
                    }
                }
                dirrection++;
                if (dirrection == 3) {
                    dirrection = dirrection % 3 +1;
                }
                res.add(layerNodes);
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }


}
