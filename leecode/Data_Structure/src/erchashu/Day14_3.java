/** 二叉搜索树的最近公共祖先
 *  给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先
 *  最近公共祖先：对于有根树T的两个节点p、q最近公共祖先表示为一个节点x。满足x是p、q的祖先且x的深度尽可能大（一个节点也可以是它自己的祖先）
 */


package erchashu;

public class Day14_3 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3,null);
        TreeNode node1 = new TreeNode(1, null, node2);



    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode publicAnc = root;
        while (publicAnc != null){
            if (p.val < publicAnc.val && q.val < publicAnc.val){  //如果p和q都比当前节点的值小，则往左边移动
                publicAnc = publicAnc.left;
            }
            else if (p.val > publicAnc.val && q.val > publicAnc.val){ //如果p和q都比当前节点的值大，则往右边移动；
                publicAnc = publicAnc.right;
            }else    //如果不满足上述条件，则表明p、q之中，一个值比当前节点大，一个值比当前节点小。那么当前节点就是分叉点，也就是最近公共祖先，跳出循环
                break;
        }

        return publicAnc;
    }

}
