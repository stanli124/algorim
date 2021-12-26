/** 合并两个有序链表
 *  将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  [1,2,4] [1,3,4] = 1,1,2,3,4
 *  [] [] = []   两个都是空链表则返回空链表
 *
 */

package lianbiao;


class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2() {}
      ListNode2(int val) { this.val = val; }
      ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 }


public class Day7_2 {

    public static void main(String[] args) {

        ListNode2 list1 = null;
        ListNode2 list2 = null;

        System.out.println(mergeTwoLists(list1, list2));
    }

    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        if (list2==null && (list1!=null || list1==null)) return list1;
        if (list1==null && list2!=null) return list2;

        ListNode2 p1 = list1;    //p1指向链表1 p2指向链表2
        ListNode2 p2 = list2;
        ListNode2 saveAddress = new ListNode2();   //使用一个额外指针来改变两个链表中元素的指向；最后返回头指针即可；

        while (p1 != null && p2 != null ){
            if (p1.val >= p2.val){
                saveAddress.next = p2;
                saveAddress = saveAddress.next;
                p2 = p2.next;
            }
            else{
                saveAddress.next = p1;
                saveAddress = saveAddress.next;
                p1 = p1.next;
            }
        }
        if (p1!=null) saveAddress.next = p1;
        if (p2!=null) saveAddress.next = p2;
        if (list1.val >= list2.val) return list2;
        else return list1;


    }

}
