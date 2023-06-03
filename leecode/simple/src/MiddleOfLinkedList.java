public class MiddleOfLinkedList {

    /**
     * 这题应该使用快慢指针解决
     */
    class Solution{
        public ListNode middleNode(ListNode head) {
            int len = 0;
            if (head == null) return null;
            ListNode node = head;
            while (node!=null){
                len++;
                node = node.next;
            }

            len = len / 2;
            int count = 0;
            while (count++ != len) head = head.next;

            return head;
        }
    }

    class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        Solution solution = middleOfLinkedList.new Solution();

        ListNode listNode5 = middleOfLinkedList.new ListNode(5);
        ListNode listNode4 = middleOfLinkedList.new ListNode(4, listNode5);
        ListNode listNode3 = middleOfLinkedList.new ListNode(3, listNode4);
        ListNode listNode2 = middleOfLinkedList.new ListNode(2, listNode3);
        ListNode listNode1 = middleOfLinkedList.new ListNode(1, listNode2);

        ListNode node = solution.middleNode(listNode1);
        System.out.println(node.val);
    }

}
