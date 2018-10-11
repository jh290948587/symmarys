package to_offer.lianbiao;

/**
 * Created by Administrator on 2018/5/21.
 */
public class OperationNode {
    public static void main(String[] args) {
//        addToTail test
//        ListNode l = new ListNode(3);
//        addToTail(null, 5);
//        System.out.println();


        int[] a = {1,2,3,4,5,6,7,8};
        int len = a.length;
        ListNode head = new ListNode(0);
        ListNode q =head;
        for(int i=0;i<a.length;i++){
            ListNode p = new ListNode(a[i]);
            q.next = p;
            q = p;
        }
        removeNode(head,2);
        removeNode(head,7);
        ListNode p=head.next;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }

    /**
     * 向链表末尾添加节点
     * @param headNode
     * @param val
     */
    public static void addToTail(ListNode headNode, int val) {
//        首先构建要添加的节点
        ListNode tailNode = new ListNode(val);
        tailNode.next = null;

        if(headNode == null){
            headNode = tailNode;
        }else{
            ListNode tempNode = headNode;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = tailNode;
        }

    }


    public static void removeNode(ListNode headNode, int val) {
        if(headNode != null){
            ListNode p = headNode;
            ListNode q=p.next;
            while(q!=null){
                if(q.val == val){
                    p.next = q.next;
                    q = q.next;
                }else {
                    p = q;
                    q = q.next;
                }
            }
        }

    }

}
