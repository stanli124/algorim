public class Problem55ii {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean balanced = isBalanced(root.left);
            boolean balanced1 = isBalanced(root.right);
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1 && balanced && balanced1;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    public static void main(String[] args) {

    }
}
