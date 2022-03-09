/** 不同的二叉搜索树2
 *  给你一个整数n，请你生成并返回所有由n个节点组成且节点值从1到n 互不相同的 不同二叉搜索树。
 *  可以按任意顺序返回答案；
 */
//用回溯每次都生成一个二叉搜索树
//每次都有两个选择，在左子树插入，或者在右子树插入。

package lianBiao.middle;


import java.util.ArrayList;
import java.util.List;

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


public class problem95 {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> root_collections = new ArrayList<>();
        boolean[] used = new boolean[n+1];  //默认初始化为false;
        TreeNode track = new TreeNode(-1);
        TreeNode head = track;

        trackback(n, track, 0, root_collections, used, head);

        return root_collections;
    }

    public static void bianli(TreeNode head, TreeNode root){
        if (head==null) return;
        if (head.left != null){
            root.left = new TreeNode(head.left.val);
            bianli(head.left, root.left);
        }
        if (head.right != null){
            root.right = new TreeNode(head.right.val);
            bianli(head.right, root.right);
        }

    }

    public static void trackback(int n, TreeNode track, int count, List<TreeNode> rc, boolean[] used, TreeNode head) {
        //count用来指示当前已经添加了多少个节点了

        if(count == n){
            TreeNode root = new TreeNode(head.right.val);
            rc.add(root);//因为地址是一样的，所以在这里应该从头结点开始，重新赋一个二叉树，地址值不同。
            bianli(head.right, root);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            if (i > track.val){ //
                track.right = new TreeNode(i);
                used[i] = true;
                trackback(n, track.right, count+1, rc, used, head);
                track.right = null;
                used[i] = false;
            }else {
                track.left = new TreeNode(i);
                used[i] = true;
                trackback(n, track.left, count+1, rc, used, head);
                track.left = null;
                used[i] = false;
            }
        }
    }

}
