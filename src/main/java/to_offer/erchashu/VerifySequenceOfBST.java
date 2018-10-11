package to_offer.erchashu;

/**
 * Created by Administrator on 2018/6/28.
 */

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是返回true，否则返回false。假设输入的数组的任意两个数字互不相同。
 */
public class VerifySequenceOfBST {

    public static boolean verifySequenceOfBST(int[] sequence, int start, int end){
        if(sequence == null || start < 0 || end < 0){
            return false;
        }

        int root = sequence[end];

        int i = start;
        for( ; i < end; i++){
            if(sequence[i] > root){
                break;
            }
        }

        for(int j = i; j < end; j++){
            if(sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if(i > start){
            left = verifySequenceOfBST(sequence, start, i - 1);
        }

        boolean right = true;
        if(i < end - 1){

            right = verifySequenceOfBST(sequence, i , end - 1);
        }

        return (left && right);

    }
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 9, 11, 10, 8};
//        int[] b = new int[]{7, 4, 6, 5};
//        int[] c = new int[]{11, 10, 9, 8};
        System.out.println(verifySequenceOfBST(a, 0, a.length - 1));
//        System.out.println(verifySequenceOfBST(b, 0, b.length - 1));
//        System.out.println(verifySequenceOfBST(c, 0, c.length - 1));

    }

}
