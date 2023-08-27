import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            Queue<Integer> index = new LinkedList<>();
            while (!q.isEmpty()) {
                int size = q.size();
                StringBuilder sb = new StringBuilder();
                int countIndex = 0;
                for (int i = 0; i < size; i++) {
                    if (index.peek() == i) {
                        sb.append("0");
                        index.poll();
                    }
                    TreeNode node = q.poll();
                    sb.append(node.val);
                    if (node.left != null) q.offer(node.left);
                    else index.add(countIndex++);
                    if (node.right != null) q.offer(node.right);
                    else index.add(countIndex++);
                }
                String str1 = sb.toString();
                String str2 = sb.reverse().toString();
                sb.delete(0, sb.length());
                index.clear();
                return str1.equals(str2);
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
