/** 删除排序链表中的重复元素（2）
 *  给定一个已经排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字
 *  返回已排序的链表
 */

package lianBiao.middle;

public class problem82 {

    public static void main(String[] args) {

    }

    //自己的解答
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curNode = head, preNode = null;
        while(curNode != null && curNode.next != null){
            if(curNode.val == curNode.next.val){ //当前节点的值和下一个节点的值一样就删除下一个节点
                while(curNode.next!=null && curNode.val == curNode.next.val){ //这个while找到了最后一个重复元素的位置
                    curNode = curNode.next;
                }

                //这个时候preNode为null的话，表明一开始就是重复元素;
                if(preNode==null){
                    head = curNode.next;
                }
                else if(preNode!=null){//不为null，表明链表中间的重复元素
                    preNode.next = curNode.next;
                }
                curNode = curNode.next;
            }
            else if(curNode.val != curNode.next.val){ //当前节点和下一个节点的值不一样
                preNode = curNode;//保存重复数字的前一个数字
                curNode = curNode.next;
            }
        }
        return head;
    }

    //官方的解答：一次迭代就删除一个节点
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);

            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }


}
