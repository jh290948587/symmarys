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
        ListNode listNode = recursiveReverse(n1);
        while(listNode != null ){
            System.out.println(listNode.val);
            listNode = listNode.next;
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
//        head == null是为了判断如果第一次的head就是空，直接返回。head.next == null是为了判断当前节点是不是最后一个，这是递归结束的标志
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
