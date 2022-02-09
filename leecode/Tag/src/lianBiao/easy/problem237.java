/** 删除链表中的节点
 *  删除单链表中某个特定节点：无法访问链表的头节点head，只能直接访问要被删除的节点。
 */

package lianBiao.easy;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class problem237 {

    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null ){ //当前节点还有后继节点
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

}
