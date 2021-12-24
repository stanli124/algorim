/** 环形链表
 *  给你一个链表的头节点 head ，判断链表中是否有环。
 *  单链表有环的话，只能是从尾部指向链表中间的某个节点；
 *
 *  也就是说如果，尾部只要不为空就代表有环？
 */

package lianbiao;

import java.util.HashSet;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + this.next +
                '}';
    }
}


public class Day7_1 {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next= second;


        System.out.println(hasCycle(first));


    }

    public static boolean hasCycle(ListNode head) {
//        //遍历方法
//        if (head==null) return false;                         //如果链表为空则返回false，空链表肯定没有环；
//        Set<Integer> hashCode = new HashSet<>();
//        for (ListNode x = head; x.next!=null; x=x.next) {
////            if (x.next == null) return false;
//            if (!hashCode.add(x.hashCode())) return true;    //如果set添加失败表示有相同的值，则就是有环；
//            System.out.println(x.hashCode());
//        }
//
//        return false;   //遍历完整个链表，若没有相同的hashcode值，那么代表没有环

        //使用两个指针，一个遍历得快，一个遍历得慢；快指针会先于慢指针进入环，若快指针追上慢指针，那么就有环；否则快指针会先到达尾部；
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=slow){
            if (fast==null || fast.next==null) return false;   //这里fast==null这个判断一定要放在fast.next前面，不然若fast已经为空的话，fast.next是一个不存在的值；
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
