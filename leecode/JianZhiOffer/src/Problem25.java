public class Problem25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1);
            ListNode h = head;

            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                } else {
                    head.next = l1;
                    l1 = l1.next;
                }
                head = head.next;
            }

            while (l1 != null){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
            while (l2 != null){
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }

            return h.next;

        }
    }

}
