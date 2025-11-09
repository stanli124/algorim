import java.util.Map;

public class DiameterBinaryTree {
    int ans;

    public static void main(String[] args) {
        DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();
    }


    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
