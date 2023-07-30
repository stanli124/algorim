import java.util.HashMap;
import java.util.Map;

public class Problem35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        Map<Node, Node> cacheNode = new HashMap<>();
//        public Node copyRandomList(Node head) {
//            if (head == null) return null;
//
//            Node headPointer = new Node(Integer.MIN_VALUE);
//            Node newHead = new Node(head.val);
//            headPointer.next = newHead;
//
//            while (head != null) {
//                newHead.next = new Node(head.next.val);
//                newHead.random = new Node(head.random.val);
//
//                newHead = newHead.next;
//                head = head.next;
//            }
//
//            return headPointer.next;
//        }

        public Node copyRandomList1(Node head) {
            if (head == null){
                return null;
            }

            if (!cacheNode.containsKey(head)){ // 不包含当前节点
                Node headNew = new Node(head.val);
                cacheNode.put(head, headNew);
                headNew.next = copyRandomList1(head.next);
                headNew.random = copyRandomList1(head.random);
            }
            return cacheNode.get(head);
        }

    }

    public static void main(String[] args) {

    }

}
