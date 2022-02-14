/**
 * 两数相加
 * 给定两个非空的链表，表示两个非负的整数。每位数字都是以逆序的方式存储的。
 * 请将这两个数字相加，并也以逆序的方式返回总和。
 */


package lianBiao.middle;

public class problem2 {

    public static void main(String[] args) {
        System.out.println(Math.pow(10,2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
