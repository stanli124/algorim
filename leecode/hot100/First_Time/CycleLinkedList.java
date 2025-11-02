import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleLinkedList {
    public static void main(String[] args) {

    }
}

class CSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastP = head.next;
        ListNode slowP = head;

        while (fastP != slowP) {
            if (fastP == null || fastP.next == null) {
                return false;
            }
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return true;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode p = head;
        Set<ListNode> nodeSet = new HashSet<>();
        while (p != null) {
            if (nodeSet.contains(p)) {
                return true;
            } else {
                nodeSet.add(p);
                p = p.next;
            }
        }
        return false;
    }
}