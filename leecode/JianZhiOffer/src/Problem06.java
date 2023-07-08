import java.util.LinkedList;
import java.util.List;

public class Problem06 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    class Solution{
        public int[] reversePrint(ListNode head){
            LinkedList<Integer> list = new LinkedList<>();
            while (head != null){
                list.addFirst(head.val);
                head = head.next;
            }
            int[] a = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                a[i] = list.get(i);
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Problem06 problem06 = new Problem06();
        Solution solution = problem06.new Solution();
        ListNode node1 = problem06.new ListNode(1);
        ListNode node2 = problem06.new ListNode(2);
        ListNode node3 = problem06.new ListNode(3);
        ListNode node4 = problem06.new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int[] reversed = solution.reversePrint(node1);
        for (int n : reversed){
            System.out.printf("%d ", n);
        }
    }

}
