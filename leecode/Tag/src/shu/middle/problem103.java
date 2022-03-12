/** 二叉树的锯齿形层序遍历
 *  给定义一个二叉树的根节点root
 */

package shu.middle;

import java.util.*;

public class problem103 {

    public static void main(String[] args) {

    }

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<Integer> layer = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (queue.size()!=0){ //这里会得到按层序遍历的结果，中间没有孩子节点的用-1代替
//            TreeNode node = queue.poll();
//            layer.add(node.val);
//            if (node.left != null) queue.offer(node.left);
//            else layer.add(-1);
//
//            if (node.right != null) queue.offer(node.right);
//            else layer.add(-1);
//
//        }
//
//        int start = 0; //起始位置
//        char c = 'l';
//        int len = 0;
//        for (int i = 1; len < layer.size(); i = i * 2) {
//            List<Integer> one_layer = new ArrayList<>();
//            int count = 0;
//
//            if (c == 'l'){
//                while (count < i){
//                    if (layer.get(start) == -1){
//                        ++start;
//                        ++count;
//                        continue;
//                    }
//                    one_layer.add(layer.get(start++));
//                    ++count;
//                }
//                len += count;
//                res.add(new ArrayList<>(one_layer));
//                c = 'r';
//            }
//            else if (c == 'r'){
//                start = start + i -1; //从右边开始加
//                while (count < i){
//                    if (layer.get(start) == -1){
//                        --start;
//                        ++count;
//                        continue;
//                    }
//                    one_layer.add(layer.get(start--));
//                    ++count;
//                }
//                len += count;
//                res.add(new ArrayList<>(one_layer));
//                c = 'l';
//            }
//
//            start = (int)Math.pow(2, i) - 1;
//
//        }
//        return res;
//    }
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    if (root == null) {
        return ans;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    boolean isOrderLeft = true;

    while (!nodeQueue.isEmpty()) {
        Deque<Integer> levelList = new LinkedList<Integer>();//双端队列保存，如果是从左到右就尾部添加；如果是从右到左边，就从头部添加，就变成逆序的了。
        int size = nodeQueue.size(); //每一层的数量，这样就可以控制每一层添加几个节点值
        for (int i = 0; i < size; ++i) {
            TreeNode curNode = nodeQueue.poll();
            if (isOrderLeft) {
                levelList.offerLast(curNode.val); //从左到右，尾部添加
            } else {
                levelList.offerFirst(curNode.val); //从右到左，头部添加
            }
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
            }
            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
            }
        }
        ans.add(new LinkedList<Integer>(levelList));
        isOrderLeft = !isOrderLeft;
    }
    return ans;
}
}
