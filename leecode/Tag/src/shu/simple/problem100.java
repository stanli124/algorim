/** 相同的树
 *  给你两颗二叉树的根节点p和q，编写一个函数来检验这两颗树是否相同。
 *  相同条件：结构相同，且相同节点具有相同的值。
 */

package shu.simple;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class problem100 {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(5);

        System.out.println(isSameTree(p, q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p==null && q!=null) || (p!=null && q==null)) return false;  //结构不同
        if (p==null && q==null) return true;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
