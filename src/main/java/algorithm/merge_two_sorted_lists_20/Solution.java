package algorithm.merge_two_sorted_lists_20;

import algorithm.linked_list.ListNode;

public class Solution {
    public static void main(String[] args) {
//        准备数据
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(9);

//        调用合并方法
        ListNode listNode = mergeTwoLists2(l1, l2);

//        遍历合并后的链表
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }

//    解法一
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
//        两个单链表都不为空，则l1和l2进行比较
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
//                将两者中的最小值赋给cur.next，l1或者l2也变成自己的下一个
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
//            当前最小的赋给cur
            cur = cur.next;
        }
//        有一个为空，则把另一个单链表剩下的元素全接到新单链表中
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

//    解法二：递归
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = (l1.val < l2.val) ? l1 : l2;
        ListNode nonhead = (l1.val < l2.val) ? l2 : l1;
        head.next = mergeTwoLists2(head.next, nonhead);
        return head;
    }


}
