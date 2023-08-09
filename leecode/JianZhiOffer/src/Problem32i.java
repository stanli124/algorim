import java.util.*;

public class Problem32i {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            List<Integer> res = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                res.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            int[] ans = new int[res.size()];
            int index = 0;
            Iterator<Integer> iterator = res.iterator();
            while (iterator.hasNext()){
                ans[index] = iterator.next();
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Problem32i problem32i = new Problem32i();
        Solution solution = problem32i.new Solution();
        solution.levelOrder(problem32i.new TreeNode(1));
    }

}
