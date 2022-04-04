/** 从中序遍历和后序遍历构造二叉树
 *  给定两个整数数组 inorder 和 postorder
 *  inorder是中序遍历序列，postorder是后续遍历序列
 *  请构造并返回这颗二叉树
 */

package shu.middle;

public class problem106 {

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length-1);
        return root;
    }

    public static TreeNode build(int[] inorder, int inStart, int inEnd,
                                 int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd) return null;

        int rootvalue = postorder[postEnd]; //得到根的值
        int index = -1;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootvalue) {
                index=i; //从中序找到左右子树的分解点
                break;
            }
        }

        TreeNode root = new TreeNode(rootvalue);
        root.left = build(inorder, inStart, index-1,
                postorder, postStart,postStart+index-inStart-1);
        root.right = build(inorder, index+1, inEnd,
                postorder, postStart + (index-inStart), postEnd-1);

        return root;
    }

}
