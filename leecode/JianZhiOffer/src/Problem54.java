import java.util.ArrayList;
import java.util.List;

public class Problem54 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int kthLargest(TreeNode root, int k) {
            List<Integer> integers = new ArrayList<>();
            if (root == null) return 0;
            midOrder(integers, root);
            return integers.get(integers.size() - k);
        }

        public void midOrder(List<Integer> res, TreeNode node) {
            if (node == null) {
                return;
            }
            midOrder(res, node.left);
            res.add(node.val);
            midOrder(res, node.right);
        }

    }
    public static void main(String[] args) {

    }

}
