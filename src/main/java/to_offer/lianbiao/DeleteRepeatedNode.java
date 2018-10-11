package to_offer.lianbiao;

/**
 * Created by Administrator on 2018/6/25.
 */
public class DeleteRepeatedNode {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next.next.next = null;

        deleteDuplication(list1);
        System.out.println(list1);
    }


    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return null;

        ListNode preNode = null;
        ListNode node = pHead;
        while(node != null){
            ListNode nextNode = node.next;
            boolean needDelete = false;//判断相邻两个点是否相等
            if(nextNode != null && nextNode.val == node.val){
                needDelete = true;
            }
            if(!needDelete){
                preNode = node;
                node = node.next;
            }else{
                int value = node.val;

                ListNode toBeDel = node;
//                while(toBeDel != null && toBeDel.val == value){
//                    nextNode = toBeDel.next;
//
//                    toBeDel = nextNode;
//                    //此处不能少，找到第一个pHead，以后的preNode就不为null了
//                    if(preNode == null) {
//                        pHead = nextNode;
//                    } else {
//                        preNode.next = nextNode;
//                    }
//                    node = nextNode;
//                }

                while(toBeDel != null && toBeDel.val == value){
                    toBeDel = toBeDel.next;


                    //此处不能少，找到第一个pHead，以后的preNode就不为null了
                    if(preNode == null) {
                        pHead = toBeDel;
                    } else {
                        preNode.next = toBeDel;
                    }
                    node = toBeDel;
                }
            }
        }

        return pHead;
    }
}
