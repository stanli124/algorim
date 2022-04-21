package shu;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的层序遍历
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

    TreeNode[] childrens = new TreeNode[10];

}


public class layerTraversal {

    public static void main(String[] args) {

    }

    void levelTraverse(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;

        while (!q.isEmpty()){
            //当前队列中的元素都是一层的
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                System.out.println("节点 " + cur + " 在第 " +  depth +" 层");

                //将下一层节点放入队列中，二叉树就只有两个节点
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            //一层打印完，增加一层
            depth++;
        }


    }


}
