import java.util.HashSet;
import java.util.Set;

public class TwoLinkedLists {
    public static void main(String[] args) {

    }
}

class TSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        Set<ListNode> listANodeSet = new HashSet<>();
        while (a != null) {
            listANodeSet.add(a);
            a = a.next;
        }
        while (b != null) {
            if (listANodeSet.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else pA = pA.next;
            if (pB == null) {
                pB = headA;
            } else pB = pB.next;
        }
        return pB;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
