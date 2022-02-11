/** 回文链表
 * 给定一个单链表的头节点head，请判断该链表是否为回文链表。
 *
 */

package lianBiao.easy;

import java.util.ArrayList;

public class problem234 {

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;

        for(; i<=j; i++,j--){
            if(list.get(i) != list.get(j)) return false;
        }

        return true;
    }

}
