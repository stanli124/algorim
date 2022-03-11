/** 恢复二叉搜索树
 * 给你二叉搜索树的根节点root，该树中的恰好两个节点的值被错误的交换。
 * 请在不改变其结构的情况下，恢复这棵树
 */

package shu.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem99 {

    public static void main(String[] args) {
    }

    //超出时间限制
//    public static void recoverTree(TreeNode root) {
//        List<Integer> vals = new ArrayList<>();
//        midBianli(root, vals);
//
//        int error_num_1 = 0;
//        int error_num_2 = 0;
//        int inx = 1;
//
//        while (inx < vals.size()){
//            if (vals.get(inx) >= vals.get(inx-1)) continue;
//            else {
//                error_num_1 = vals.get(inx - 1);
//                error_num_2 = vals.get(inx);
//                break;
//            }
//        }
//
//        exchange(error_num_1, error_num_2, root);
//    }
//
//    public static void exchange(int num1, int num2, TreeNode root){
//        boolean flag1 = false;
//        boolean flag2 = false;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while (q.size() != 0){
//            TreeNode node = q.poll();
//            if (node.val == num1){
//                node.val = num2;
//                flag1 = true;
//            }
//            if (node.val == num2){
//                node.val = num1;
//                flag2 = true;
//            }
//            if (flag1 && flag2){
//                break;
//            }
//            if (node.left!=null) q.offer(node.left);
//            if (node.right!=null) q.offer(node.right);
//        }
//
//    }
//
//    public static void midBianli(TreeNode node, List<Integer> vals){
//        if (node == null) return;
//
//        midBianli(node.left, vals);
//        vals.add(node.val);
//        midBianli(node.right, vals);
//
//    }

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }






}
