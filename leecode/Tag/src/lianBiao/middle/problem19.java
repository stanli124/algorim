/** 删除链表中倒数第n个节点，并返回链表头节点
 *
 */

package lianBiao.middle;

public class problem19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0) return head;
        ListNode fast=head, slow=head;
        int len = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            len++;
        }
        if (fast!=null) len = 2*len + 1;
        else if (fast == null) len = 2*len;
        // System.out.println(len);
        // len = len - n;
        fast = head;
        if(n == len) return head.next; //删除第一个元素
        else if(n == 1){ //删除最后一个元素
            len = len - n;
            for(; len > 1; len--){
                fast = fast.next;
            }
            fast.next = null;
        }
        else{
            len = len - n;
            for(; len > 1; len--){
                fast = fast.next;
            }
            fast.next = fast.next.next;
        }

        return head;
    }

}
