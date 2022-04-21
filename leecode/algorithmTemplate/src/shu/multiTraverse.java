package shu;


//多叉树层序遍历

import java.util.LinkedList;
import java.util.Queue;

public class multiTraverse {
    public static void main(String[] args) {

    }

    void  levelTraverse(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;

        while (!q.isEmpty()){
            int size = q.size();

            //从左到右遍历每一层的每个节点
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                System.out.println("节点 " + cur + " 在第 " +  depth +" 层");

                //多叉树每个节点都可能有多个节点，childrens表示当前的节点的所有孩子
                for (TreeNode child : cur.childrens){
                    q.offer(child);
                }
            }
            //下一层的深度
            depth++;


        }


    }


}
