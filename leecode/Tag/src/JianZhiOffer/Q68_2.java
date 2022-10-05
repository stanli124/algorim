package JianZhiOffer;

import java.util.*;

//找到二叉树的最近公共祖先
public class Q68_2 {

    boolean flag = false;

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        LinkedList<TreeNode> pathP = new LinkedList<>();
//        getPath(root, p, pathP);
//        LinkedList<TreeNode> pathQ = new LinkedList<>();
//        getPath(root, q, pathQ);
//        TreeNode ance = null;
//        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
//            if (pathP.get(i) == pathQ.get(i)) ance = pathP.get(i);
//            else {
//                break;
//            }
//        }
//
//        return ance;
//    }
//
//    public void getPath (TreeNode root, TreeNode target, LinkedList<TreeNode> path){
//        if (root == null)  return ;
//        if (root == target){
//            flag = true;
//        }else {
//            getPath(root.left, target,path);
//            getPath(root.right, target, path);
//        }
//        if (flag){
//            path.add(0, root);
//        }
//        return;
//    }

    //该方法使用parent来记录每个节点的父节点；然后分别访问p、q节点的祖先节点；
    //记录访问路径，如果访问到已经访问过的点，那么这个点就是最深公共祖先。
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

}
