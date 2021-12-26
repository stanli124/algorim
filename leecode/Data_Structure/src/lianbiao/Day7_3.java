/** 移除链表元素
 *  给你一个链表的头节点head和一个整数 val，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点。
 *
 *  给你一个链表的头结点head 和 一个整数val，请你删除链表中所有满足Node.val == val的节点，并返回新的头结点；
 *
 *
 */

package lianbiao;


class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}


public class Day7_3 {

    public static void main(String[] args) {

        ListNode3 head=null;
        int val=6;
        System.out.println(removeElements(head, val));

    }

    public static ListNode3 removeElements(ListNode3 head, int val) {
        if (head==null) return head;
        ListNode3 newHead = null;
        ListNode3 p = head;
        ListNode3 pre = new ListNode3(Integer.MIN_VALUE);
        pre.next = head;

        while (p!=null){   //取得第一个不为6的节点引用；
            if (p.val!=val){
                newHead = p;
                break;
            }
            else p=p.next;
        }

        while (head!=null){
            if (head.val == val){
                pre.next = head.next;
                head = pre.next;
            }
            else {
                pre = head;
                head = head.next;
            }
        }
        return newHead;

    }

}
