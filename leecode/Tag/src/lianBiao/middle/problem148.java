package lianBiao.middle;

import java.util.List;
import java.util.PriorityQueue;

public class problem148 {

    public static void main(String[] args) {

        ListNode a = new ListNode(4);
        a.next = new ListNode(2);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(3);
        ListNode b = sortList(a);

        while (b!=null){
            System.out.printf(b.val+" ");
            b = b.next;
        }

    }

    public static ListNode sortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;

        PriorityQueue<ListNode> asec = new PriorityQueue<>((node1, node2)->{
            return  node1.val - node2.val;
        });

        while (head!=null){
            asec.offer(head);
            head = head.next;
        }

        while (!asec.isEmpty()){ //不为空重新赋值
            ListNode cur = asec.poll();
            cur.next = null;
            pre.next = cur;
            pre = cur;
        }

        return dummy.next;
    }


}
