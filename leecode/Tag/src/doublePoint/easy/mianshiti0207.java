/** 面试题0207 链表相交
 *  给定两个单链表的头节点headA和headB，找出并返回两个单链表相交的起始节点
 *  没有交点返回null
 */

package doublePoint.easy;

public class mianshiti0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        if(headA==null || headB==null) return null;

        while(A != null && B != null){
            if(A==B) return A;
            A = A.next;
            B = B.next;
        }

        if(A==null) {  //如果A链表先跑完了，则放到B链表上去继续跑
            A=headB;
        }
        else B=headA;

        while(A != null && B != null){
            if(A==B) return A;
            A = A.next;
            B = B.next;
        }

        if(A==null) { //B跑完了，把B放到A上面去跑
            A=headB;
        }else B=headA;

        while(A != null && B != null){ //这个时候两个指针指向的是两个链表中的相同索引的节点。
            if(A==B) return A;
            A = A.next;
            B = B.next;
        }

        return null;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

}
