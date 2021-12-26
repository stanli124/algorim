/** 反转链表
 *  给你单链表的头结点head，请反转链表，并返回反转后的链表；
 *
 */


package lianbiao;


class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4() {}
    ListNode4(int val) { this.val = val; }
    ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
}


public class Day8_1 {

    public static void main(String[] args) {

    }

    public static ListNode4 reverseList(ListNode4 head) {
        //迭代方式反转；
//        if (head==null || head.next==null) return head;
//        ListNode4 reverse = new ListNode4();
//        ListNode4 p = null;
//
//        while (head!=null){
//            p=head;
//            head = head.next;
//
//            p.next = reverse.next;
//            reverse.next = p;
//        }
//        return reverse;


        //递归方式反转；
        if (head == null || head.next == null) {
            return head;
        }
        ListNode4 newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null; //这一句不能去掉吗，因为当递归到原始链表的开头时，因为没有元素了，所以开头元素的指针域会指向下一个元素，而这时下一个元素也指向开头元素，就形成了循环。
        return newHead;


    }

}
