/** 二叉树展开为链表
 *  给定一个二叉树，将其展开为一个单链表
 *  该展开单链表中的每个right指针指向像一个node，left指针始终为空。
 */

package shu.middle;

public class problem114 {

    public static void main(String[] args) {

    }

    //1.先调用函数，将当前节点左右子树拉平
    //2.将当前节点的右子树接到左子树最后一个元素的右方，然后将整个左子树作为右子树。
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left; //左子树已经被拉平
        TreeNode r = root.right; //右子树也已经被拉平

        root.left = null; //当前节点的左子树置为null
        root.right = l; //当前节点的右子树，换为左子树

        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = r;
    }


}
