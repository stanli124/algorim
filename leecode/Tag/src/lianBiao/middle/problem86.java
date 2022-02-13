/** 分隔链表
 *  给你一个链表的头节点head和一个特定值x
 *  请对链表进行分隔，使得所有小于x的节点都出现在 大于等于x的节点之前
 *  且需要保留两边中每个节点的初始相对位置。
 */

package lianBiao.middle;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class problem86 {

    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode headS = new ListNode(-1);
            ListNode headL = new ListNode(-2);
            ListNode finalHead = headS;
            ListNode midHead = headL, preNode = null;

            while(head!=null){
                if(head.val < x){
                    headS.next = head;
                    headS = headS.next;
                }
                else{
                    headL.next = head;
                    headL = headL.next;
                }
                preNode = head;
                head = head.next;
                preNode.next = null; //需要将前一个节点到当前节点的连接切断，不然可能会产生环路

            }

            if(midHead.next != null){
                headS.next = midHead.next;
            }

            return finalHead.next;

        }
    }

}
