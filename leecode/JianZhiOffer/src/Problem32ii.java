import java.util.*;

public class Problem32ii {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            List<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> layer = new ArrayList<>();
            while (!q.isEmpty()) {
                int layerNums = q.size();
                while (layerNums > 0) {
                    TreeNode node = q.poll();
                    layer.add(node.val);
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    layerNums--;
                }
                res.add(new ArrayList<>(layer));
                layer = new ArrayList<>();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Problem32i problem32i = new Problem32i();
        Problem32i.Solution solution = problem32i.new Solution();
        solution.levelOrder(problem32i.new TreeNode(1));
    }
}
