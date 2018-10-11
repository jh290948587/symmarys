package algorithm.linked_list;

/**
 * Created by Administrator on 2017/10/30.
 */
public class ReverseListNode {
//    单链表测试
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

//        ListNode listNode = iterativeReverse(n1);
        ListNode listNode2 = recursiveReverse(n1);
        while(listNode2 != null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }
    }


    // iterative method
    public static ListNode iterativeReverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // recursive method
    public static ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = recursiveReverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
