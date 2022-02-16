/** 两两交换链表中的节点
 *  给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 */

package lianBiao.middle;

public class problem24 {

    public static void main(String[] args) {

    }
    //自己写的迭代解法
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(-1, head);
        ListNode curNode = sentinel, preNode = null;

        while(curNode.next != null && curNode.next.next != null){
            ListNode swapNode = curNode.next.next.next;
            preNode = curNode.next;

            curNode.next = preNode.next;
            curNode = preNode.next;
            preNode.next = null;
            curNode.next = preNode;
            preNode.next = swapNode;

            curNode = preNode;

        }
        return sentinel.next;
    }

    //递归解法
    /** 返回值：交换完成的子链表
     *  递归函数：交换当前两个节点，并连接子链表；head和next为需要交换的两个节点，head连接交换完成的子链表，next连接head，则当前交换完成
     *  终止条件：head为空指针或者next为空指针，无法进行交换。
     */
//    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
//        return next;
//    }

}




