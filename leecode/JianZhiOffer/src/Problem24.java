public class Problem24 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head==null || head.next == null) return head;
            ListNode next = head.next;
            ListNode newHead = reverseList(head.next);
            head.next = null;
            next.next = head;
            return newHead;
        }
    }

    public static void main(String[] args) {
        Problem24 problem24 = new Problem24();
        Solution solution = problem24.new Solution();
        ListNode node1 = problem24.new ListNode(1);
        ListNode node2 = problem24.new ListNode(2);
        ListNode node3 = problem24.new ListNode(3);
        ListNode node4 = problem24.new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = solution.reverseList(node1);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
