/** 旋转链表
 *  给定一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置
 */

package lianBiao.middle;

public class problem61 {
    public static void main(String[] args) {
        System.out.println();
    }
    //自己的解法
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) return head;
        ListNode preNode = null;
        ListNode curNode = head;
        int len = 0;
        //求得链表的长度
        while(curNode != null){
            len++;
            curNode = curNode.next;
        }
        //计算最终位置
        int position = k % len;
        if(len==1 || position==0) return head; //当只有一个节点和向右走的步数和长度重合时，直接返回节点
        // System.out.println(position);
        // System.out.println(len);
        // System.out.println(k);
        //找到最终位置，并将前一个节点到最终位置的连接切断防止产生环。
        preNode = head;
        position = len - position;
        for(; position > 1; position--){
            preNode = preNode.next;
        }
        curNode = preNode.next;
        preNode.next = null;

        preNode = curNode;//最终的头节点
        //拼接最终结果,while循环移动至最后一个节点
        while(curNode != null){
            if(curNode.next==null)
                break;
            curNode = curNode.next;
        }
        curNode.next = head;
        return preNode;
    }
    //官方解法
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null) {
                return head;
            }
            int n = 1;
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                n++;
            }//n是计算链表的长度
            int add = n - k % n;//计算最终节点的位置
            if (add == n) { //若移动长度等于链表的长度那么相当于没有移动，直接返回
                return head;
            }
            iter.next = head; //连接链表首尾，形成环；
            while (add-- > 0) { //找到新的头节点
                iter = iter.next;
            }
            ListNode ret = iter.next; //断开环
            iter.next = null;
            return ret;
        }
    }


}
