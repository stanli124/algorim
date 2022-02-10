/** 相交链表
 *  给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。
 *  如果两个链表不存在相交节点，则返回null
 */

package lianBiao.easy;

import java.util.HashSet;
import java.util.Set;

public class problem160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if((headA == null) || (headB == null))
            return null;
        ListNode rootB = headB;
        while(headA != null){
            headB = rootB;
            while(headB != null){
                if (headA == headB && headA.val == headB.val){
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
        }
        return null;
    }

}
