public class Palindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        listNode1.val = 2;
        listNode.val = 1;
        listNode.next = listNode1;
        SSolution4 sSolution4 = new SSolution4();
        sSolution4.isPalindrome(listNode);
    }
}


class SSolution4 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while (p != null) {
            stringBuilder.append(p.val);
             p = p.next;
        }
        String builderString = stringBuilder.toString();
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString().equals(builderString);
    }
}