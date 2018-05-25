package to_offer.lianbiao;

/**
 * Created by Administrator on 2018/5/21.
 */
public class AddNode {
    public static void main(String[] args) {
        ListNode l = new ListNode(3);
        addToTail(null, 5);
        System.out.println();
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

        }

    }

}
