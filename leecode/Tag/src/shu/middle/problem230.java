/** 二叉搜索树中BST中第k小的元素
 *  给定一个二叉搜索树的根节点root，和一个整数k
 *  设计一个算法查找其中第k个最小元素，从1开始计数。
 */

package shu.middle;

public class problem230 {
    int count = 0;
    int num = -1;
    public static void main(String[] args) {
        problem230 a = new problem230();

    }

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return num;
    }

    public void help(TreeNode root, int k) {
        if (k==count) { //只要已经取到第k个元素，后续的遍历就会直接返回
            return;
        }
        if (root == null) return;

        help(root.left, k);
        count++; //中序遍历是按照元素升序的顺序，第k大就是中序遍历的第k个元素
        if (count==k){ //如果已经到达第k个元素的TreeNode，则把节点值赋值给num
            num = root.val;  //
        }
        help(root.right, k);
    }


}
