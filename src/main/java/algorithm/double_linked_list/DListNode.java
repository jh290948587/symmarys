package algorithm.double_linked_list;

/**
 * Created by Administrator on 2017/10/30.
 */
public class DListNode {
    public int val;
    public DListNode prev,next;
    public DListNode(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
