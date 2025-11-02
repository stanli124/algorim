import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode listNode5 = new ListNode(1, listNode4);

        RSolution rSolution = new RSolution();
        ListNode listNode51 = listNode5;
        while (listNode51 != null) {
            System.out.println(listNode51.val);
            listNode51 = listNode51.next;
        }


        ListNode listNode = rSolution.reverseList(listNode5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class RSolution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        ListNode next1 = head.next;
        head.next = null;
        next1.next = head;
        return next;
    }
}
