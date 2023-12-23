package JianZhiOffer;



import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Q54 {

    public static void main(String[] args) {

    }

    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<TreeNode> tb = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        Queue<TreeNode> s =new LinkedList<>();
        s.offer(root);

        if (root == null) return -1;

        while (!s.isEmpty()){
            TreeNode node = s.poll();
            tb.offer(node);
            if (node.left != null) s.offer(node.left);
            if (node.right != null) s.offer(node.right);
        }

        for (int i = 1; i <= k; i++) {
            if (i==k) return tb.poll().val;
            tb.poll();
        }

        return -1;
    }

}
