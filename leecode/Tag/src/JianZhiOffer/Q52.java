package JianZhiOffer;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class Q52 {

    public static void main(String[] args) {



    }


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA==null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while (a != b){
            if (a == null){
                a = headB;
            }else {
                a = a.next;
            }

            if (b==null){
                b = headA;
            }else {
                b = b.next;
            }
        }

        return a;

//        while (headA != null || headB != null){
//            headA = headA.next;
//            headB = headB.next;
//            if (headA == null) {
//                headA = b;
//                break;
//            }
//            else if (headB == null) {
//                headB = a;
//                break;
//            }
//        }
//
//        if (headA == b){
//            while (headB!=null) {
//                headA = headA.next;
//                headB = headB.next;
//            }
//            headB = a;
//        }
//        if (headB == a){
//            while (headA!=null){
//                headA = headA.next;
//                headB = headB.next;
//            }
//            headA = b;
//        }
//
//        while (headA != headB){
//            headA = headA.next;
//            headB = headB.next;
//        }
//
//        return headA;

    }



}
