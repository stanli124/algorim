/** 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，
 *
 */

package shu.middle;

import java.util.LinkedList;
import java.util.Queue;

public class problem116 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){ //层序遍历
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) { //因为是满二叉树，所以每一层的最后一个节点一定没有右侧节点
                Node p = queue.poll(); //取出当前节点
                p.next = queue.peek();
                if (p.left!=null) queue.add(p.left);
                if (p.right!=null) queue.add(p.right);
            }
            Node p = queue.poll();
            if (p.left!=null) queue.add(p.left);
            if (p.right!=null) queue.add(p.right);
        }
        return root;
    }

}



class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}