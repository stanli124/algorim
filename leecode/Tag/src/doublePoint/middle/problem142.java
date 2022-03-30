/** 环形链表
 *  给定一个头节点，返回链表开始入环的第一个节点，如果无环，则返回null
 */

package doublePoint.middle;

import java.util.HashSet;

public class problem142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        HashSet<ListNode> set = new HashSet();

        ListNode pos = head;
        while(pos!=null){
            if(set.contains(pos)) return pos;
            else{
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;

    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }