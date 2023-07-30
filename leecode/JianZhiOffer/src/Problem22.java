public class Problem22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode fast = head;
            ListNode slow = head;

            while (head != null){
                if (k-- >= 1){
                    fast = fast.next;
                } else {
                    slow = slow.next;
                }
                head = head.next;
            }

            return slow;
        }
    }



}
