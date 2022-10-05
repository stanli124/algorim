package JianZhiOffer;

//二叉搜索树的最公共祖先

import java.util.ArrayList;
import java.util.List;

public class Q68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ance = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) ance = pathP.get(i);
            else {
                break;
            }
        }

        return ance;
    }

    public List<TreeNode> getPath (TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target){
            path.add(node);
            if (node.val < target.val){
                node = node.right;
            }else {
                node = node.left;
            }
        }
        path.add(node);
        return path;
    }

}
