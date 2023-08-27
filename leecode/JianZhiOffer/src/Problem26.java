import java.util.LinkedList;
import java.util.Queue;

public class Problem26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null) {
                return false;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(A);
            while (!q.isEmpty()) {
                int size = q.size();
                TreeNode pollNode = q.poll();
                boolean isSubStructure = false;
                if (pollNode.val == B.val) {
                    isSubStructure = recur(pollNode, B);
                }
                if (isSubStructure) {
                    return true;
                }
                if (pollNode.left != null) q.offer(pollNode.left);
                if (pollNode.right != null) q.offer(pollNode.right);
            }
            return false;
        }

        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null || B.val != A.val) {
                return false;
            }
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }


//    class Solution {
//        public boolean isSubStructure(TreeNode A, TreeNode B) {
//            if (B == null) {
//                return false;
//            }
//            StringBuilder a = new StringBuilder();
//            StringBuilder b = new StringBuilder();
//            preOrder(A, a);
//            preOrder(B, b);
//            return a.toString().contains(b.toString());
//        }
//
//        public void preOrder(TreeNode node, StringBuilder path){
//            if (node == null) {
//                return;
//            }
//            path.append(node.val);
//            preOrder(node.left, path);
//            preOrder(node.right, path);
//        }
//
//    }

    public static void main(String[] args) {

    }
}
