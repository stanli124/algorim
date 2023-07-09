public class Problem18 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution{
        public ListNode deleteNode(ListNode head, int val){
            ListNode pre = null;
            ListNode tou = new ListNode(-1);
            tou.next = head;
            ListNode node = tou;
            while (node != null && node.val != val){
                pre = node;
                node = node.next;
            }
            if (node.val == val){
                pre.next = node.next;
                node.next = null;
            }
            return tou.next;
        }
    }

}
