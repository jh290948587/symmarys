package to_offer.erchashu;

/**
 * Created by Administrator on 2018/7/1.
 */
public class TreeNodeToDoubleListNode {
    TreeNode head = null;
    TreeNode realHead = null;//双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return realHead;
    }

    public static void main(String[] args) {

        TreeNodeToDoubleListNode t = new TreeNodeToDoubleListNode();
//        t.Convert()
    }
}
