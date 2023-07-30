public class Problem52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode p = headA;
            ListNode q = headB;

            while (p!=null && q!=null){
                p = p.next;
                q = q.next;
            }
            if (q!=null){
                p = headB; // q不等于null
                while (q!=null){
                    q = q.next;
                    p = p.next;
                }
                q = headA;
            } else {
                q = headA; // p不等于null
                while (p!=null){
                    p = p.next;
                    q = q.next;
                }
                p = headB;
            }
            while (p != null && q != null){
                if (p == q) return p;
                p = p.next;
                q = q.next;
            }
            return null;
        }
    }

}
