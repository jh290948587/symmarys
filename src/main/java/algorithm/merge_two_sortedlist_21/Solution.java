package algorithm.merge_two_sortedlist_21;



/**
 * Created by Administrator on 2017/11/1.
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(2);
        ListNode m1 = new ListNode(7);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(4);
        ListNode m4 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        Solution s = new Solution();
        ListNode listNode = s.mergeTwoLists(n1, m1);
        System.out.println(listNode);

    }
}
