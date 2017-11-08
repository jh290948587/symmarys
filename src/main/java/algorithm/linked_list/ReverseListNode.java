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

        ListNode listNode = iterativeReverse(n1);
//        ListNode listNode2 = recursiveReverse(n1);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
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
        ListNode curr = head.next;
        ListNode newHead = recursiveReverse(curr);
        curr.next = head;
        head.next = null;
        return newHead;
    }
}
