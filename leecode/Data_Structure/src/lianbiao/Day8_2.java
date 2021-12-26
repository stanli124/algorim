/** 删除排序链表中的重复元素
 *  存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *  返回同样按升序排列的结果链表
 *
 *  比较当前指针 和 当前指针的下一个指针 的值，若一样就删除下一个的值；若不一样当前指针就往后移动，以此类推，直到当前指针为nul退出；
 *
 */

package lianbiao;


class ListNode5 {
    int val;
    ListNode5 next;
    ListNode5() {}
    ListNode5(int val) { this.val = val; }
    ListNode5(int val, ListNode5 next) { this.val = val; this.next = next; }
}


public class Day8_2 {

    public static void main(String[] args) {

    }

    public static ListNode5 deleteDuplicates(ListNode5 head) {
        ListNode5 p = head;
        while (head!=null && head.next!=null){
//            p = head.next;
            if (head.val == head.next.val){
                head.next = head.next.next;
            }
            else head = head.next;
        }

        return p;
    }

}
