package to_offer.lianbiao;

/**
 * Created by Administrator on 2018/5/29.
 */
public class DaoxuDayinListNode {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        int len = a.length;
        ListNode head = new ListNode(0);
        ListNode pre =head;
        for(int i=0;i<a.length;i++){
            ListNode curr = new ListNode(a[i]);
            pre.next = curr;
            pre = curr;
        }
        recursionImpl(head);
    }

    /**
     * 使用栈实现
     */
    public static void stackImpl(ListNode headNode){

    }

    /**
     * 使用递归实现
     */
    public static void recursionImpl(ListNode headNode){
        if(headNode != null && headNode.next != null) {
            recursionImpl(headNode.next);
        }
        System.out.println(headNode.val);
    }
}
