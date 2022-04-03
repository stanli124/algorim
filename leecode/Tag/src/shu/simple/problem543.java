/** 二叉树的直径
 *  给定一个二叉树，计算该二叉树的直径
 *  一颗二叉树的直径长度是 任意两个结点路径长度中的最大值。
 *  这条路径可能穿过也可能不穿过根结点。
 */

package shu.simple;

public class problem543 {

    static int maxLen = 0;

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(new TreeNode(1)));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] res = {0};
        int left = traverse(root.left, res);
        int right = traverse(root.right, res);
        if (left + right > res[0]) res[0] = left + right;
        return res[0];
    }

    public static int traverse(TreeNode root, int[] res){
        if (root == null){
            return 0;
        }
        int left = traverse(root.left, res); //左子树的高度
        int right = traverse(root.right, res); //右子树的高度
        if (left + right > res[0]) res[0] = left + right;

        return left>right ? left+1:right+1; //返回高的那个树
    }


}
