package to_offer.lianbiao;

/**
 * Created by Administrator on 2018/6/19.
 */
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next = null;

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = null;

//        ListNode listNode = mergeList(list1, list2);
        ListNode listNode = mergeList2(list1, list2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static ListNode mergeList(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null)
            return null;
        if(list1==null&&list2!=null)
            return list2;
        if(list1!=null&&list2==null)
            return list1;
        ListNode head = null;
        if(list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        cur.next=null;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if(list1==null&&list2!=null){
            cur.next =list2;
        }else if(list2==null&&list1!=null){
            cur.next = list1;
        }
        return head;
    }


    public static ListNode mergeList2(ListNode list1, ListNode list2){
        /**
         * 递归时如果其中一个链表为空，返回另一个链表
         */
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

//        定义结果链表的头结点
        ListNode headList = null;

        if(list1.val < list2.val){
            headList = list1;
            headList.next = mergeList2(list1.next,list2);
        }else{
            headList = list2;
            headList.next = mergeList2(list1,list2.next);
        }
        return headList;
    }
}
